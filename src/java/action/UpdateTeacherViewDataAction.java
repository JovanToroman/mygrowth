/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import constants.WebConstants;
import dbbroker.DBBroker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import model.Competence;
import model.Migrant;
import model.Result;
import model.Studentresults;
import model.StudentresultsPK;
import model.Teacher;

/**
 *
 * @author Solstinger_
 */
public class UpdateTeacherViewDataAction extends AbstractAction {

    public UpdateTeacherViewDataAction() {
    }

    @Override
    public String execute(HttpServletRequest request) {
        Migrant m = (Migrant) request.getSession().getAttribute(WebConstants.MIGRANT_LOGGED_IN);
        Teacher t = (Teacher) request.getSession().getAttribute(WebConstants.TEACHER_LOGGED_IN);
        List<Studentresults> listOfStudentResults = (List<Studentresults>) request.getSession().getAttribute(WebConstants.STUDENT_RESULTS_EVALUATION);
        List<Result> listOfResults = (List<Result>) request.getSession().getAttribute(WebConstants.STUDENT_RESULTS);
        List<Competence> listOfCompetences = (List<Competence>) request.getSession().getAttribute(WebConstants.STUDENT_COMPETENCES);
        List<Result> listOfResultsMarkedForDeletion = new ArrayList<>();
        List<Result> listOfNewResults = new ArrayList<>();
        Map map = request.getParameterMap();
        Enumeration en = request.getParameterNames();
        List<Integer> listOfResultIDs = new ArrayList<>();
        for (Object parameter : Collections.list(en)) {
            String parnam = (String) parameter;
            if (parnam.startsWith("input")) {
                listOfResultIDs.add(Integer.valueOf(parnam.substring(5)));
            }
            if (parnam.startsWith("delete")) {
                for (Result res : listOfResults) {
                    if (res.getResultName().equals(parnam.substring(6))) {
                        listOfResultsMarkedForDeletion.add(res);                        
                    }
                }
            }
            if (parnam.startsWith("newinput")) {
                String[] temp = parnam.substring(8).split("_");
                String resultName = temp[0];
                String competenceName = temp[1];
                Result r = new Result();
                for (Competence comp : listOfCompetences) {
                    if (comp.getCompetenceName().equals(competenceName)) {
                        System.out.println("Ime kompetencije iz kolekcije koju treba da dodelim: " + comp.getCompetenceName());
                        r.setCompetenceID(comp);
                    }
                }
                r.setResultName(resultName);
                r.setResultID(listOfResults.get(listOfResults.size() - 1).getResultID() + 1);
                System.out.println("ID novog rezultata: "+r.getResultID());
                listOfNewResults.add(r);
                listOfResults.add(r);
            }
        }
        for (Integer resultID : listOfResultIDs) {
            Result res = null;
            for (Result result : listOfResults) {
                if (Objects.equals(result.getResultID(), resultID)) {
                    res = result;
                }
            }
            System.out.println("Rezultat koji dobijem iz for-a: " + res);
            Studentresults srl = new Studentresults(new StudentresultsPK(resultID, m.getStudentCode(), t.getTeacherCode()));
            srl.setResult(res);
            String note = Arrays.toString((String[]) map.get("input" + resultID)).replace("[", "");
            note = note.replace("]", "");
            srl.setNote(note);
            String level = Arrays.toString((String[]) map.get("radio" + resultID)).replace("[", "");
            level = level.replace("]", "");
            srl.setLevel(level);
            listOfStudentResults.add(srl);
        }
        for (Result newResult : listOfNewResults) {
            Studentresults srl = new Studentresults(new StudentresultsPK(newResult.getResultID(), m.getStudentCode(), t.getTeacherCode()));
            srl.setResult(newResult);
            String note = Arrays.toString((String[]) map.get("newinput" + newResult.getResultName() + "_" + newResult.getCompetenceID().getCompetenceName())).replace("[", "");
            note = note.replace("]", "");
            srl.setNote(note);
            String level = Arrays.toString((String[]) map.get("newradio" + newResult.getResultName())).replace("[", "");
            level = level.replace("]", "");
            srl.setLevel(level);
            listOfStudentResults.add(srl);
            System.out.println("Lista rezultata studenata sa dodatim novim: "+listOfStudentResults+"\n");
        }
        System.out.println("Lista rezultata za brisanje: "+listOfResultsMarkedForDeletion);
        for (Result res : listOfResultsMarkedForDeletion) {
            DBBroker.getInstance().deleteRecord(new Studentresults(res.getResultID(), m.getStudentCode(), t.getTeacherCode()));
            DBBroker.getInstance().deleteRecord(res);
            listOfResults.remove(res);
        }

        for (Result newRes : listOfNewResults) {
            DBBroker.getInstance().addRecord(newRes);
            System.out.println("Novi rezultati: " + newRes);
        }
        for (Studentresults studentResult : listOfStudentResults) {
            DBBroker.getInstance().updateRecord(studentResult);
        }

        System.out.println("Rezultati studenata na kraju updatea teachera: " + listOfStudentResults + "\n");
        Map numberOfResultsPerCompetence = new HashMap();
        for (Competence com : listOfCompetences) {
            numberOfResultsPerCompetence.put(com.getCompetenceName(), com.getNumberOfResults(listOfStudentResults));
        }
        request.getSession().setAttribute(WebConstants.NUMBER_OF_RESULTS_PER_COMPETENCE, numberOfResultsPerCompetence);
        request.getSession().setAttribute(WebConstants.STUDENT_RESULTS_EVALUATION, listOfStudentResults);
        request.getSession().setAttribute(WebConstants.STUDENT_RESULTS, listOfResults);
        request.getSession(false).setAttribute(WebConstants.TEACHER_VIEW_DATA_SUCCESSFULLY_UPDATED, true);
        return WebConstants.PAGE_TEACHER_SELECT_ACTION;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import constants.WebConstants;
import dbbroker.DBBroker;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import jdk.nashorn.internal.runtime.JSType;
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
        List<Studentresults> listOfStudentResults = new ArrayList<>();
        List<Result> listOfResults = (List<Result>) request.getSession().getAttribute(WebConstants.STUDENT_RESULTS);
        List<Competence> listOfCompetences = (List<Competence>) request.getSession().getAttribute(WebConstants.STUDENT_COMPETENCES);
        List<Result> listOfResultsMarkedForDeletion = new ArrayList<>();
        Map map = request.getParameterMap();
        Enumeration en = request.getParameterNames();
        List<Integer> listOfResultIDs = new ArrayList<>();
        List<String> listOfResultNames = new ArrayList<>();
        for (Object parameter : Collections.list(en)) {
            String parnam = (String) parameter;
            if (parnam.startsWith("input")) {
                if(parnam.length() < 9){
                    listOfResultIDs.add(Integer.valueOf(parnam.substring(5)));
                } else {
                    listOfResultNames.add(String.valueOf(parnam.substring(5)));
                }
            }
            if (parnam.startsWith("delete")) {
                for (Result res : listOfResults) {
                    if (res.getResultName().equals(parnam.substring(6))) {
                        listOfResultsMarkedForDeletion.add(res);
                    }
                }
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

        for (String resultName : listOfResultNames) {
            System.out.println("Ime rezultata iz imena rez.: "+resultName);
            Result res = null;
            for (Result result : listOfResults) {
                if (Objects.equals(result.getResultName(), resultName)) {
                    res = result;
                }
            }
            System.out.println("Rezultat koji dobijem iz for-a za nove rezultate: " + res);
            if (res != null) {
                Studentresults srl = new Studentresults(new StudentresultsPK(res.getResultID(), m.getStudentCode(), t.getTeacherCode()));
                srl.setResult(res);
                String note = Arrays.toString((String[]) map.get("input" + resultName)).replace("[", "");
                note = note.replace("]", "");
                srl.setNote(note);
                String level = Arrays.toString((String[]) map.get("radio" + resultName)).replace("[", "");
                level = level.replace("]", "");
                srl.setLevel(level);
                listOfStudentResults.add(srl);
            }
        }

        System.out.println("Lista rezultata za brisanje: " + listOfResultsMarkedForDeletion);
        for (Result res : listOfResultsMarkedForDeletion) {
            DBBroker.getInstance().deleteRecord(new Studentresults(res.getResultID(), m.getStudentCode(), t.getTeacherCode()));
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
        request.getSession(false).setAttribute(WebConstants.TEACHER_VIEW_DATA_SUCCESSFULLY_UPDATED, false);
        return WebConstants.PAGE_TEACHER_SELECT_ACTION;
    }

}

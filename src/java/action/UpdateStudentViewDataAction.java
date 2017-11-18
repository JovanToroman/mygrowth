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
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import model.Migrant;
import model.Studentsubjects;
import model.StudentsubjectsPK;
import model.Subject;
import util.ImageUpload;

/**
 *
 * @author Solstinger_
 */
public class UpdateStudentViewDataAction extends AbstractAction {

    public UpdateStudentViewDataAction() {
    }

    @Override
    public String execute(HttpServletRequest request) {
        Migrant m = (Migrant) request.getSession().getAttribute(WebConstants.MIGRANT_LOGGED_IN);
        String studCode = m.getStudentCode();
        System.out.println(m.getStudentCode());
        List<Studentsubjects> listOfSubjectEvaluations = new ArrayList<>();
        List<Subject> listOfSubjects = new ArrayList<>();
        List<Subject> listOfSubjectsMarkedForDeletion = new ArrayList<>();
        Map map = request.getParameterMap();
        Enumeration en = request.getParameterNames();

        for (Object parameter : Collections.list(en)) {//citanje primljenih parametara
            String parnam = (String) parameter;
            System.out.println("Parametar: "+parnam);
            if (parnam.startsWith("input")) {
                String imageUrl = "";
                try { //handling image upload                    
                    imageUrl = ImageUpload.uploadImage(request, "subjectImage" + parnam.substring(5), "");
                    listOfSubjects.add(new Subject(parnam.substring(5), imageUrl));
                    System.out.println("Lista predmeta u foru: "+listOfSubjects);
                } catch (java.io.IOException | ServletException je) {
                    Logger.getLogger(UpdateStudentViewDataAction.class.getName()).log(Level.SEVERE, null, je);
                }
            }
            if (parnam.startsWith("delete")) {
                listOfSubjectsMarkedForDeletion.add(new Subject(parnam.substring(6), ""));
            }
        }
        for (Subject subj : listOfSubjects) { //update subject evaluations
            if (subj.getImageUrl().equals("")) {
                try {
                    Subject s = (Subject) DBBroker.getInstance().getRecord(subj);
                    subj.setImageUrl(s.getImageUrl().toLowerCase());
                } catch (Exception ex) {
                    Logger.getLogger(UpdateStudentViewDataAction.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            Studentsubjects ssub = new Studentsubjects(studCode, subj.getSubjectName());
            String eval = Arrays.toString((String[]) map.get("input" + subj.getSubjectName())).replace("[", "");
            eval = eval.replace("]", "");
            ssub.setEvaluation(eval);
            String level = Arrays.toString((String[]) map.get("radio" + subj.getSubjectName())).replace("[", "");
            level = level.replace("]", "");
            ssub.setLevel(level);
            ssub.setSubject(subj);
            listOfSubjectEvaluations.add(ssub);
            System.out.println("Lista evaluacija na kraju fora: " + listOfSubjectEvaluations);
        }
        System.out.println("Lista za brisanje pre brisanja: " + listOfSubjectsMarkedForDeletion);
        for (Subject subject : listOfSubjectsMarkedForDeletion) {
            DBBroker.getInstance().deleteRecord(new Studentsubjects(new StudentsubjectsPK(studCode, subject.getSubjectName())));
            DBBroker.getInstance().deleteRecord(subject);
        }
        System.out.println("Lista predmeta: " + listOfSubjectEvaluations.size());
        for (Subject subj : listOfSubjects) {
            DBBroker.getInstance().addRecord(subj);
        }

        for (Studentsubjects subject : listOfSubjectEvaluations) {
            DBBroker.getInstance().updateRecord(subject);
        }
        request.getSession(false).setAttribute(WebConstants.STUDENT_SUBJECTS, listOfSubjectEvaluations);
        System.out.println("Lista nova: " + request.getSession(false).getAttribute(WebConstants.STUDENT_SUBJECTS));
        request.getSession(false).setAttribute(WebConstants.STUDENT_VIEW_DATA_SUCCESSFULLY_UPDATED, true);
        return WebConstants.PAGE_TEACHER_SELECT_ACTION;
    }

}

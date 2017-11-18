/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import constants.WebConstants;
import dbbroker.DBBroker;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Teacher;
import model.Migrant;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Competence;
import model.Studentresults;

/**
 *
 * @author student
 */
public class LoginTeacherAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        try {
            String studentCode = request.getParameter("inputSifraMigranta");
            String teacherCode = request.getParameter("inputSifraUcitelja");
            Migrant inputM = new Migrant(studentCode);
            Migrant m = (Migrant) DBBroker.getInstance().getRecord(inputM);
            Teacher inputT = new Teacher(teacherCode);
            Teacher t = (Teacher) DBBroker.getInstance().getRecord(inputT);            
            HttpSession sesija = request.getSession(true);
            List<Studentresults> studentResults = (List<Studentresults>) DBBroker.getInstance().getRecords(m);
            System.out.println("Rezultati studenata od dbbrokera: "+studentResults+"\n");
            List<Competence> competences = (List<Competence>) DBBroker.getInstance().getRecords(new Competence());
            Map numberOfResultsPerCompetence = new HashMap();
            for (Competence com : competences) {
                numberOfResultsPerCompetence.put(com.getCompetenceName(), com.getNumberOfResults(studentResults));
            }
            sesija.setAttribute(WebConstants.NUMBER_OF_RESULTS_PER_COMPETENCE, numberOfResultsPerCompetence);
            sesija.setAttribute(WebConstants.MIGRANT_LOGGED_IN, m);
            sesija.setAttribute(WebConstants.TEACHER_LOGGED_IN, t);
            return WebConstants.PAGE_TEACHER_SELECT_ACTION;
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ex);
            return WebConstants.PAGE_TEACHER_LOGIN_BAD_LOGIN;
        }

    }

    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import constants.WebConstants;
import dbbroker.DBBroker;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Competence;
import model.Migrant;
import model.Result;
import model.Studentresults;

/**
 *
 * @author Solstinger_
 */
public class GenerateTeacherViewDataAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        try {
            HttpSession sesija = request.getSession(true);
            Migrant m = (Migrant) request.getSession().getAttribute(WebConstants.MIGRANT_LOGGED_IN);
            List<Result> results = (List<Result>) DBBroker.getInstance().getRecords(new Result());
            System.out.println("Results in action: "+results);
            List<Studentresults> studentResults = (List<Studentresults>) DBBroker.getInstance().getRecords(m);
            System.out.println("Student results in action: "+studentResults);
            List<Competence> competences = (List<Competence>) DBBroker.getInstance().getRecords(new Competence());
            System.out.println("Results in action: "+results);
            sesija.setAttribute(WebConstants.STUDENT_RESULTS_EVALUATION, studentResults);
            sesija.setAttribute(WebConstants.STUDENT_RESULTS, results);
            sesija.setAttribute(WebConstants.STUDENT_COMPETENCES, competences);
            return WebConstants.PAGE_TEACHER_VIEW;
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ex);
            return WebConstants.PAGE_TEACHER_LOGIN_BAD_LOGIN;
        }
    }    
}

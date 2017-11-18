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
import model.Migrant;
import model.Studentsubjects;
import model.StudentsubjectsPK;

/**
 *
 * @author Solstinger_
 */
public class EditStudentViewDeliverPageAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        try {
            HttpSession sesija = request.getSession(true);            
            if (sesija.getAttribute(WebConstants.STUDENT_SUBJECTS) == null) {
                Migrant m = (Migrant) request.getSession().getAttribute(WebConstants.MIGRANT_LOGGED_IN);
                Studentsubjects ss = new Studentsubjects(new StudentsubjectsPK(m.getStudentCode(), "N/A"));
                List<Studentsubjects> lista = (List<Studentsubjects>)DBBroker.getInstance().getRecords(ss);
                sesija.setAttribute(WebConstants.STUDENT_SUBJECTS, lista);
            }            
            return WebConstants.PAGE_TEACHER_EDIT_STUDENT_VIEW;
        } catch (Exception ex) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ex);
            return WebConstants.PAGE_TEACHER_LOGIN_BAD_LOGIN;
        }
    }
}

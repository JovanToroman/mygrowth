/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import constants.WebConstants;
import dbbroker.DBBroker;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import model.Migrant;
import model.Studentsubjects;
import model.StudentsubjectsPK;

/**
 *
 * @author Solstinger_
 */
public class LoginMigrantAction extends AbstractAction {

    @Override
    public String execute(HttpServletRequest request) {
        try {
            request.getSession().invalidate();
            String studentCode = request.getParameter("inputSifraMigranta");
            Migrant inputM = new Migrant(studentCode);
            Migrant m = (Migrant) DBBroker.getInstance().getRecord(inputM);
            HttpSession sesija = request.getSession(true);
            Studentsubjects ss = new Studentsubjects(new StudentsubjectsPK(studentCode, "N/A"));
            List<Studentsubjects> lista = (List<Studentsubjects>) DBBroker.getInstance().getRecords(ss);
            sesija.setAttribute(WebConstants.STUDENT_SUBJECTS, lista);
            sesija.setAttribute(WebConstants.MIGRANT_LOGGED_IN, m);
            return WebConstants.PAGE_MIGRANT_VIEW;
        } catch (Exception ex) {
            return WebConstants.PAGE_MIGRANT_LOGIN_BAD_LOGIN;
        }
    }
}

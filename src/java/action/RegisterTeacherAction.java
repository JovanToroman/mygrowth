/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import dbbroker.DBBroker;
import java.math.BigInteger;
import java.security.SecureRandom;
import javax.servlet.http.HttpServletRequest;
import model.Teacher;
import util.EmailUtil;

/**
 *
 * @author solstinger
 */
public class RegisterTeacherAction extends AbstractAction {

    public RegisterTeacherAction() {
    }

    @Override
    public String execute(HttpServletRequest request) {
        Teacher t = addTeacherKey(new Teacher());
        t.setCountryOfResidence(request.getParameter("country"));
        t.setFirstName(request.getParameter("first-name"));
        t.setLastName(request.getParameter("last-name"));
        t.setEmail(request.getParameter("email"));
        t.setEducationalInstitutionName(request.getParameter("institution"));
        EmailUtil.sendEmail(t.getEmail(), "Hi!\n\nWelcome to MeGrow: A platform for keeping track"
                + " of migrant students' education.\n\nHere is your teacher code: "
                +t.getTeacherCode()+"\n\nKeep it safe at ALL times. It serves"
                + " as your identity on our platform.\n\nNow let's go"
                + " help migrants make a better future for themselves!\n\nMeGrow team.", "Welcome to MeGrow!", "megroweducation@gmail.com");
        DBBroker.getInstance().addRecord(t);
        return "";
    }

    private Teacher addTeacherKey(Teacher t) {
        SecureRandom random = new SecureRandom();
        t.setTeacherCode(new BigInteger(90, random).toString(20));
        return t;
    }

}

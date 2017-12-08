/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import constants.WebConstants;
import dbbroker.DBBroker;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
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
        try {
            DBBroker.getInstance().addRecord(t);
            sendEmailTeacher(t, request);
            request.setAttribute(WebConstants.REGISTRATION_RESULT, WebConstants.REGISTRATION_SUCCESSFUL_MESSAGE);
        } catch (IOException | ServletException ex) {
            Logger.getLogger(RegisterStudentAction.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute(WebConstants.REGISTRATION_RESULT, WebConstants.REGISTRATION_UNSUCCESSFUL_MESSAGE);
        }
        return WebConstants.PAGE_TEACHER_SUCCESSFULLY_REGISTERED;

    }

    private Teacher addTeacherKey(Teacher t) {
        SecureRandom random = new SecureRandom();
        t.setTeacherCode(new BigInteger(70, random).toString(20));
        return t;
    }

    private void sendEmailTeacher(Teacher recipient, HttpServletRequest request) throws IOException, ServletException {
        EmailUtil.sendEmail(recipient.getEmail(), "Hi!\n\nWelcome to MyGrowth: A platform for keeping track"
                + " of migrant students' education.\n\nHere is your teacher code: "
                + recipient.getTeacherCode() + "\n\nKeep it safe at ALL times. It serves"
                + " as your identity on our platform.\n\nNow let's go"
                + " help migrants make a better future for themselves!\n\nMyGrowth team.", "Welcome to MyGrowth!", "megroweducation@gmail.com");
    }

}

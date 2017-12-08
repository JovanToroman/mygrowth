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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import model.Migrant;
import util.EmailUtil;
import util.ImageUpload;

/**
 *
 * @author solstinger
 */
public class RegisterStudentAction extends AbstractAction {

    public RegisterStudentAction() {
    }
/*TODO profile image upload processing */
    @Override
    public String execute(HttpServletRequest request) {
        Migrant m = addMigrantKey(new Migrant());
        System.out.println(m.getStudentCode());
        m.setCountryOfOrigin(request.getParameter("country"));
        System.out.println(m.getCountryOfOrigin());
        m.setMotherTongue(request.getParameter("language"));
        System.out.println(m.getMotherTongue());
        m.setFirstName(request.getParameter("first-name"));
        System.out.println(m.getFirstName());
        m.setLastName(request.getParameter("last-name"));
        System.out.println(m.getLastName());
        m.setEmail(request.getParameter("email"));
        System.out.println(m.getEmail());
        try {
            m.setDateOfBirth(getDate(request.getParameter("dateOfBirth")));
            System.out.println(m.getDateOfBirth());
        } catch (ParseException ex) {
            Logger.getLogger(RegisterStudentAction.class.getName()).log(Level.SEVERE, null, ex);
        }                
        try {
            addStudent(m);
            sendEmailStudent(m, request);
            request.setAttribute(WebConstants.REGISTRATION_RESULT, WebConstants.REGISTRATION_SUCCESSFUL_MESSAGE);
        } catch (IOException | ServletException ex) {            
            Logger.getLogger(RegisterStudentAction.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute(WebConstants.REGISTRATION_RESULT, WebConstants.REGISTRATION_UNSUCCESSFUL_MESSAGE);
        }
        
        return WebConstants.PAGE_MIGRANT_SUCCESSFULLY_REGISTERED;
    }

    private Migrant addMigrantKey(Migrant m) {
        SecureRandom random = new SecureRandom();
        m.setStudentCode(new BigInteger(90, random).toString(20));
        return m;
    }
    
    private Date getDate(String date) throws ParseException{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
        return sdf.parse(date);
    }
    
    private void addStudent(Migrant m){
        DBBroker.getInstance().addRecord(m);
    }
    
    private void sendEmailStudent(Migrant recipient, HttpServletRequest request) throws IOException, ServletException{
        EmailUtil.sendEmail(recipient.getEmail(), "Hi!\n\nWelcome to MyGrowth: A platform for keeping track"
                + " of your education!\n\nHere is your student code: "
                +recipient.getStudentCode()+"\n\nKeep it safe at ALL times. It serves"
                + " as your identity on our platform.\n\nNow go,"
                + " learn and make yourself proud!\n\nMyGrowth team.", "Welcome to MyGrowth!", "megroweducation@gmail.com");
            recipient.setProfileImageUrl(ImageUpload.uploadImage(request, "studentPhoto", recipient.getStudentCode()));
    }

}

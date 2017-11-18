/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import constants.WebConstants;
import javax.servlet.http.HttpServletRequest;
import util.EmailUtil;

/**
 *
 * @author solstinger
 */
public class ContactAction extends AbstractAction {

    public ContactAction() {
    }

    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");

        EmailUtil.sendEmail("megroweducation@gmail.com", message, "Subject: "+subject + ";Sender name: " + name, email);
        
        return WebConstants.PAGE_CONTACT_SUCCESS;
    }

}

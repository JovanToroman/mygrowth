/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resolver;

import constants.WebConstants;

/**
 *
 * @author student
 */
public class PageResolver {
    public static String getPage(String view){
        String page = "login-landing.jsp";
        switch(view){
            case WebConstants.PAGE_TEACHER_LOGIN_BAD_LOGIN: page = "/login-teacher-bad.jsp"; break;
            case WebConstants.PAGE_MIGRANT_LOGIN_BAD_LOGIN: page = "/login-migrant-bad.jsp"; break;
            case WebConstants.PAGE_TEACHER_VIEW: page = "/WEB-INF/jsp/teacher-view.jsp"; break;
            case WebConstants.PAGE_MIGRANT_VIEW: page = "/WEB-INF/jsp/migrant-view.jsp"; break;
            case WebConstants.PAGE_TEACHER_SELECT_ACTION: page = "/WEB-INF/jsp/teacher-select-action.jsp"; break;
            case WebConstants.PAGE_TEACHER_EDIT_STUDENT_VIEW: page = "/WEB-INF/jsp/teacher-edit-student-view.jsp"; break;
            case WebConstants.PAGE_TEACHER_EDIT_TEACHER_VIEW: page = "/WEB-INF/jsp/teacher-edit-teacher-view.jsp"; break;
            case WebConstants.PAGE_CONTACT_SUCCESS: page = "/contact-success.jsp"; break;
        }
        return page;
    }
}

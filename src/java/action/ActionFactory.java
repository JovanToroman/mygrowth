/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

/**
 *
 * @author student
 */
public class ActionFactory {

    public static AbstractAction createAction(String inputAction) {
        AbstractAction action = null;
        if (inputAction.equalsIgnoreCase("prijaviSeUcitelj")) {
            action = new LoginTeacherAction();
        }
        if (inputAction.equalsIgnoreCase("prijaviSeMigrant")) {
            action = new LoginMigrantAction();
        }
        if (inputAction.equalsIgnoreCase("editStudentView")) {
            action = new EditStudentViewDeliverPageAction();
        }
        if (inputAction.equalsIgnoreCase("izmeniStudentovPogled")) {
            action = new UpdateStudentViewDataAction();
        }
        if (inputAction.equalsIgnoreCase("izmeniNastavnikovPogled")) {
            action = new UpdateTeacherViewDataAction();
        }
        if (inputAction.equalsIgnoreCase("teacherView")) {
            action = new GenerateTeacherViewDataAction();
        }
        if (inputAction.equalsIgnoreCase("editTeacherView")) {
            action = new EditTeacherViewDeliverPageAction();
        }
        if (inputAction.equalsIgnoreCase("registrujUcitelja")) {
            action = new RegisterTeacherAction();
        }
        if (inputAction.equalsIgnoreCase("registrujUcenika")) {
            action = new RegisterStudentAction();
        }
        if (inputAction.equalsIgnoreCase("kontakt")) {
            action = new ContactAction();
        }
        return action;
    }
}

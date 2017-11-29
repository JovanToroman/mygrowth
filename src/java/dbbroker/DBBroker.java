/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbbroker;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;
import model.Record;

/**
 *
 * @author Solstinger_
 */
public class DBBroker {

    private static DBBroker dbbroker;
    private EntityManager em;
    private UserTransaction userTxn;

    private DBBroker() {
        createEntityManager();
    }

    public static DBBroker getInstance() {
        if (dbbroker == null) {
            dbbroker = new DBBroker();
        }
        return dbbroker;
    }
    
    public Object getRecord(Record r) throws Exception{
        return r.getRecord(em, userTxn);
    }
    
    public List<? extends Record> getRecords(Record r){
        return r.getRecords(em, userTxn);
    }
    
    public void addRecord(Record r){
        r.addRecord(em, userTxn);
    }
    
    public void updateRecord(Record r){
        r.updateRecord(em, userTxn);
    }   
    
    public void deleteRecord(Record r) {
        r.deleteRecord(em, userTxn);
    }

    private void createEntityManager() {
        try {
            Context ctx = new InitialContext();
            em = (EntityManager) ctx.lookup("java:comp/env/persistence/LogicalName");
            userTxn = (UserTransaction) ctx.lookup("UserTransaction");
        } catch (NamingException ex) {
            Logger.getLogger(DBBroker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

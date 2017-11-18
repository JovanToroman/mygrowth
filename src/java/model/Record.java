/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

/**
 *
 * @author solstinger
 */
public interface Record {
    public Object getRecord(EntityManager em, UserTransaction userTxn) throws Exception;
    public List<?> getRecords(EntityManager em, UserTransaction userTxn);
    public void deleteRecord(EntityManager em, UserTransaction userTxn);
    public void addRecord(EntityManager em, UserTransaction userTxn);
    public void updateRecord(EntityManager em, UserTransaction userTxn);
}

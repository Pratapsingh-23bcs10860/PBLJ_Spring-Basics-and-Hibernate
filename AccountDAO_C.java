package com.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAO {
    public void updateAccount(Account account) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(account);
        tx.commit();
        session.close();
    }

    public Account getAccount(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Account account = session.get(Account.class, id);
        session.close();
        return account;
    }
}

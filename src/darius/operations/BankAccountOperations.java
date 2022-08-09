package darius.operations;

import darius.model.BankAccount;
import org.hibernate.*;

import java.util.List;

public class BankAccountOperations {
    private final SessionFactory sessionFactory;
    private Session session;

    public BankAccountOperations(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.session = sessionFactory.openSession();
    }

    public List<BankAccount> getAllBankAccounts() {
        openSessionIfClosed();
        session.beginTransaction();
        Query hibernateQuery = session.createQuery("from BankAccount");
        List<BankAccount> bankAccountList = hibernateQuery
                .setCacheMode(CacheMode.PUT)
                .setCacheable(true)
                .list();
        session.getTransaction().commit();
        return bankAccountList;
    }

    public BankAccount findBankAccountById(Long id) {
        openSessionIfClosed();
        System.out.println("Session " + session.isOpen());
        BankAccount bankAccount = (BankAccount) session.load(BankAccount.class, id);
        session.close();
        return bankAccount;
    }

    public void persistBankAccount(BankAccount bankAccount) {
        openSessionIfClosed();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(bankAccount);
            tx.commit();
        } catch (HibernateException exception) {
            if (tx != null) {
                tx.rollback();
            }
            throw exception;
        } finally {
            session.close();
        }
    }

    private void openSessionIfClosed() {
        if ( session == null || !session.isOpen()) {
            this.session = sessionFactory.openSession();
        }
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Session getSession() {
        return session;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}

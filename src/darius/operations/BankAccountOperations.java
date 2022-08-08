package darius.operations;

import darius.model.BankAccount;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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
        List<BankAccount> bankAccountList = session.createQuery("from BankAccount").list();
        return bankAccountList;
    }

    public BankAccount findBankAccountById(Long id) {
        openSessionIfClosed();
        BankAccount bankAccount = (BankAccount) session.get(BankAccount.class, id);
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
        if (!session.isConnected() || session == null) {
            this.session = sessionFactory.openSession();
        }
    }
}

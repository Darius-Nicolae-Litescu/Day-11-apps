package darius.main;

import darius.model.BankAccount;
import darius.operations.BankAccountOperations;
import darius.util.SessionFactoryUtil;
import org.hibernate.SessionFactory;

import java.util.List;

public class TestLevel2Cache {
    public static void main(String[] args) {
        SessionFactory sessionFactory = SessionFactoryUtil.getFactory();
        BankAccountOperations bankAccountOperations = new BankAccountOperations(sessionFactory);

        System.out.println("Get account from db");
        BankAccount bankAccount = bankAccountOperations.findBankAccountById(2L);
        System.out.println(bankAccount);

        //bankAccountOperations.setSession(null);

        System.out.println("Get account from cache");
        BankAccount bankAccountTwo = bankAccountOperations.findBankAccountById(2L);
        System.out.println(bankAccountTwo);

        System.out.println("Hibernate second level cache hit count\n" + sessionFactory.getStatistics().getSecondLevelCacheHitCount());

    }
}

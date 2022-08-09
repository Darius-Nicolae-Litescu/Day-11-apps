package darius.main;

import darius.model.BankAccount;
import darius.operations.BankAccountOperations;
import darius.util.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.stat.Statistics;

import java.util.List;

public class TestLevel2Cache {
    public static void main(String[] args) {
        SessionFactoryUtil sessionFactoryUtil = new SessionFactoryUtil();
        sessionFactoryUtil.initializeFactory();
        SessionFactory sessionFactory = sessionFactoryUtil.getFactory();
        Statistics statistics = sessionFactory.getStatistics();
        statistics.setStatisticsEnabled(true);

        BankAccountOperations bankAccountOperations = new BankAccountOperations(sessionFactory);

        System.out.println("Get account from db");
        BankAccount bankAccount = bankAccountOperations.findBankAccountById(2L);
        System.out.println(bankAccount);

        bankAccountOperations.setSession(null);
        System.out.println("Get account from cache");
        BankAccount bankAccountTwo = bankAccountOperations.findBankAccountById(2L);
        System.out.println(bankAccountTwo);

        bankAccountOperations.setSession(null);

        System.out.println("Get account from cache");
        BankAccount bankAccountThree = bankAccountOperations.findBankAccountById(2L);
        System.out.println(bankAccountThree);

        System.out.println("Hibernate second level cache put count\n" + statistics.getSecondLevelCachePutCount());
        System.out.println("Hibernate second level cache hit count\n" + statistics.getSecondLevelCacheHitCount());
        for (String s:statistics.getSecondLevelCacheRegionNames()) {
            System.out.println("Hibernate second level cache region name\n" + s);
        }
    }
}

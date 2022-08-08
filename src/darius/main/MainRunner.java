package darius.main;

import darius.model.Address;
import darius.model.BankAccount;
import darius.model.Document;
import darius.model.Savings;
import darius.operations.BankAccountOperations;
import darius.util.SessionFactoryUtil;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.Date;

public class MainRunner {

    public static void main(String[] args) {
        BankAccountOperations bankAccountOperations = new BankAccountOperations(SessionFactoryUtil.getFactory());

        Address houseAddress = new Address("Nr.50", "Dambovita", "Romania");
        Address branchAddress = new Address("Nr.55", "Delhi", "India");
        Document document = new Document("ID card", "10000000000003");
        Document document2 = new Document("Driving license", "10000000000001");
        Document document3 = new Document("Passport", "10000000000002");
        Instant currentDateInstant = LocalDateTime.now().toInstant(ZoneOffset.UTC);
        Savings savings = new Savings("Check", Date.from(currentDateInstant), BigDecimal.valueOf(2999.98D), BigDecimal.valueOf(1D), Date.from(currentDateInstant));
        Savings savings2 = new Savings("Cash", Date.from(currentDateInstant), BigDecimal.valueOf(4245.245D), BigDecimal.valueOf(66.2D), Date.from(currentDateInstant));
        BankAccount bankAccount = new BankAccount(1L, "Darius", houseAddress, houseAddress, branchAddress);
        bankAccount.setFixedDeposits(Arrays.asList(savings, savings2));
        bankAccount.setVerificationDocuments(Arrays.asList(document, document2, document3));

        bankAccountOperations.persistBankAccount(bankAccount);

    }
}
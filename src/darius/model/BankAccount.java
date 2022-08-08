package darius.model;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Bank_Account")
@Cacheable

@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY, region="HibernateCache")
public class BankAccount implements Serializable {
    @Id
    @Column(name = "account_number")
    private Long accountNumber;
    @Column(name = "account_holder_name")
    private String accountHolderName;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "houseNumber", column = @Column(name = "client_house_number")),
            @AttributeOverride(name = "city", column = @Column(name = "client_city")),
            @AttributeOverride(name = "country", column = @Column(name = "client_country"))
    })
    private Address clientAddress;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "houseNumber", column = @Column(name = "communication_house_number")),
            @AttributeOverride(name = "city", column = @Column(name = "communication_city")),
            @AttributeOverride(name = "country", column = @Column(name = "communication_country"))
    })
    private Address communicationAddress;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "houseNumber", column = @Column(name = "branch_house_number")),
            @AttributeOverride(name = "city", column = @Column(name = "branch_city")),
            @AttributeOverride(name = "country", column = @Column(name = "branch_country"))
    })
    private Address branchAddress;

    @ElementCollection
    @CollectionTable(name = "Verification_Document", joinColumns = @JoinColumn(name = "bank_account_number"))
    private List<Document> verificationDocuments;

    @ElementCollection
    @CollectionTable(name = "Saving", joinColumns = @JoinColumn(name = "bank_account_number"))
    private List<Savings> fixedDeposits;

    public BankAccount() {
    }

    public BankAccount(Long accountNumber, String accountHolderName, Address clientAddress, Address communicationAddress, Address branchAddress) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.clientAddress = clientAddress;
        this.communicationAddress = communicationAddress;
        this.branchAddress = branchAddress;
    }

    public BankAccount(Long accountNumber, String accountHolderName, List<Document> verificationDocuments, List<Savings> fixedDeposits, Address clientAddress, Address communicationAddress, Address branchAddress) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.verificationDocuments = verificationDocuments;
        this.fixedDeposits = fixedDeposits;
        this.clientAddress = clientAddress;
        this.communicationAddress = communicationAddress;
        this.branchAddress = branchAddress;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public List<Document> getVerificationDocuments() {
        return verificationDocuments;
    }

    public void setVerificationDocuments(List<Document> verificationDocuments) {
        this.verificationDocuments = verificationDocuments;
    }

    public List<Savings> getFixedDeposits() {
        return fixedDeposits;
    }

    public void setFixedDeposits(List<Savings> fixedDeposits) {
        this.fixedDeposits = fixedDeposits;
    }

    public Address getClientAddress() {
        return clientAddress;
    }

    public void setClientAddress(Address clientAddress) {
        this.clientAddress = clientAddress;
    }

    public Address getCommunicationAddress() {
        return communicationAddress;
    }

    public void setCommunicationAddress(Address communicationAddress) {
        this.communicationAddress = communicationAddress;
    }

    public Address getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(Address branchAddress) {
        this.branchAddress = branchAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Objects.equals(accountNumber, that.accountNumber) && Objects.equals(accountHolderName, that.accountHolderName) && Objects.equals(verificationDocuments, that.verificationDocuments) && Objects.equals(fixedDeposits, that.fixedDeposits) && Objects.equals(clientAddress, that.clientAddress) && Objects.equals(communicationAddress, that.communicationAddress) && Objects.equals(branchAddress, that.branchAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, accountHolderName, verificationDocuments, fixedDeposits, clientAddress, communicationAddress, branchAddress);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber=" + accountNumber +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", verificationDocuments=" + verificationDocuments +
                ", fixedDeposits=" + fixedDeposits +
                ", clientAddress=" + clientAddress +
                ", communicationAddress=" + communicationAddress +
                ", branchAddress=" + branchAddress +
                '}';
    }
}

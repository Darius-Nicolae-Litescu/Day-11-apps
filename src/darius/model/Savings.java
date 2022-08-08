package darius.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class Savings implements Serializable {
    @Column(name = "saving_name")
    private String savingName;
    @Column(name = "saving_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date savingDate;
    @Column(name = "deposit_amount", nullable = false, precision = 14, scale = 2)
    private BigDecimal depositAmount;
    @Column(name = "annual_interest", nullable = false, precision = 8, scale = 5)
    private BigDecimal annualInterest;
    @Column(name = "maturity_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date maturityDate;

    public Savings() {
    }

    public Savings(String savingName, Date savingDate, BigDecimal depositAmount, BigDecimal annualInterest, Date maturityDate) {
        this.savingName = savingName;
        this.savingDate = savingDate;
        this.depositAmount = depositAmount;
        this.annualInterest = annualInterest;
        this.maturityDate = maturityDate;
    }

    public String getSavingName() {
        return savingName;
    }

    public void setSavingName(String savingName) {
        this.savingName = savingName;
    }

    public Date getSavingDate() {
        return savingDate;
    }

    public void setSavingDate(Date savingDate) {
        this.savingDate = savingDate;
    }

    public BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
    }

    public BigDecimal getAnnualInterest() {
        return annualInterest;
    }

    public void setAnnualInterest(BigDecimal annualInterest) {
        this.annualInterest = annualInterest;
    }

    public Date getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(Date maturityDate) {
        this.maturityDate = maturityDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Savings savings = (Savings) o;
        return Objects.equals(savingName, savings.savingName) && Objects.equals(savingDate, savings.savingDate) && Objects.equals(depositAmount, savings.depositAmount) && Objects.equals(annualInterest, savings.annualInterest) && Objects.equals(maturityDate, savings.maturityDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(savingName, savingDate, depositAmount, annualInterest, maturityDate);
    }

    @Override
    public String toString() {
        return "Savings{" +
                "savingName='" + savingName + '\'' +
                ", savingDate=" + savingDate +
                ", depositAmount=" + depositAmount +
                ", annualInterest=" + annualInterest +
                ", maturityDate=" + maturityDate +
                '}';
    }
}

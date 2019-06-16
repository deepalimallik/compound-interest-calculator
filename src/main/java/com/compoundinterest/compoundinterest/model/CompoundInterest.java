package com.compoundinterest.compoundinterest.model;


import javax.persistence.*;

@Entity
@Table(name = "interest")
public class CompoundInterest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "principle")
    private double principle;

    @Column(name = "compounding_period")
    private double number;

    @Column(name = "rate")
    private double rate;

    @Column(name = "year")
    private double year;

    @Column(name = "future_value")
    private double amount;

    @Column(name = "compound_interest")
    private double interest;

    @Column(name = "cname")
    private String cname;

    @Column(name = "increase_amount")
    private double increasingAmount;

    public CompoundInterest() {
    }

    public CompoundInterest(Long id, double principle, double number, double rate, double year, double amount, double interest, String cname, double increasingAmount) {
        this.id = id;
        this.principle = principle;
        this.number = number;
        this.rate = rate;
        this.year = year;
        this.amount = amount;
        this.interest = interest;
        this.cname = cname;
        this.increasingAmount = increasingAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrinciple() {
        return principle;
    }

    public void setPrinciple(double principle) {
        this.principle = principle;
    }

    public double getNumber() {
        return number;
    }

    public void setNumber(double number) {
        this.number = number;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getYear() {
        return year;
    }

    public void setYear(double year) {
        this.year = year;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getInterest() {
        return interest;
    }

    public void setInterest(double interest) {
        this.interest = interest;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public double getIncreasingAmount() {
        return increasingAmount;
    }

    public void setIncreasingAmount(double increasingAmount) {
        this.increasingAmount = increasingAmount;
    }

    @Override
    public String toString() {
        return "CompoundInterest{" +
                "id=" + id +
                ", principle=" + principle +
                ", number=" + number +
                ", rate=" + rate +
                ", year=" + year +
                ", amount=" + amount +
                ", interest=" + interest +
                ", cname='" + cname + '\'' +
                '}';
    }
}

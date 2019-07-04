package com.compoundinterest.compoundinterest.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "interest")
public class CompoundInterest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "principle")
    private float principle;

    @Column(name = "compounding_period")
    private float number;

    @Column(name = "rate")
    private float rate;

    @Column(name = "time")
    private float time;

    @Column(name = "future_value_of_series")
    private double amount;

    @Column(name = "compound_interest_for_principle")
    private double interest;

    @Column(name = "cname")
    private String cname;

    @Column(name = "periodic_deposit")
    private float monthlyPayment;

    @Column(name = "total")
    private double total;

    @Column(name = "start_date")
    private LocalDateTime localDateTime  = LocalDateTime.now();

    public CompoundInterest() {
    }

    public CompoundInterest(Long id, float principle, float number, float rate, float time, double amount, double interest, String cname, float monthlyPayment, double total, LocalDateTime localDateTime) {
        this.id = id;
        this.principle = principle;
        this.number = number;
        this.rate = rate;
        this.time = time;
        this.amount = amount;
        this.interest = interest;
        this.cname = cname;
        this.monthlyPayment = monthlyPayment;
        this.total = total;
        this.localDateTime = localDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getPrinciple() {
        return principle;
    }

    public void setPrinciple(float principle) {
        this.principle = principle;
    }

    public float getNumber() {
        return number;
    }

    public void setNumber(float number) {
        this.number = number;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
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

    public float getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(float monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "CompoundInterest{" +
                "id=" + id +
                ", principle=" + principle +
                ", number=" + number +
                ", rate=" + rate +
                ", time=" + time +
                ", amount=" + amount +
                ", interest=" + interest +
                ", cname='" + cname + '\'' +
                ", monthlyPayment=" + monthlyPayment +
                ", total=" + total +
                ", localDateTime=" + localDateTime +
                '}';
    }
}

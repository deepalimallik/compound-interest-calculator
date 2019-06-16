package com.compoundinterest.compoundinterest.dto;

public class CompoundInterestDTO {

    private double principle;
    private double year;
    private double rate;
    private double number;

    public CompoundInterestDTO() {
    }

    public double getPrinciple() {
        return principle;
    }

    public void setPrinciple(double principle) {
        this.principle = principle;
    }

    public double getYear() {
        return year;
    }

    public void setYear(double year) {
        this.year = year;
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


    public CompoundInterestDTO(double principle, double year, double rate, double number) {
        this.principle = principle;
        this.year = year;
        this.rate = rate;
        this.number = number;
    }
}

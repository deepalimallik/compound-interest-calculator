/*package com.compoundinterest.compoundinterest.model;

import javafx.util.Pair;

import java.util.Calendar;
import java.util.Map;

import static java.util.Calendar.DAY_OF_YEAR;

public class Class {

    private void calculateProjectedAmount(float interestRate, float selectedRuleAmount, int tenure, Map<Integer, Integer> settlementDates) {
        if (interestRate <= 0 || selectedRuleAmount <= 0 || tenure < 1 *//* one month *//*) {
            return;
        }

        Calendar calculationCalendar = Calendar.getInstance();
        Calendar completionCalendar = Calendar.getInstance();
        completionCalendar.add(Calendar.MONTH, tenure);

        // Interest should be calculated from the next day
        calculationCalendar.add(Calendar.DAY_OF_MONTH, 1);

        double totalBalance = 0;
        double totalAccruedInterest = 0;
        double accruedAmount = 0;

        while (!isGoalExpiryDate(calculationCalendar, completionCalendar)){

            // Add saving amount daily
            totalBalance += selectedRuleAmount;

            // Calculate Interest Amount Every Day and Append
            accruedAmount += calculateAccruedInterest(totalBalance, interestRate, DAY_OF_YEAR);

            boolean isGoalCompleted = isGoalExpiryDate(calculationCalendar, tenure);
            if (isSettlementDate(calculationCalendar, settlementDates) || isGoalCompleted){
                // Reduce the tax of Interest earned every month
                // Move Interest Amount to the totalBalance amount every month
                totalAccruedInterest += accruedAmount;
                totalBalance = calculateBalanceWithAccruedInterest(totalBalance, accruedAmount);
                accruedAmount = ZERO_INTEREST_CONSTANT;
            }

            calculationCalendar.add(Calendar.DAY_OF_MONTH, ONE_DAY_CONSTANT);
        }
        calculationProvider.onNext(new Pair<>(totalBalance, totalAccruedInterest));
    }

    *//**
     * This method calculate accrued interest.
     *
     * @param balance      This is the balance which will be used to calculated accrued interest.
     * @param interestRate This is the rate by which accrued interest amount will be calculated.
     * @return the accrued interest amount.
     *//*
    private double calculateAccruedInterest(double balance, double interestRate, int totalDaysInYear) {
        return (((interestRate * balance) / PERCENT_CONSTANT) / totalDaysInYear);
    }

    *//**
     * This method calculate tax on accrued interest.
     *
     * @param accruedInterest This is the accrued interest whose interest will be calculated.
     * @param interestRate    This is the rate by which interest amount will be calculated.
     * @return the amount of interest of provided accruedInterest
     *//*
    private double calculateTaxOnAccruedInterest(double accruedInterest, double interestRate) {
        return ((interestRate * accruedInterest) / PERCENT_CONSTANT);
    }

    *//**
     * This method calculate balance with accrued interest after tax deduction.
     *
     * @param balance         This is the balance on which accrued interest will be added after tax deduction.
     * @param accruedInterest This is the accrued interest amount on which tax will be deducted and merged with balance
     * @return the current balance amount
     *//*
    private double calculateBalanceWithAccruedInterest(double balance, double accruedInterest) {
        double tax = this.calculateTaxOnAccruedInterest(accruedInterest, TAX_RATE);
        Logger.d("TAX:  "+ tax);
        double accruedInterestAfterTaxDeduction = accruedInterest - tax;
        return (balance + accruedInterestAfterTaxDeduction);
    }

    *//**
     * This method is used to check for the settlement date
     *
     * @param calculationDate This is the date on which daily saving is done
     * @param settlementDates The is the list of settlement dates
     * @return true if provided calculation date is settlement date otherwise returns false
     *//*
    private boolean isSettlementDate(Calendar calculationDate, Map<Integer, Integer> settlementDates) {
        int month = calculationDate.get(Calendar.MONTH) + 1;
        int day = calculationDate.get(Calendar.DAY_OF_MONTH);
        int daysInMonth = calculationDate.getActualMaximum(Calendar.DAY_OF_MONTH);

        if (settlementDates.containsKey(month)) {
            Integer settlementDay = settlementDates.get(month);

            // Check if provided settlementDay is not available for current calendar.
            if (settlementDay == null || settlementDay > daysInMonth || settlementDay < 1) {
                return day == daysInMonth; // Then settlement day will be changed to EndOfTheMonth
            } else {
                return day == settlementDay;
            }
        }
        return false;
    }

    *//**
     * This method is used to check is the goals has reached to its expiration
     *
     * @param calculationDate This is the date on which daily saving is done
     * @param durationInMonth Total month for saving goal
     * @return true if goal reached to its expiration otherwise returns false
     *//*
    private boolean isGoalExpiryDate(Calendar calculationDate, int durationInMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, durationInMonth);

        return calculationDate.get(Calendar.YEAR) == calendar.get(Calendar.YEAR) &&
                calculationDate.get(Calendar.MONTH) == calendar.get(Calendar.MONTH) &&
                calculationDate.get(Calendar.DAY_OF_MONTH) == calendar.get(Calendar.DAY_OF_MONTH);
    }

    *//**
     * This method is used to check is the goals has reached to its expiration
     *
     * @param calculationDate This is the date on which daily saving is done
     * @param goalExpirationDate Saving goal expiration date
     * @return true if goal reached to its expiration otherwise returns false
     *//*
    private boolean isGoalExpiryDate(Calendar calculationDate, Calendar goalExpirationDate) {
        return calculationDate.get(Calendar.YEAR) == goalExpirationDate.get(Calendar.YEAR) &&
                calculationDate.get(Calendar.MONTH) == goalExpirationDate.get(Calendar.MONTH) &&
                calculationDate.get(Calendar.DAY_OF_MONTH) == goalExpirationDate.get(Calendar.DAY_OF_MONTH)+1;
    }
}*/

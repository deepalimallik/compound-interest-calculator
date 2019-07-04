package com.compoundinterest.compoundinterest.service.serviceImpl;

import com.compoundinterest.compoundinterest.model.CompoundInterest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class CompoundInterestCalculator {

     private Date settlementDate;

     final List<Integer> settlementMonths = Arrays.asList(3,6,9,12);

     private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

   public CompoundInterest interestCalculator(CompoundInterest compoundInterest1){

        CompoundInterest compoundInterest = new CompoundInterest();
        compoundInterest.setCname(compoundInterest1.getCname());
        float newPrinciple = compoundInterest1.getPrinciple() + compoundInterest1.getMonthlyPayment();
        compoundInterest.setPrinciple(newPrinciple);
        compoundInterest.setRate(compoundInterest1.getRate());
        compoundInterest.setTime(compoundInterest1.getTime());
        compoundInterest.setNumber(compoundInterest1.getNumber());
        compoundInterest.setMonthlyPayment(compoundInterest1.getMonthlyPayment());

        double compoundInterestForPrinciple = compoundInterest.getPrinciple()*Math.pow((1+(compoundInterest1.getRate()/compoundInterest1.getNumber())),compoundInterest1.getTime()*compoundInterest1.getNumber());

        compoundInterest.setInterest(compoundInterestForPrinciple);

        double futureValue = compoundInterest.getMonthlyPayment()*(((Math.pow((1+(compoundInterest.getRate()/compoundInterest.getNumber())),compoundInterest.getTime()*compoundInterest.getNumber()))-1)/(compoundInterest.getRate()/compoundInterest.getNumber()))*(1+(compoundInterest.getRate()/compoundInterest.getNumber()));

        compoundInterest.setAmount(futureValue);

        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        now.getMonth();

        for (int settlementMonth:settlementMonths
             ) {
             if(settlementMonth==now.getMonth().getValue()&& now.getDayOfMonth()==1)
                  compoundInterest.setTotal(compoundInterest.getInterest() + compoundInterest.getAmount());

        }
        return compoundInterest;
    }
}

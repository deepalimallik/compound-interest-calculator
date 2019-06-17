package com.compoundinterest.compoundinterest.service.serviceImpl;

import com.compoundinterest.compoundinterest.model.CompoundInterest;
import org.springframework.stereotype.Component;

@Component
public class CompoundInterestCalculator {


    public CompoundInterest interestCalculator(CompoundInterest compoundInterest1){
        CompoundInterest compoundInterest = new CompoundInterest();
        compoundInterest.setCname(compoundInterest1.getCname());
        double newPrinciple = compoundInterest1.getPrinciple() + compoundInterest1.getIncreasingAmount();
        compoundInterest.setPrinciple(newPrinciple);
        compoundInterest.setRate(compoundInterest1.getRate());
        compoundInterest.setYear(compoundInterest1.getYear());
        compoundInterest.setNumber(compoundInterest1.getNumber());
        compoundInterest.setIncreasingAmount(compoundInterest1.getIncreasingAmount());

        double futureValue = compoundInterest.getPrinciple()*Math.pow((1+(compoundInterest1.getRate()/compoundInterest1.getNumber())),compoundInterest1.getYear()*compoundInterest1.getNumber());

        compoundInterest.setAmount(futureValue);
        compoundInterest.setInterest(compoundInterest.getAmount()-compoundInterest.getPrinciple());

        return compoundInterest;
    }
}

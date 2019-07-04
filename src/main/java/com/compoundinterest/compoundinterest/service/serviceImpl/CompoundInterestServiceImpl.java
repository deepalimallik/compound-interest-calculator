package com.compoundinterest.compoundinterest.service.serviceImpl;

import com.compoundinterest.compoundinterest.exception.DataNotFoundException;
import com.compoundinterest.compoundinterest.model.CompoundInterest;
import com.compoundinterest.compoundinterest.repository.CompoundInterestRepository;
import com.compoundinterest.compoundinterest.service.CompoundInterestService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompoundInterestServiceImpl implements CompoundInterestService {

    private final CompoundInterestRepository compoundInterestRepository;

    private final CompoundInterestCalculator compoundInterestCalculator;

    public CompoundInterestServiceImpl(final CompoundInterestRepository compoundInterestRepository, CompoundInterestCalculator compoundInterestCalculator) {
        this.compoundInterestRepository = compoundInterestRepository;
        this.compoundInterestCalculator = compoundInterestCalculator;
    }


    @Override
    public List<CompoundInterest> findAll() {
       return compoundInterestRepository.findAll();

    }

    @Override
    public CompoundInterest findById(Long id) {

        CompoundInterest compoundInterest = compoundInterestRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Compound Interest Not Found"));
        return compoundInterest;
    }

    @Override
    public void save(CompoundInterest compoundInterest) {
        CompoundInterest compoundInterest1 = compoundInterestCalculator.interestCalculator(compoundInterest);
        compoundInterestRepository.save(compoundInterest1);
    }

    @Override
    public void update(CompoundInterest compoundInterest) {
        CompoundInterest compoundInterest1 = compoundInterestRepository.findByCname(compoundInterest.getCname()).orElseThrow(() -> new DataNotFoundException("Compound Interest Not Found"));

        compoundInterest1.setPrinciple(compoundInterest.getPrinciple());
        compoundInterest1.setNumber(compoundInterest.getNumber());
        compoundInterest1.setTime(compoundInterest.getTime());
        compoundInterest1.setRate(compoundInterest.getRate());
        compoundInterest1.setMonthlyPayment(compoundInterest.getMonthlyPayment());
        compoundInterest1.setInterest(compoundInterest.getInterest());

    compoundInterestRepository.save(compoundInterest1);
    }

    @Override
    public CompoundInterest getByCname(String cname) {
        CompoundInterest compoundInterest = compoundInterestRepository.findByCname(cname).orElseThrow(() -> new DataNotFoundException("Compound Interest Not Found"));

        return compoundInterest;

    }

    @Override
    public void deleteById(Long id) {
         compoundInterestRepository.deleteById(id);
    }
}

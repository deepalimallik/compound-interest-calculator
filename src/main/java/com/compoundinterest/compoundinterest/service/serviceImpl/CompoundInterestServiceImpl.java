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
       return   compoundInterestRepository.findAll();

    }

    @Override
    public CompoundInterest findById(Long id) {
        Optional<CompoundInterest> obj = compoundInterestRepository.findById(id);
        if (null == obj) {
            throw new DataNotFoundException("something");
        }
        return obj.get();
    }

    @Override
        public void save(CompoundInterest compoundInterest) {
            CompoundInterest compoundInterest1 = compoundInterestCalculator.interestCalculator(compoundInterest);
            compoundInterestRepository.save(compoundInterest1);
    }

    @Override
    public void update(CompoundInterest compoundInterest) {
        Optional<CompoundInterest> compint = compoundInterestRepository.findByCname(compoundInterest.getCname());
        if(!compint.isPresent()) {
            throw new DataNotFoundException("No Data Found");
        }

        CompoundInterest compoundInterest1 = compint.get();
        compoundInterest1.setPrinciple(compoundInterest.getPrinciple());
        compoundInterest1.setNumber(compoundInterest.getNumber());
        compoundInterest1.setYear(compoundInterest.getYear());
        compoundInterest1.setRate(compoundInterest.getRate());
        compoundInterest1.setAmount(compoundInterest.getAmount());
        compoundInterest1.setInterest(compoundInterest.getInterest());

    compoundInterestRepository.save(compoundInterest1);
    }

    @Override
    public CompoundInterest getByCname(String cname) {
        Optional<CompoundInterest> compint = compoundInterestRepository.findByCname(cname);
        if(!compint.isPresent()) {
            throw new DataNotFoundException("No Data Found");
        }

        return compint.get();

    }

    @Override
    public void deleteById(Long id) {
         compoundInterestRepository.deleteById(id);
    }
}

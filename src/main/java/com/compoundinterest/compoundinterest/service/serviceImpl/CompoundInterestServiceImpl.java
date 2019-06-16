package com.compoundinterest.compoundinterest.service.serviceImpl;

import com.compoundinterest.compoundinterest.dto.CompoundInterestDTO;
import com.compoundinterest.compoundinterest.exception.DataNotFoundException;
import com.compoundinterest.compoundinterest.model.CompoundInterest;
import com.compoundinterest.compoundinterest.repository.CompoundInterestRepository;
import com.compoundinterest.compoundinterest.service.CompoundInterestService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CompoundInterestServiceImpl implements CompoundInterestService {

    private final CompoundInterestRepository compoundInterestRepository;

    public CompoundInterestServiceImpl(CompoundInterestRepository compoundInterestRepository) {
        this.compoundInterestRepository = compoundInterestRepository;
    }

    @Override
    public List<CompoundInterest> findAll() {
        return compoundInterestRepository.findAll();
    }

    @Override
    public CompoundInterest findById(Long id) {
        Optional<CompoundInterest> obj = compoundInterestRepository.findById(id);
        return obj.get();
    }

    @Override
    public void save(CompoundInterest compoundInterest) {
        /*CompoundInterest compoundInterest1 = new CompoundInterest();
        compoundInterest1.setPrinciple(compoundInterestDTO.getPrinciple());
        compoundInterest1.setRate(compoundInterestDTO.getRate());
        compoundInterest1.setYear(compoundInterestDTO.getYear());
        compoundInterest1.setNumber(compoundInterestDTO.getNumber());

        double futureValue = compoundInterestDTO.getPrinciple()*Math.pow((1+(compoundInterestDTO.getRate()/compoundInterestDTO.getNumber())),compoundInterestDTO.getYear()*compoundInterestDTO.getNumber());

        compoundInterest1.setAmount(futureValue);
        compoundInterest1.setInterest(compoundInterest1.getAmount()-compoundInterest1.getPrinciple());

//        compoundInterestDTO.setAmount(compoundInterest1.getPrinciple()*Math.pow((1+(compoundInterest1.getRate()/100.0)),compoundInterest1.getTime()));
//        compoundInterest.setCI(compoundInterest1.getAmount()-compoundInterest1.getPrinciple());*/

        //compoundInterestRepository.save(compoundInterest1);
       // return compoundInterestScheduleServiceImpl.scheduleCompoundInterest();
        compoundInterestRepository.save(compoundInterest);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void update(CompoundInterest compoundInterest) {
        Optional<CompoundInterest> compint = compoundInterestRepository.findByCname(compoundInterest.getCname());
        if(!compint.isPresent()) {
            throw new DataNotFoundException("jbkj");
        }

        CompoundInterest compoundInterest1 = compint.get();
        compoundInterest1.setPrinciple(compoundInterest.getPrinciple());
        compoundInterest1.setNumber(compoundInterest.getNumber());
        compoundInterest1.setYear(compoundInterest.getYear());
        compoundInterest1.setRate(compoundInterest.getRate());
//        double futureValue = compoundInterest.getPrinciple()*Math.pow((1+(compoundInterest.getRate()/compoundInterest.getNumber())),compoundInterest.getYear()*compoundInterest.getNumber());
        compoundInterest1.setAmount(compoundInterest.getAmount());
        compoundInterest1.setInterest(compoundInterest.getInterest());

    compoundInterestRepository.save(compoundInterest1);
    }

    @Override
    public CompoundInterest getByCname(String cname) {
        Optional<CompoundInterest> compint = compoundInterestRepository.findByCname(cname);
        if(!compint.isPresent()) {
            throw new DataNotFoundException("aa");
        }

        return compint.get();

    }

    @Override
    public void deleteById(Long id) {
         compoundInterestRepository.deleteById(id);
    }
}

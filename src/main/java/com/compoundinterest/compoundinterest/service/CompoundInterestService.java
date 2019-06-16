package com.compoundinterest.compoundinterest.service;

import com.compoundinterest.compoundinterest.dto.CompoundInterestDTO;
import com.compoundinterest.compoundinterest.model.CompoundInterest;

import java.util.List;

public interface CompoundInterestService {

    List<CompoundInterest> findAll();
    CompoundInterest findById(Long id);
    void save(CompoundInterest compoundInterest);
    void update(CompoundInterest compoundInterest);
    CompoundInterest getByCname(String cname);
    void deleteById(Long id);
}

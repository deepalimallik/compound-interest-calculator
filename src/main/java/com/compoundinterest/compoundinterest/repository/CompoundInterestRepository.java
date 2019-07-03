package com.compoundinterest.compoundinterest.repository;

import com.compoundinterest.compoundinterest.model.CompoundInterest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompoundInterestRepository<findByCname> extends JpaRepository<CompoundInterest, Long> {


    Optional<CompoundInterest> findByCname(String cname);

}

package com.compoundinterest.compoundinterest.controller;

import com.compoundinterest.compoundinterest.dto.CompoundInterestDTO;
import com.compoundinterest.compoundinterest.model.CompoundInterest;
import com.compoundinterest.compoundinterest.service.CompoundInterestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/interest")
public class CompoundInterestController {

    private final CompoundInterestService compoundInterestService;

    public CompoundInterestController(CompoundInterestService compoundInterestService) {
        this.compoundInterestService = compoundInterestService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody CompoundInterest compoundInterest){
     compoundInterestService.save(compoundInterest);
    return new ResponseEntity<>(compoundInterest, HttpStatus.OK);

}

    @GetMapping
    public ResponseEntity<List<CompoundInterest>> findAll(){
        List<CompoundInterest> compoundInterestList = compoundInterestService.findAll();

        return new ResponseEntity<>(compoundInterestList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        CompoundInterest compoundInterest = compoundInterestService.findById(id);
        return ResponseEntity.ok(compoundInterest);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        compoundInterestService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

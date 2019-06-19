package com.compoundinterest.compoundinterest.service.serviceImpl;

import com.compoundinterest.compoundinterest.exception.DataNotFoundException;
import com.compoundinterest.compoundinterest.model.CompoundInterest;
import com.compoundinterest.compoundinterest.repository.CompoundInterestRepository;
import com.compoundinterest.compoundinterest.service.CompoundInterestService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CompoundInterestServiceImplTest {

    @Mock
    private CompoundInterestRepository compoundInterestRepository;

    @Mock
    private CompoundInterestCalculator compoundInterestCalculator;

    @InjectMocks
    private CompoundInterestServiceImpl compoundInterestServiceImpl;

    private CompoundInterestService compoundInterestService;

    CompoundInterest compoundInterest;

    @Before
    public void setUp(){

       compoundInterest = new CompoundInterest(1L, 2000.00, 12, 0.1, 5, 3000, 5, "default", 100);
    }

    @Test
    public void findAll_thenReturnCompoundInterestList(){
        List<CompoundInterest> compoundInterestList = new ArrayList<>();
        when(compoundInterestRepository.findAll()).thenReturn(compoundInterestList);
        assertEquals(compoundInterestServiceImpl.findAll(), compoundInterestList);
    }

    @Test
    public void findAll_whenCompoundInterestListIsNullOrSizeZero_thenReturnDataNotFoundException(){

        when(compoundInterestRepository.findAll()).thenReturn(null);
        compoundInterestServiceImpl.findAll();

    }

    @Test
    public void findById_thenResultCompoundInterestById(){


        when(compoundInterestRepository.findById(compoundInterest.getId())).thenReturn(Optional.of(compoundInterest));
       assertEquals(compoundInterest,compoundInterestServiceImpl.findById(1L));
    }

    @Test(expected = DataNotFoundException.class)
    public void findById_whenCompoundInterestIdIsNull_thenReturnDataNotFoundException(){

       when(compoundInterestRepository.findById(compoundInterest.getId())).thenReturn(null);
        compoundInterestServiceImpl.findById(compoundInterest.getId());
    }

    @Test
    public void save_thenResultCompoundInterest(){

//        doNothing().when(compoundInterestRepository).save(compoundInterest);
        when(compoundInterestRepository.save(compoundInterest)).thenReturn(compoundInterest);
        when(compoundInterestCalculator.interestCalculator(compoundInterest)).thenReturn(compoundInterest);
       compoundInterestServiceImpl.save(compoundInterest);
       verify(compoundInterestRepository).save(compoundInterest);

    }


    @Test
    public void delete_thenResultTrue(){

        doNothing().when(compoundInterestRepository).deleteById(compoundInterest.getId());
        compoundInterestServiceImpl.deleteById(compoundInterest.getId());
        verify(compoundInterestRepository).deleteById(compoundInterest.getId());

    }


    @Test
    public void update_thenResultTrue(){

        when(compoundInterestRepository.findByCname(compoundInterest.getCname())).thenReturn(Optional.of(compoundInterest));
        when(compoundInterestRepository.save(compoundInterest)).thenReturn(compoundInterest);
        compoundInterestServiceImpl.update(compoundInterest);
        verify(compoundInterestRepository).save(compoundInterest);

    }

    @Test
    public void getByCname_thenResultCname(){
        when(compoundInterestRepository.findByCname(compoundInterest.getCname())).thenReturn(Optional.of(compoundInterest));
        assertEquals(compoundInterest,compoundInterestServiceImpl.getByCname("default"));
    }

}
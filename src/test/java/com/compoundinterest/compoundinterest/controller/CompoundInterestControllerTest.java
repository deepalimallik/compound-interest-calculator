package com.compoundinterest.compoundinterest.controller;

import com.compoundinterest.compoundinterest.CompoundinterestApplication;
import com.compoundinterest.compoundinterest.model.CompoundInterest;
import com.compoundinterest.compoundinterest.repository.CompoundInterestRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CompoundinterestApplication.class)
@AutoConfigureMockMvc
public class CompoundInterestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CompoundInterestRepository compoundInterestRepository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findByIdTest() throws Exception{

       /// when(compoundInterestRepository.findById().thenReturn(new CompoundInterest);

        /*CompoundInterest compoundInterest= this.compoundInterestRepository.findById();
        assertThat(compoundInterest.getPrinciple()).isEqualTo("1000");
        assertThat(compoundInterest.getRate()).isEqualTo("0.05");
        assertThat(compoundInterest.getNumber()).isEqualTo("12");
        assertThat(compoundInterest.getYear()).isEqualTo("10");
*/


    }

}

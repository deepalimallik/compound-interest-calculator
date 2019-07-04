package com.compoundinterest.compoundinterest.controller;

import com.compoundinterest.compoundinterest.model.CompoundInterest;
import com.compoundinterest.compoundinterest.service.CompoundInterestService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CompoundInterestController.class)
public class CompoundInterestControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CompoundInterestService compoundInterestService;

    CompoundInterest compoundInterest;

    @Before
    public void setUp(){
        compoundInterest= new CompoundInterest();
    }

    @Test
    public void findAll_thenReturnCompoundInterestList() throws Exception {

        given(compoundInterestService.findAll()).willReturn(Arrays.asList(compoundInterest));
        mockMvc.perform(get("/interest").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());


    }

    @Test
    public void findById_thenReturnCompoundInterestListById() throws Exception{
        when(compoundInterestService.findById(compoundInterest.getId())).thenReturn(compoundInterest);
        mockMvc.perform(get("/interest/{id}" , compoundInterest.getId()).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void delete_thenReturnCompoundInterestStatusOK() throws Exception {
        doNothing().when(compoundInterestService).deleteById(1L);
        mockMvc.perform(delete("/interest/{id}", 1L)).andExpect(status().isOk());
        verify(compoundInterestService, times(1)).deleteById(1L);

    }

//    @Test
//    public void save_thenReturnCompoundInterest() throws Exception{
//        doNothing().when(compoundInterestService).save(compoundInterest);
//        mockMvc.perform(post("/interest").contentType(MediaType.APPLICATION_JSON).content(asJsonString(compoundInterest)))
//                .andExpect(status().isOk());
//    }

    public static  String asJsonString(final Object object){
        try{
                return new ObjectMapper().writeValueAsString(object);
            }catch (Exception e){
                throw new RuntimeException(e);
            }
    }

}

package com.example.garage_v2.integration;

import com.example.garage_v2.model.Car;
import com.example.garage_v2.repository.CarRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
public class CarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CarRepository carRepository;

    @Test
    public void addCarTest() throws Exception {

        Car bmw = carRepository.save(Car.builder()
                .brand("BMW")
                .colour("White")
                .build());

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .post("/cars")
                        .content(convert(bmw))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }
    public static String convert(final Object object) {

        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getCarTest() throws Exception {

        Car nissan = carRepository.save(Car.builder()
                .brand("Nissan")
                .colour("Steel")
                .build());

        MvcResult mvcResult = mockMvc.perform(get("/cars/" + nissan.getCar_id()))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    public void getCarsTest() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/cars"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

}

package com.example.garage_v2.integration;


import com.example.garage_v2.model.Car;
import com.example.garage_v2.model.Owner;
import com.example.garage_v2.repository.CarRepository;
import com.example.garage_v2.repository.OwnerRepository;
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
public class OwnerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private CarRepository carRepository;

    @Test
    public void addOwnerTest() throws Exception {

        Owner james = new Owner();
        james.setName("James");
        Owner owner = ownerRepository.save(james);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .post("/owners")
                        .content(convert(james))
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
    public void addCarsOwnerTest() throws Exception {

        Owner tom = new Owner();
        tom.setName("Tom");
        Owner owner = ownerRepository.save(tom);

        Car car = carRepository.save(Car.builder()
                .brand("Lamborghini")
                .colour("Grey")
                .build());

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                        .post("/owners/" + owner.getOwner_id() + "/" + car.getCar_id())
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }
    @Test
    public void getOwnersTest() throws Exception {

        MvcResult mvcResult = mockMvc.perform(get("/owners"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }

    @Test
    public void getOwnerTest() throws Exception {
        Owner leo = new Owner();
        leo.setName("Leo");
        Owner owner = ownerRepository.save(leo);

        MvcResult mvcResult = mockMvc.perform(get("/owners/" + owner.getOwner_id()))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();
    }
}

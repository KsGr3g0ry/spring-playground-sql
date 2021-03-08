package com.example.demo;
import static org.hamcrest.Matchers.is;

import com.example.demo.dao.LessonRepository;
import com.example.demo.model.Lesson;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import javax.print.attribute.standard.Media;
import javax.transaction.Transactional;
import java.beans.Transient;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TestLesson {

    @Autowired
    LessonRepository repository;

    @Autowired
    MockMvc mvc;


    @Transactional
    @Rollback
    @Test
    public void postLesson() throws Exception{ //returns all in DB
        MockHttpServletRequestBuilder request = post("/lessons")
            .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\": \"Trees\", \"deliveredOn\":\"2020-05-25\"}");

        this.mvc.perform(request) //very that post was sent correctly
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title", is("Trees")));  //use jsonpath to verify it posted
        //setup
        //add info to DB

        //use get to retrieve info

        //execution

        //assertion
        //response should be json data of tittle and deliveredOn
        }

    @Transactional
    @Rollback
    @Test
    public void getLesson() throws Exception{
        Lesson lessons = new Lesson();
        lessons.setTitle("Roses grow in concrete");
        //lessons.setDeliveredOn(20201215);
        repository.save(lessons);

        MockHttpServletRequestBuilder request = get("/lessons")
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title", is("Roses grow in concrete")));
    }

    }
//}
//Write a test for either the GET /lessons or GET /lessons/<id> endpoint.
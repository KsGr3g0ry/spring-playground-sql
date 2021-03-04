package com.example.demo.controller;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Lesson;
import com.example.demo.dao.LessonRepository;

@RestController
@RequestMapping("/lessons") //lesson endpoint
public class LessonsController {
        private final LessonRepository repository;

        public LessonsController(LessonRepository repository) { //constructor used by JPA
            this.repository = repository;
        }

        @GetMapping("")
        public Iterable<Lesson> all() { //Iterable is an interface that has specific methods
            return this.repository.findAll(); //return rows as json
        }

        @PostMapping("")
        public Lesson create(@RequestBody Lesson lesson) { //take lesson as json and save it to database; add row to DB
            return this.repository.save(lesson);
        }
}

package com.example.demo.controller;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Lesson;
import com.example.demo.dao.LessonRepository;

import javax.sound.midi.Patch;
import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.PATCH;

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

        @GetMapping("/{getId}") //use pathvariable since dealing with variables
        public Optional<Lesson> getId5(@PathVariable Long getId){
            return this.repository.findById(getId);

        }

       @DeleteMapping("/{deleteId}") //use pathvariable since dealing with variables
       public void deleteId5(@PathVariable Long deleteId){
            this.repository.deleteById(deleteId);

    }

        @PatchMapping("/{id}")
        //@PatchMapping(value = "/lessons", produces = "application/json") didnt work
        public Lesson updateLesson (@RequestBody Lesson lessons, @PathVariable Long id) {
        //check to see if entry exist
            if (this.repository.existsById(id)) {
            //find the record
            Lesson oldInfo = this.repository.findById(id).get();
            //update the title
            oldInfo.setTitle(lessons.getTitle());
            //update the date
            oldInfo.setDeliveredOn(lessons.getDeliveredOn());
            //save the record
            return this.repository.save(oldInfo);
        } else {
            return this.repository.save(lessons);
        }
    }





}
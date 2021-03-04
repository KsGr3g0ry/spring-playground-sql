package com.example.demo.dao;

import com.example.demo.model.Lesson;

import org.springframework.data.repository.CrudRepository;

public interface LessonRepository extends CrudRepository<Lesson,Long>{
}

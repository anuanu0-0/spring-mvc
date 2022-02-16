package com.example.springmvc.Crud.repository;


import com.example.springmvc.Crud.model.Course;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRespository<Course, Long> {

}

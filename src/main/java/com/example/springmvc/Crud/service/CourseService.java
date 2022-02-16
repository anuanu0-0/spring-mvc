package com.example.springmvc.Crud.service;

import com.example.springmvc.Crud.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    void saveCourse(Course course);
    Course getCourseById(long id);
    void deleteCourseById(long id);
    Page<Course> findPaginated(int pageNum, int pageSize, String sortField, String sortDirection);
}

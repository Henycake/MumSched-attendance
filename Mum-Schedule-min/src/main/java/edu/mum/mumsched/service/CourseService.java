package edu.mum.mumsched.service;

import edu.mum.mumsched.domain.Block;
import edu.mum.mumsched.domain.Course;

import java.time.LocalDate;
import java.util.List;

public interface CourseService {
    public Course save(Course course);
    public Course getCourseById( long id);
    public List<Course> getAllCourses();
    public Course getCourseByName(String courseName);
    public Course getCourseByTitle(String courseTitle);
    public void deleteCourseById(Long id);
    public void deleteCourseByName(String courseCode);
}

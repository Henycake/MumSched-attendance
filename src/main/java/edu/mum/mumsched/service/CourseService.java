package edu.mum.mumsched.service;

import edu.mum.mumsched.domain.Block;
import edu.mum.mumsched.domain.Course;

import java.time.LocalDate;
import java.util.List;

public interface CourseService {
    public Course save(Course Course);
    public Course getCourseById( long id);
    public List<Course> getAllCourses();
    public Course getCourseByCourseCode(String courseCode);
    public void deleteCourseById(Long id);
    public void deleteCourseByCourseCode(String courseCode);
}

package edu.mum.mumsched.service.impl;

import edu.mum.mumsched.dao.CourseDao;
import edu.mum.mumsched.domain.Course;
import edu.mum.mumsched.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImp implements CourseService {
    @Autowired
    CourseDao courseDao;

    @Override
    public Course save(Course course) {
        return courseDao.save(course);
    }

    @Override
    public Course getCourseById(long id) {
        return courseDao.findCourseById(id);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseDao.findAll();
    }

    @Override
    public Course getCourseByName(String courseName) {
        return null;
    }

    @Override
    public Course getCourseByTitle(String courseTitle) {
        return null;
    }

    @Override
    public void deleteCourseById(Long id) {
    courseDao.deleteById(id);
    }

    @Override
    public void deleteCourseByName(String courseCode) {

    }
}
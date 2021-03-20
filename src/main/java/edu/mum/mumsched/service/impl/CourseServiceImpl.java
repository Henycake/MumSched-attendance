package edu.mum.mumsched.service.impl;

import edu.mum.mumsched.dao.CourseDao;
import edu.mum.mumsched.domain.Course;
import edu.mum.mumsched.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

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
    public Course getCourseByCourseCode(String courseCode) {
        return  courseDao.findCourseByCourseCode(courseCode);
    }


    @Override
    public void deleteCourseById(Long id) {
        courseDao.deleteById(id);
    }

    @Override
    public void deleteCourseByCourseCode(String courseCode) {
             courseDao.deleteCourseByCourseCode(courseCode);
    }


}

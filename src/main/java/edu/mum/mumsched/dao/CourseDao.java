package edu.mum.mumsched.dao;

import edu.mum.mumsched.domain.Block;
import edu.mum.mumsched.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface CourseDao extends JpaRepository<Course,Long> {
    Course findCourseById(long id);

    Course findCourseByCourseCode(String courseCode);


    void deleteCourseByCourseCode(String courseCode);
}

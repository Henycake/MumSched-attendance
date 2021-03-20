package edu.mum.mumsched.dao;

import edu.mum.mumsched.domain.Block;
import edu.mum.mumsched.domain.Course;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface CourseDao extends JpaRepository<Course,Long> {

    Course findCourseById(long id);



    Course findByCourseTitle(String  CourseTitle);

    void deleteBlockByCourseCode(String CourseCode);

}

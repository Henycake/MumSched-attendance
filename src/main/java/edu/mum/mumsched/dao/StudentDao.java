package edu.mum.mumsched.dao;

import edu.mum.mumsched.domain.Entry;
import edu.mum.mumsched.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends JpaRepository<Student,Long> {
    Student findStudentById(long id);
    Student findStudentByEntry(Entry entry);
    Student findStudentByEmail(String email);
}

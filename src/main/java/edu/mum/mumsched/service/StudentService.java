package edu.mum.mumsched.service;

import edu.mum.mumsched.domain.Course;
import edu.mum.mumsched.domain.Entry;
import edu.mum.mumsched.domain.Student;

import java.util.List;

public interface StudentService {
    public Student save(Student student);
    public Student getStudentById( long id);
    public Student getStudentByEmail( String email);
    public List<Student> getAllStudent();
    public void deleteStudentById(long id);
    public Student getStudentByEntry(Entry entry);

}

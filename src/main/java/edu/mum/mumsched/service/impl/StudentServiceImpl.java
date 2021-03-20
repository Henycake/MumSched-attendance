package edu.mum.mumsched.service.impl;

import edu.mum.mumsched.dao.StudentDao;
import edu.mum.mumsched.domain.Entry;
import edu.mum.mumsched.domain.Student;
import edu.mum.mumsched.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentDao studentDao;

    @Override
    public Student save(Student student) {
        return studentDao.save(student);
    }

    @Override
    public Student getStudentById(long id) {
        return studentDao.findStudentById(id);
    }

    @Override
    public Student getStudentByEmail(String email) {
        return studentDao.findStudentByEmail(email);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentDao.findAll();
    }

    @Override
    public void deleteStudentById(long id) {
        studentDao.deleteById(id);
    }

    @Override
    public Student getStudentByEntry(Entry entry) {
        return studentDao.findStudentByEntry(entry);
    }


}

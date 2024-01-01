package com.Mrboo.student;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository("jpa")
public class StudentJPADataAccessService implements StudentDao {

    private StudentRepository studentRepository;

    public StudentJPADataAccessService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }
    @Override
    public List<Student> selectAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> selectStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public void insertStudent(Student student) {
            studentRepository.save(student);
    }

    @Override
    public boolean existsStudentWithMail(String email) {
        return studentRepository.existsStudentByEmail(email);
    }

    @Override
    public void deleteStudentById(Integer studentId) {
         studentRepository.deleteById(studentId);
    }

    @Override
    public boolean existsWithStudentId(Integer studentId){
        return studentRepository.existsStudentById(studentId);
    }

    @Override
    public void updateStudent(Student update) {
        studentRepository.save(update);
    }
}

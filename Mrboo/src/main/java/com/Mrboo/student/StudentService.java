package com.Mrboo.student;

import com.Mrboo.exception.DuplicateResourceException;
import com.Mrboo.exception.RequestValidationException;
import com.Mrboo.exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentService {

    private final StudentDao studentDao;

    public StudentService(@Qualifier("jpa") StudentDao studentDao) {
        this.studentDao = studentDao;
    }


    public List<Student> getAllStudents() {
        return studentDao.selectAllStudents();

    }

    public Student getStudent(Integer id) {
        return studentDao.selectStudentById(id).orElseThrow(
                () -> new IllegalArgumentException("Id not found")
        );
    }

    public void addStudent(StudentRegRequest studentRegRequest) {
        if (studentDao.existsStudentWithMail(studentRegRequest.email())) {
            throw new DuplicateResourceException("Email Already exists");
        }
        Student student = new Student(studentRegRequest.name(), studentRegRequest.email(), studentRegRequest.standard());
        studentDao.insertStudent(student);
    }

    public void deleteStudentById(Integer studentId) {
        if (!studentDao.existsWithStudentId(studentId)) {
            throw new ResourceNotFound("Id not found");
        }
        studentDao.deleteStudentById(studentId);
    }

    public void updateStudent(Integer studentId, StudentUpdateRequest updateRequest) {
        Student student = getStudent(studentId);
        boolean changes = false;

        if (updateRequest.name() != null && !updateRequest.name().equals(student.getName())) {
            student.setName(updateRequest.name());
            changes = true;

        }
        if(updateRequest.email() != null && !updateRequest.email().equals(student.getEmail())){
            if (studentDao.existsStudentWithMail(updateRequest.email())) {
                throw new DuplicateResourceException("Email Already exists");
            }
            student.setEmail(updateRequest.email());
            changes = true;

        }
        if(updateRequest.standard() != null && !updateRequest.standard().equals(student.getStandard())){
            student.setStandard(updateRequest.standard());
            changes = true;

        }
        if(!changes){
            throw new RequestValidationException("No changes to update");
        }
        studentDao.updateStudent(student);
    }
}

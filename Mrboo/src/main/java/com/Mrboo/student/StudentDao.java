package com.Mrboo.student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {
    List<Student> selectAllStudents();

    Optional<Student> selectStudentById(Integer id);

    void insertStudent(Student student);

    boolean existsStudentWithMail(String email);

    void deleteStudentById(Integer studentId);
    boolean existsWithStudentId(Integer studentId);

    void updateStudent(Student update);
}

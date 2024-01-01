package com.Mrboo.student;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    boolean existsStudentByEmail(String email);

    boolean existsStudentById(Integer studentId);
}

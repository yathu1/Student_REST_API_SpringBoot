package com.Mrboo.student;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository("list")
public class StudentListDataAccessService implements StudentDao{

    private static List<Student> students;

    static{
        students = new ArrayList<>();
        Student yathu = new Student("yathu",1,"yathu@gmail.com",12);
        Student kamal = new Student("kamal",2,"kamal@gmail.com",11);

        students.add(yathu);
        students.add(kamal);

    }
    @Override
    public List<Student> selectAllStudents() {
        return students;
    }

    @Override
    public Optional<Student> selectStudentById(Integer id) {
        return students.stream().filter(student -> student.getId().equals(id))
                .findFirst();
    }

    @Override
    public void insertStudent(Student student) {
        students.add(student);
    }

    @Override
    public boolean existsStudentWithMail(String email) {
        return students.stream().anyMatch(s->s.getEmail().equals(email));
    }

    @Override
    public void deleteStudentById(Integer studentId) {
        students.stream().filter(student -> student.getId().equals(studentId))
                .findFirst()
                .ifPresent(student -> students.remove(student));
    }

    @Override
    public boolean existsWithStudentId(Integer studentId) {
        return students.stream().anyMatch(s->s.getId().equals(studentId));
    }

    @Override
    public void updateStudent(Student update) {
        students.stream().filter(student -> student.getId().equals(update.getId()))
                .findFirst()
                .ifPresent(student -> {
                    students.remove(student);
                    students.add(update);
                });
        //students.add(update);
    }
}

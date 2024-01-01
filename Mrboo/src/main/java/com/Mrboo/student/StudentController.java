package com.Mrboo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer id){

        return studentService.getStudent(id);
    }
    @PostMapping
    public void registerStudent(@RequestBody StudentRegRequest studentRegRequest){
        studentService.addStudent(studentRegRequest);
    }

    @DeleteMapping("{studentId}")
    public void deleteStudent(@PathVariable("studentId") Integer studentId){
        studentService.deleteStudentById(studentId);
    }
    @PutMapping("{studentId}")
    public void putStudent(@PathVariable("studentId") Integer studentId,@RequestBody StudentUpdateRequest studentUpdateRequest){
        studentService.updateStudent(studentId,studentUpdateRequest);
    }
}

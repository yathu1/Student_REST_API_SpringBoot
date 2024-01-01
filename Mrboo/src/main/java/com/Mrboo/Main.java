package com.Mrboo;

import com.Mrboo.student.Student;
import com.Mrboo.student.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
public class Main {



    public static void main(String args[]){


        SpringApplication.run(Main.class,args);
    }
    @Bean
    CommandLineRunner cmdRunner(StudentRepository studentRepository){
        return args -> {
            Student yathu = new Student("yathu",1,"jaffna",12);
            Student kamal = new Student("kamal",2,"chennai",11);

            List<Student> students = List.of(yathu,kamal);
            studentRepository.saveAll(students);
        };
    }

}

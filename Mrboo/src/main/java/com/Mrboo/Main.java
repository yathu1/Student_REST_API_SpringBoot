package com.Mrboo;

import com.Mrboo.student.Student;
import com.Mrboo.student.StudentRepository;
import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.Random;

@SpringBootApplication
public class Main {



    public static void main(String args[]){


        SpringApplication.run(Main.class,args);
    }
    @Bean
    CommandLineRunner cmdRunner(StudentRepository studentRepository){
        return args -> {
            var faker =new Faker();
            Name name = faker.name();
            String firstName = name.firstName();
            String lastName = name.lastName();
            Random random=new Random();
            Student students = new Student(
                    firstName+" "+lastName,
                    firstName+"."+lastName+"@gmail.com", random.nextInt(1,12));
                    studentRepository.save(students);
         };
    }

}

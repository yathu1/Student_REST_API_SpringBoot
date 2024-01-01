package com.Mrboo.student;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
@Table(
        name = "student",
        uniqueConstraints = {
                @UniqueConstraint(name = "student_email_unique",columnNames = "email")
        }
)
public  class Student {
    @Id
    @SequenceGenerator(
            name = "student_id_seq",
            sequenceName = "student_id_seq",
            allocationSize = 1


    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_id_seq"
    )
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = true)
    private String email;
    @Column(nullable = false)
    private Integer standard;

    public Student() {
    }

    public Student(String name, Integer id, String email, Integer standard) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.standard = standard;
    }
    public Student(String name, String email, Integer standard) {
        this.name = name;
        this.email = email;
        this.standard = standard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStandard() {
        return standard;
    }

    public void setStandard(Integer standard) {
        this.standard = standard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(id, student.id) && Objects.equals(email, student.email) && Objects.equals(standard, student.standard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, email, standard);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + id +
                ", address='" + email + '\'' +
                ", standard=" + standard +
                '}';
    }
}

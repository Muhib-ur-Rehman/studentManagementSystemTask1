package com.example.StudentManagementSystemTask1;


import com.example.StudentManagementSystemTask1.Course;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int StudentId;
    private String Name;
    private   int RollNum;
    private int Age ;
    private String Sex;
    @ManyToMany
    private List<Course> courses;

    public Student2(int StudentId, String Name, int RollNum, int Age , String Sex, List<Course> courses) {
        this.StudentId = StudentId;
        this.Name = Name;
        this.RollNum = RollNum;
        this.Age  = Age ;
        this.Sex = Sex;
        this.courses = courses;
    }

    public Student2() {
    }

    public int getStudentId() {
        return StudentId;
    }

    public void setStudentId(int StudentId) {
        this.StudentId = StudentId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getRollNum() {
        return RollNum;
    }

    public void setRollNum(int RollNum) {
        this.RollNum = RollNum;
    }

    public int getAge () {
        return Age ;
    }

    public void setAge (int Age ) {
        this.Age  = Age ;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}

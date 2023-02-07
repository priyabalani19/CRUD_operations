package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    public Map<Integer, Student> s = new HashMap<>();
    public static int index = 8;

    Student s1 = new Student(1, "priya", "ML", "Pune");
    Student s2 = new Student(2, "anish", "BBA", "Nager");
    Student s3 = new Student(3, "jatin", "Developer", "Noida");
    Student s4 = new Student(4, "mohit", "Data Science", "Mumbai");
    Student s5 = new Student(5, "Riya", "PHD", "Nepal");
    Student s6 = new Student(6, "Rishi", "Hardware", "Bnagalore");
    Student s7 = new Student(7, "Yash", "BSC", "Kota");
    Student s8 = new Student(8, "Nauman", "CV", "Solapur");

    public StudentService() {
        s.put(1, s1);
        s.put(2, s2);
        s.put(3, s3);
        s.put(4, s4);
        s.put(5, s5);
        s.put(6, s6);
        s.put(7, s7);
        s.put(8, s8);
    }

        public List<Student> getAllstudent () {

            return new ArrayList<>(s.values());
        }
        public Student getStudentDetails ( int id){
            return s.get(id);
        }
        public  Student addStudent (Student stud){
            index += 1;
            stud.setId(index);
            s.put(index, stud);
            return stud;
        }
        public Student updateStudent ( int id, Student stud){
            stud.setId(id);
            s.put(id, stud);
            return stud;
        }
        public Student deleteStudent ( int id){
            return s.remove(id);
        }
}


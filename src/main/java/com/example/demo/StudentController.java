package com.example.demo;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/s")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @ApiResponses({@ApiResponse(code = 200, message = "student details retreived succesfully" ),
                  @ApiResponse(code = 400, message = "Bad Request" ),
                  @ApiResponse(code = 500, message = "Internal server error" )})
    @GetMapping("/students")
    public ResponseEntity<?> getAllstudent(){
        List<Student> ls = new ArrayList<>();
        if(CollectionUtils.isEmpty(studentService.getAllstudent())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No student found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllstudent());
    }

    @GetMapping("/stu/{id}")
    public ResponseEntity<Student> getStudentDetails(@RequestParam int id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentDetails(id));
    }

    @PostMapping("/addstudent")
    public ResponseEntity<Student> addStudent(@RequestBody Student stud){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.addStudent(stud));
    }

    @PutMapping("/updatestudent/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student stud){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.updateStudent(id,stud));
    }

    @DeleteMapping("/deletestudent/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable int id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.deleteStudent(id));
    }
}

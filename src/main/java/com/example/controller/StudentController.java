package com.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.validation.constraints.Min;



import com.example.exception.StudentNotFoundException;
import com.example.model.Student;
import com.example.service.StudentImpl;

public class StudentController {
	StudentImpl studentImpl;
    @Autowired
    public StudentController(StudentImpl studentImpl) {
        this.studentImpl = studentImpl;
    }
    @GetMapping(value="/students")
    public List<Student> getAllStudents(){
        return studentImpl.getAllStudent();
    }           
    @GetMapping(value="/students/{id}")
    public Student getStudentById(@PathVariable("id") @Min(1) int id) {
        Student std = studentImpl.findById(id)
                          .orElseThrow(()->new StudentNotFoundException("Student with "+id+" is Not Found!"));
        return std;
    }           
    @PostMapping(value="/students")
    public Student addStudent(@Validated @RequestBody Student std) {
        return studentImpl.save(std);
    }           
    @PutMapping(value="/students/{id}")
    public Student updateStudent(@PathVariable("id") @Min(1) int id, @Valid @RequestBody Student newstd) {
        Student stdu = studentImpl.findById(id)
                                     .orElseThrow(()->new StudentNotFoundException("Student with "+id+" is Not Found!"));
        stdu.setFirstname(newstd.getFirstname());
        stdu.setLastname(newstd.getLastname());
        stdu.setEmail(newstd.getEmail()); 
        return studentImpl.save(stdu);   
    }            
    @DeleteMapping(value="/students/{id}")
    public String deleteStudent(@PathVariable("id") @Min(1) int id) {
        Student std = studentImpl.findById(id)
                                     .orElseThrow(()->new StudentNotFoundException("Student with "+id+" is Not Found!"));
        studentImpl.deleteById(std.getId());  
        return "Student with ID :"+id+" is deleted";             
    }

}

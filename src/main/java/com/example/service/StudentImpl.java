package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.Student;
import com.example.repository.StudentRepository;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

public class StudentImpl implements IStudent {

	StudentRepository studentrepository;
    @Autowired
	public StudentImpl(StudentRepository studentrepository) {
	         this.studentrepository = studentrepository;
	}
	
	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentrepository.findAll();
	}

	@Override
	public Optional<Student> findById(int id) {
		// TODO Auto-generated method stub
		return studentrepository.findById(id);
	}

	@Override
	public Optional<Student> findByEmail(String email) {
		// TODO Auto-generated method stub
		return studentrepository.findByEmail(email);
	}

	@Override
	public Student save(Student std) {
		// TODO Auto-generated method stub
		return studentrepository.save(std);
	}
	 @Override
	public void deleteById(int id) {
        // TODO Auto-generated method stub
        studentrepository.deleteById(id);
    }

	



}

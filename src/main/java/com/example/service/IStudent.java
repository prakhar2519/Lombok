package com.example.service;

import java.util.List;
import java.util.Optional;

import com.example.model.Student;

public interface IStudent {
	List<Student> getAllStudent();
	Optional<Student> findById(int id);
	Optional<Student> findByEmail(String email);
	Student save(Student std);
	void deleteById(int id);

}

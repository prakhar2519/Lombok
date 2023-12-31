package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	Optional<Student> findByEmail(String Email);
	
	

}

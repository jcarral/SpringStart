package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	public List<Student> findByFirstName(String firstname);
	public List<Student> findByFirstNameAndLastNameOrderByFirstNameDesc(String firstName, String lastName);

}

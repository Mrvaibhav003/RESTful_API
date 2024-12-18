package com.demo.RestApi.resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.RestApi.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	

}

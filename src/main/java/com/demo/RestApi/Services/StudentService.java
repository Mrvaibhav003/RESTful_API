package com.demo.RestApi.Services;

import java.util.List;
import java.util.Optional;

import com.demo.RestApi.model.Student;

public interface StudentService {
	
	public Student addStudent(Student student);
	
	public List<Student> ShowStudent();
	
	public Optional<Student> searchBy(int id);
	
	public Student updateStudent(int id, Student st);
	
	public void Delete(int id);
	
	
	
	

}

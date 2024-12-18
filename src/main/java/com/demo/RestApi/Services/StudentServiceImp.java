package com.demo.RestApi.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.RestApi.model.Student;
import com.demo.RestApi.resource.StudentRepository;

@Service
public class StudentServiceImp implements StudentService {
	
	@Autowired
	private StudentRepository sr;

	@Override
	public Student addStudent(Student student) {
	
		return sr.save(student);
	}

	@Override
	public List<Student> ShowStudent() {
		
		return sr.findAll();
	}

	@Override
	public Optional<Student> searchBy(int id) {
		
		return sr.findById(id);
	}

	@Override
	public Student updateStudent(int id,Student st) {
		
		Student obj= sr.findById(id).orElse(null);
		if(obj!=null)
		{
			obj.setId(id);
			obj.setName(st.getName());
			obj.setRoll_no(st.getRoll_no());
			obj.setSub(st.getSub());
			
			return sr.save(obj);
		}
		else
		{
			return null;
		}
		
	}

	@Override
	public void Delete(int id) {
		
		 sr.deleteById(id);
	}
	
	
	

}

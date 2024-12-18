package com.demo.RestApi.Controller;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.RestApi.Services.StudentService;
import com.demo.RestApi.model.Student;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("user")
public class My_Controller {
	
			@Autowired
			StudentService studentsr;
	
			@PostMapping("add")
			public Student add(@RequestBody Student s)
			{
				
				return studentsr.addStudent(s);
			}
			
			@GetMapping("show")
			public List<Student> show()
			{
				return studentsr.ShowStudent();	
			}
			
			@GetMapping("search/{id}")
			public ResponseEntity<Student> search(@PathVariable int id)
			{
				Student st= studentsr.searchBy(id).orElse(null);
				if(st!=null)
				{
					return ResponseEntity.ok(st);
				}
				else
				{
					return ResponseEntity.notFound().build();
				}
			}
			
			@PutMapping("update/{id}")
			public String update(@PathVariable int id,@RequestBody Student s)
			{
				Student st=	studentsr.updateStudent(id, s);
				
				if(st!=null)
				{
					return "Data Updated Successfully";
				}
				else
				{
					return "Data Not Updated Successfully";
				}
			}
			
			@DeleteMapping("delete/{id}")
			public String Delete(@PathVariable int id)
			{
				studentsr.Delete(id);
				return "Data Deleted Successfully";
			}
			
			
			
			
			

}

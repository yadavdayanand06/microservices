package com.department.controller;

//import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.department.config.Configuration;
import com.department.entity.Department;
import com.department.service.DepartmentService;

//import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	Logger log  = (Logger) LoggerFactory.getLogger(DepartmentController.class);

	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	private Configuration configuration;
	
	@PostMapping("/")
	public Department saveDepartment(@RequestBody Department department) {
		log.info("Inside save department service");
		log.info("Input:"+department);
		Department savedDepartment = departmentService.saveDepartment(department);
		log.info("Created :"+savedDepartment);
		return savedDepartment;
	}
	
	@GetMapping("/{id}")	
	public ResponseEntity<Department> getDepartment(@PathVariable Long id) {
		 Department department = departmentService.getDepartmentById(id);
		 
		 return ResponseEntity.status(HttpStatus.OK).body(department);
	}
	
	@GetMapping("/limit")
	public ResponseEntity<String> getLimit(){
		String limits="";
		limits="min="+configuration.getMin()+" max="+configuration.getMax();
		return ResponseEntity.status(HttpStatus.OK).body(limits);
	}
}

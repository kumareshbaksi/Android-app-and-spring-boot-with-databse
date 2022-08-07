package com.kumaresh.DepartmentCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kumaresh.DepartmentCrud.model.Department;
import com.kumaresh.DepartmentCrud.service.DepartmentService;

@RestController
public class DepartmentController {
	
    @Autowired private DepartmentService departmentService;
    
    @PostMapping("/departments")
    public Department saveDepartment(
        @Validated @RequestBody Department department)
    {
    	System.out.print(department.getDepartmentName());
        return departmentService.saveDepartment(department);
    }
    
    // Read operation
    @GetMapping("/departments")
 
    public List<Department> fetchDepartmentList()
    {
        return departmentService.fetchDepartmentList();
    }
	

}

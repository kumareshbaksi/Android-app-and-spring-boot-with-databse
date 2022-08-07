package com.kumaresh.DepartmentCrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kumaresh.DepartmentCrud.Repository.DepartmentRepository;
import com.kumaresh.DepartmentCrud.model.Department;

@Service
public class DepartmentServiceImp implements DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> fetchDepartmentList() {
		return (List<Department>)
	            departmentRepository.findAll();
	}

	@Override
	public Department updateDepartment(Department department, Long departmentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteDepartmentById(Long departmentId) {
		departmentRepository.deleteById(departmentId);
		
	}

}

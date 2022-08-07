package com.kumaresh.DepartmentCrud.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.kumaresh.DepartmentCrud.model.Department;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Long> {

}

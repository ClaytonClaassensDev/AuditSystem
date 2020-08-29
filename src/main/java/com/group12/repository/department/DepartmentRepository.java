package com.group12.repository.department;

import com.group12.entity.Department;
import com.group12.repository.IRepository;

import java.util.Set;


public interface DepartmentRepository extends IRepository<Department, String> {

    Set<Department> getAll();
}

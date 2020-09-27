package com.group12.repository.department;

import com.group12.entity.Department;
import com.group12.repository.IRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author Enver Human - 216174929
 * Desc: Repository Interface for department
 * Date: 28 August 2020
 */

public interface DepartmentRepository extends IRepository<Department, String> {

    Set<Department> getAll();
}

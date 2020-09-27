package com.group12.service.department.impl;

import com.group12.entity.Department;
import com.group12.repository.department.DepartmentRepository;
import com.group12.repository.department.impl.DepartmentRepositoryImpl;
import com.group12.service.department.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.Set;
/**
 * @author Enver Human - 216174929
 * Desc: Service Implementation for Department
 * Date: 06 September 2020
 */

@Service
public class DepartmentServiceImpl implements DepartmentService
{

    private static DepartmentService service = null;
    private DepartmentRepository repository;

    private DepartmentServiceImpl()
    {
        this.repository = DepartmentRepositoryImpl.getRepository();
    }


    public static DepartmentService getService()
    {
        if (service == null) service = new DepartmentServiceImpl();
        return service;
    }



    // This method returns a department object using department repository
    @Override
    public Department create(Department department)
    {
        return this.repository.create(department);
    }

    // This method searches for the specified department object using id
    @Override
    public Department read(String id)
    {
        return this.repository.read(id);
    }

    // This method changes and updates specific department object
    @Override
    public Department update(Department department)
    {
        return this.repository.update(department);
    }

    // This method deletes a department object in repository using id
    @Override
    public boolean delete(String id)
    {
        return this.repository.delete(id);
    }

    // This method retrieves all the department objects in the repository
    @Override
    public Set<Department> getAll()
    {
        return this.repository.getAll();
    }
}
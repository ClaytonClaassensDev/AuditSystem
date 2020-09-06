package com.group12.service.department.impl;

import com.group12.entity.Department;
import com.group12.repository.department.DepartmentRepository;
import com.group12.repository.department.impl.DepartmentRepositoryImpl;
import com.group12.service.department.DepartmentService;

import java.util.Set;
/**
 * @author Enver Human - 216174929
 * Desc: Service Implementation for Department
 * Date: 28 August 2020
 */
public class DepartmentServiceImpl implements DepartmentService
{

    private static DepartmentService service = null;
    private DepartmentRepository repository;

    private DepartmentServiceImpl()
    {
        this.repository = DepartmentRepositoryImpl.getRepository();
    }

    // This method uses the Singleton pattern to instantiate only one object
    public static DepartmentService getService()
    {
        if (service == null) service = new DepartmentServiceImpl();
        return service;
    }

    // This method calls the create method in the DepartmentRepository class and adds a new department object
    @Override
    public Department create(Department department)
    {
        return this.repository.create(department);
    }

    // This method calls the read method in the DepartmentRepository class and searches for the specified department
    @Override
    public Department read(String id)
    {
        return this.repository.read(id);
    }

    // This method calls the update method in the DepartmentRepository class and changes the details of the specified department
    @Override
    public Department update(Department department)
    {
        return this.repository.update(department);
    }

    // This method calls the delete method in the DepartmentRepository class and deletes the specified department object
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
package com.group12.repository.department.impl;



import com.group12.entity.Department;
import com.group12.repository.department.DepartmentRepository;

import java.util.HashSet;
import java.util.Set;

public class DepartmentRepositoryImpl implements DepartmentRepository {

    public static DepartmentRepository repository = null;
    private Set<Department> departmentDB;

    private DepartmentRepositoryImpl()
    {
        this.departmentDB = new HashSet<>();
    }

    public static DepartmentRepository getRepository()
    {
        if (repository == null) repository = new com.group12.repository.department.impl.DepartmentRepositoryImpl();
        return repository;
    }


    @Override
    public Department create(Department department)
    {
        this.departmentDB.add(department);
        return department;
    }


    @Override
    public Department read(String id)
    {
        Department department = this.departmentDB.stream().filter(l -> l.getDepid().trim().equalsIgnoreCase(id))
                .findAny()
                .orElse(null);
        return department;
    }


    @Override
    public Department update(Department department)
    {
        boolean deleteDepartment = delete(department.getDepid());
        if (deleteDepartment)
        {
            this.departmentDB.add(department);
            return department;
        }
        return null;
    }


    @Override
    public boolean delete(String id)
    {
        Department department = read(id);
        if (department != null)
        {
            this.departmentDB.remove(department);
            return true;
        }
        return false;
    }


    @Override
    public Set<Department> getAll()
    {
        return this.departmentDB;
    }
}

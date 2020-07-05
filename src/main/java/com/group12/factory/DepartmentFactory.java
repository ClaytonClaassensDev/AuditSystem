package com.group12.factory;

import com.group12.entity.Department;
import com.group12.entity.Department.Builder;
import com.group12.util.GenerateID;

public class DepartmentFactory {


    public static Department createDepartment(String depName )
    {


        String depId = GenerateID.generateID();




        Department department = new Department.Builder()
                .setDepid(depId)
                .setDepName(depName)
                .build();

        return  department;




    }






    }




package com.group12.service.faculty.impl;

import com.group12.entity.Faculty;
import com.group12.repository.faculty.impl.FacultyRepositoryImpl;
import com.group12.service.faculty.FacultyService;

import java.util.HashSet;
import java.util.Set;

/**  Author: Ebenezer Mathebula
 *   Student no: 217301827
 *   Date: 05-09-2020
 *   Description: An Implementation of Faculty Service
 */


public class FacultyServiceImpl implements FacultyService {

    private static FacultyService service = null;

    private FacultyRepositoryImpl repository;


    // Faculty service constructor
    private FacultyServiceImpl(){
        // instantiate the repository instance
        this.repository = FacultyRepositoryImpl.getRepository();
    }

    // Returns the service singleton instance
    public static FacultyService getService(){
        if(service == null){
            service = new FacultyServiceImpl();
        }
        return service;
    }


    @Override
    public Set<Faculty> getAll() {
        return this.repository.getAllFaculties();
    }


    @Override
    public Set<Faculty> getAllFacultyStartingWith(String start) {
        Set<Faculty> faculties = new HashSet<>();

        for (Faculty fac : getAll()){
            if(fac.getFacultyName().startsWith(start)){
                faculties.add(fac);
            }
        }
        return faculties;
    }


    @Override
    public Faculty getFacultyByName(String name) {
        Faculty faculty = null;

        for (Faculty fac : this.repository.getAllFaculties()){
            if(fac.getFacultyName().equalsIgnoreCase(name)){
                faculty = fac;
            }
        }
        return faculty;
    }


    @Override
    public Faculty create(Faculty faculty) {
        return this.repository.create(faculty);
    }

    @Override
    public Faculty read(String id) {
        return this.repository.read(id);
    }

    @Override
    public Faculty update(Faculty faculty) {
        return this.repository.update(faculty);
    }

    @Override
    public boolean delete(String id) {
        return this.repository.delete(id);
    }

}

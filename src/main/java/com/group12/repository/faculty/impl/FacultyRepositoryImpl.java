package com.group12.repository.faculty.impl;

import com.group12.entity.Faculty;
import com.group12.repository.faculty.IFacultyRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Ebenezer Mathebula - 217301827
 * Desc: Repository Implementation for Faculty
 * Date: July 2020
 */

public class FacultyRepositoryImpl implements IFacultyRepository {

    private static FacultyRepositoryImpl instance = null;

    private Set<Faculty> facultyDB = null;

    public FacultyRepositoryImpl(){
        this.facultyDB = new HashSet<>();
    }

    public static FacultyRepositoryImpl getInstance(){
        if(instance == null){
            instance = new FacultyRepositoryImpl();
        }
        return instance;
    }


    @Override
    public Faculty create(Faculty faculty) {
        this.facultyDB.add(faculty);
        return faculty;
    }

    @Override
    public Faculty read(String id) {
        Faculty fac = null;
        for(Faculty item : this.facultyDB){
            if(item.getFacultyId().equals(id)){
                fac = item;
            }
        }
        return fac;
    }

    @Override
    public Faculty update(Faculty faculty) {
        boolean deleted = delete(faculty.getFacultyId());

        if(deleted){
            this.facultyDB.add(faculty);
            return faculty;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        Faculty delFac = read(id);
        if(delFac != null){
            this.facultyDB.remove(delFac);
            return true;
        }
        return false;
    }

    @Override
    public Set<Faculty> getAllFaculties() {
        return this.facultyDB;
    }

    @Override
    public int size() {
        return this.facultyDB.size();
    }

}

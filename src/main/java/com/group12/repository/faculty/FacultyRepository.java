package com.group12.repository.faculty;

import com.group12.entity.Faculty;
import com.group12.repository.IRepository;

import java.util.Set;

/**
 * @author Ebenezer Mathebula - 217301827
 * Desc: Repository Interface for Faculty Repository
 * Date: July 2020
 */

public interface FacultyRepository extends IRepository<Faculty, String> {

    public Set<Faculty> getAllFaculties();

    public int size();      // get the size of the database

}

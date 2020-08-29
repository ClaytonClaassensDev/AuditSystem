package com.group12.repository.faculty.impl;

import com.group12.entity.Faculty;
import com.group12.factory.FacultyFactory;
import com.group12.repository.faculty.IFacultyRepository;
import com.group12.repository.faculty.impl.FacultyRepositoryImpl;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

/**
 * @author Ebenezer Mathebula - 217301827
 * Desc: Repository Implementation Test for Faculty
 * Date: 28 August 2020
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FacultyRepositoryImplTest {

    private static IFacultyRepository repo = FacultyRepositoryImpl.getInstance();

    // Instances to test with
    private static Faculty engineering = null;
    private static Faculty accounting = null;
    private static Faculty arts = null;

    @Test
    public void a_create() {
        try {
            engineering = FacultyFactory.createFactory("Engineering");
            accounting = FacultyFactory.createFactory("Accounting");
            arts = FacultyFactory.createFactory("Arts and Culture");

            repo.create(engineering);
            repo.create(accounting);
            repo.create(arts);

            int expectedSizeOfDB = 3;
            int actualSizeOfDB = repo.size();
            Assert.assertEquals(expectedSizeOfDB, actualSizeOfDB);
        }
        catch (Exception e) {
            Assert.fail();
        }

    }


    @Test
    public void b_read() {
        try {
            Faculty read = repo.read(accounting.getFacultyId());
            System.out.println("READ: " + read.toString());
            System.out.println("");

            Assert.assertEquals(accounting, read);
        }
        catch (Exception ex){
            Assert.fail();
        }
    }


    @Test
    public void c_update() {
        try {
            // copy old instance and set a new name for it
            String newName = "Financial Accounting";
            Faculty newFac = new Faculty.Builder().copy(accounting).setFacultyName(newName).build();
            repo.update(newFac);

            System.out.println("UPDATE: " + repo.read(accounting.getFacultyId()).toString());
            System.out.println("");

            String actualNewName = repo.read(accounting.getFacultyId()).getFacultyName();
            Assert.assertEquals(newName, actualNewName);
        }
        catch (Exception ex){
            Assert.fail();
        }
    }


    @Test
    public void delete() {
        System.out.println("DELETE: Size before == " + repo.size());
        boolean isDeleted = repo.delete(arts.getFacultyId());
        System.out.println("DELETED: " + isDeleted);
        System.out.println("DELETE: Size after == " + repo.size());
        System.out.println("");

        Assert.assertTrue(isDeleted);
    }

    @Test
    public void e_getAllFaculties() {
        Assert.assertTrue(repo.getAllFaculties() instanceof Set);
    }


}
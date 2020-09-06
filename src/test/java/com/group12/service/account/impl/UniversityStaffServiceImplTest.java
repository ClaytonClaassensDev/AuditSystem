package com.group12.service.account.impl;

import com.group12.entity.UniversityStaff;
import com.group12.factory.UniversityStaffFactory;
import com.group12.service.account.UniversityStaffService;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Set;

import static org.junit.Assert.*;

/**  Author: Limpho Ranamane
 *   Date: 02-09-2020
 *   Description: Accessing UniversityStaff Repository using TDD for UniversityStaffService
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)//fixes methods to run in a sequence
public class UniversityStaffServiceImplTest {

    private static UniversityStaffService universityStaffService =  UniversityStaffServiceImpl.getUniversityStaffService();
    private static UniversityStaff universityStaff = UniversityStaffFactory.createUniversityStaff("Tools", "Umazelaphi", "0693852402"); // passes values as per sequence in the UniversityStaffFactory

//the following methods are CRUD methods which all communicate with the repository which in tern communicates with the DB

    @Test
    public void a_create() {
        UniversityStaff created = universityStaffService.create(universityStaff);
        assertEquals(universityStaff.getUniversityStaffID(), created.getUniversityStaffID());
        System.out.println("Expected: " + universityStaff.getUniversityStaffID()+ " Actual: " + created.getUniversityStaffID() + "Created Auditor: "+ created);
    }

    @Test
    public void b_read() {
        UniversityStaff reading = universityStaffService.read(universityStaff.getUniversityStaffID());
        assertEquals(reading, reading);
        System.out.println("Read " + reading);
    }

    @Test
    public void c_update() {
        UniversityStaff updated = new UniversityStaff.Builder().copy(universityStaff).setUniversityStaffFirstName("Bill").build();
        updated = universityStaffService.update(updated);
        assertEquals(universityStaff.getUniversityStaffID(), updated.getUniversityStaffID());
        assertNotEquals(universityStaff.getUniversityStaffFirstName(),updated.getUniversityStaffID());
        System.out.println("Updated to: " + updated);
    }

    @Test
    public void e_delete() {
        boolean removed =  universityStaffService.delete(universityStaff.getUniversityStaffID());
        assertTrue(removed);
    }

    @Test
    public void d_getAll() {
        Set<UniversityStaff> auditors = universityStaffService.getAll();
        assertEquals(1,auditors.size());
        System.out.println("Returned results " + universityStaffService.getAll());
    }
}
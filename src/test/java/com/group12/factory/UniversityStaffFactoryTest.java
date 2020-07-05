package com.group12.factory;

import com.group12.entity.UniversityStaff;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class UniversityStaffFactoryTest {
    // tests if ID is not null
    @Test
    public void createUniversityStaffID() {
        UniversityStaff universityStaff = UniversityStaffFactory.createUniversityStaff("Limpho", "Ranamane", "0824568970");
        Assert.assertNotNull(universityStaff.getUniversityStaffID());
    }

    // tests if the user did put in name correctly
    @Test
    public void createUniversityStaffName() {
        UniversityStaff universityStaff = UniversityStaffFactory.createUniversityStaff("Limpho", "Ranamane", "0824568970");
        Assert.assertEquals("Limpho", universityStaff.getUniversityStaffFirstName());
    }

    // tests if the user did put in surname
    @Test
    public void createUniversityStaffSurname() {
        UniversityStaff universityStaff = UniversityStaffFactory.createUniversityStaff("Limpho", "Ranamane", "0824568970");
        Assert.assertEquals("Ranamane", universityStaff.getUniversityStaffSurname());
    }

    // tests if the user did put in the phone number
    @Test
    public void createUniversityStaffCellphoneNumber() {
        UniversityStaff universityStaff = UniversityStaffFactory.createUniversityStaff("Limpho", "Ranamane", "0824568970");
        Assert.assertEquals("0824568970", universityStaff.getUniversityStaffCellPhone());
    }
}
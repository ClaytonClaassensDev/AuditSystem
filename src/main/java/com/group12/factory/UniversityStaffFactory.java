package com.group12.factory;
/**  Author: Limpho Ranamane
 *   Date: 02-07-2020
 *   Description: Auditor entity using Builder pattern
 */
import com.group12.entity.UniversityStaff;
import com.group12.util.GenerateID;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UniversityStaffFactory {

    public static UniversityStaff createUniversityStaff(String universityStaffFirstName, String universityStaffSurname, String universityStaffCellPhone)
    {
        String universityStaffID = GenerateID.generateID();
        // start of validation block of code

        // checks if all values are in
        if (universityStaffFirstName.isEmpty() || universityStaffSurname.isEmpty() || universityStaffCellPhone.isEmpty())
        {
            System.out.println("Please fill in all required information.");
        }


        // checks that name and surname does not contain numbers
        if (!universityStaffFirstName.matches("[a-zA-Z_]+"))
        {
            System.out.println("Invalid name");
        }

        if (!universityStaffSurname.matches("[a-zA-Z_]+"))
        {
            System.out.println("Invalid surname");
        }

        // checks if numbers are 10 in length and start with 0
        String numberOfDigits = "^[0-9]{10}$";
        Pattern pattern = Pattern.compile(numberOfDigits);
        Matcher matcher = pattern.matcher(universityStaffCellPhone);

        if (!matcher.matches())
        {
            System.out.println("Please check phone number and fill in again, correctly.");
        }
        // end of validation block of code

        UniversityStaff universityStaff = new UniversityStaff.Builder()
                .setUniversityStaffID(universityStaffID)
                .setUniversityStaffFirstName(universityStaffFirstName)
                .setUniversityStaffSurname(universityStaffSurname)
                .setUniversityStaffCellPhone(universityStaffCellPhone)
                .build();
        return universityStaff;
    }
}

package com.group12.factory;
/**  Author: Limpho Ranamane
 *   Date: 02-07-2020
 *   Description: Auditor entity using Builder pattern
 */
import com.group12.entity.Auditor;
import com.group12.util.GenerateID;

public class AuditorFactory {

    /** Testing if user can input name, surname, and cellphone number
     * constraints: 1. None of the values should be null (therefore) include validations
     *              2. Validate that String should not include int
     *              3. Phone number must contain 10 digits and must start with 0
     *              4. All values must be correctly entered.
     * */

    public static Auditor createAuditor(String auditorFirstName, String auditorSurname, String auditorCellPhone)
    {
        // start of validation block of code

        // checks if all values are in
        if (auditorFirstName.isEmpty() || auditorSurname.isEmpty() || auditorCellPhone.isEmpty())
        {
            System.out.println("Please fill in all required information.");
        }

        // checks if numbers are 10 in length and start with 0
        // end of validation block of code

        String auditorID = GenerateID.generateID();
        Auditor auditor = new Auditor.Builder()
                .setAuditorID(auditorID)
                .setAuditorFirstName(auditorFirstName)
                .setAuditorSurname(auditorSurname)
                .setAuditorCellPhone(auditorCellPhone)
                .build();
        return auditor;
    }
}

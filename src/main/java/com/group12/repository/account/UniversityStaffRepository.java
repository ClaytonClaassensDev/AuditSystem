package com.group12.repository.account;

import com.group12.entity.UniversityStaff;
import com.group12.repository.IRepository;

import java.util.Set;
/**  Author: Limpho Ranamane
 *   Date: 26-08-2020
 *   Description: Interface directly responsible for handling the call for all values in the Auditor DB
 */

public interface UniversityStaffRepository extends IRepository<UniversityStaff, String> {
    Set<UniversityStaff> getAll();
}

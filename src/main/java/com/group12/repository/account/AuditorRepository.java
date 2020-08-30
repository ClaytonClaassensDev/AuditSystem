package com.group12.repository.account;

import com.group12.entity.Auditor;
import com.group12.repository.IRepository;
import java.util.Set;

/**  Author: Limpho Ranamane
 *   Date: 24-08-2020
 *   Description: Interface directly responsible for handling the call for all values in the Auditor DB
 */

public interface AuditorRepository extends IRepository<Auditor, String> {
    Set<Auditor> getAll();


}

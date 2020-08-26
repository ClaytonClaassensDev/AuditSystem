package com.group12.repository.account;
/**  Author: Rachael Klein
 *   Student no: 218 057 377
 *   Date: 25-08-2020
 *   Description: Interface UserAccount Respository
 */

import com.group12.entity.UserAccount;
import com.group12.repository.IRepository;

import java.util.Set;

public interface UserAccountRepository extends IRepository <UserAccount,String> {
    Set<UserAccount> getAll();
}

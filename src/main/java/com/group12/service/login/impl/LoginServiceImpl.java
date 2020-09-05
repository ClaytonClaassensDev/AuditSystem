package com.group12.service.login.impl;

import com.group12.entity.Login;
import com.group12.entity.UserAccount;
import com.group12.repository.login.LoginRepository;
import com.group12.repository.login.impl.LoginRepositoryImpl;
import com.group12.service.login.LoginService;

import java.util.HashSet;
import java.util.Set;
/**
 * @author Bradley van der Westhuizen - 217218903
 * Desc: Service Implementation for login
 * Date: 28 August 2020
 */
public class LoginServiceImpl implements LoginService
{

    private static LoginService service = null;
    private LoginRepository repository;

    private LoginServiceImpl()
    {
        this.repository = LoginRepositoryImpl.getRepository();
    }

    // This method uses the Singleton pattern to instantiate only one object
    public static LoginService getService()
    {
        if (service == null) service = new LoginServiceImpl();
        return service;
    }

    // This method calls the create method in the LoginRepository class and adds a new login object
    @Override
    public Login create(Login login)
    {
        return this.repository.create(login);
    }

    // This method calls the read method in the LoginRepository class and searches for the specified login object
    @Override
    public Login read(String id)
    {
        return this.repository.read(id);
    }

    // This method calls the update method in the LoginRepository class and changes the details of a login object
    @Override
    public Login update(Login login)
    {
        return this.repository.update(login);
    }

    // This method calls the delete method in the LoginRepository class and deletes the specified login object
    @Override
    public boolean delete(String id)
    {
        return this.repository.delete(id);
    }

    // This method retrieves all login objects in the repository
    @Override
    public Set<Login> getAll()
    {
        return this.repository.getAll();
    }

    // This method checks the email and password used to login against the email and password of users
    // If the login email and password matches the email and password of a user, that user is authenticated
    @Override
    public boolean authenticate(String loginID, UserAccount userAccount)
    {
        String loginEmail = repository.read(loginID).getEmailAddress();
        String loginPassword = repository.read(loginID).getPassword();
        String userEmail = userAccount.getEmail();
        String userPassword = userAccount.getPassword();
        if (loginEmail.equals(userEmail) && loginPassword.equals(userPassword))
            return true;
        return false;
    }
}

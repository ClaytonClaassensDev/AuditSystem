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

    public static LoginService getService()
    {
        if (service == null) service = new LoginServiceImpl();
        return service;
    }

    @Override
    public Login create(Login login)
    {
        return this.repository.create(login);
    }

    @Override
    public Login read(String id)
    {
        return this.repository.read(id);
    }

    @Override
    public Login update(Login login)
    {
        return this.repository.update(login);
    }

    @Override
    public boolean delete(String id)
    {
        return this.repository.delete(id);
    }

    @Override
    public Set<Login> getAll()
    {
        return this.repository.getAll();
    }

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

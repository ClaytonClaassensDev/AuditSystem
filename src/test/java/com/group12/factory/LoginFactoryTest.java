package com.group12.factory;

import com.group12.entity.Login;
import org.junit.Test;

import org.junit.Assert;

import static org.junit.Assert.assertEquals;

/**
 * @author Bradley van der Westhuizen - 217218903
 * Desc: Factory test for Login
 * Date: 3 July 2020
 */

public class LoginFactoryTest {

    @Test
    public void createLogin() {
        Login login = LoginFactory.createLogin(java.time.LocalDate.now(),null, true);
        Assert.assertEquals(java.time.LocalDate.now(), login.getLoginDate());
    }

    @Test
    public void logoutDate() {
        Login login = LoginFactory.createLogin(java.time.LocalDate.now(),null, true);
        Assert.assertNull(login.getLogoutDate());
    }

    @Test
    public void loginStatus() {
        Login login = LoginFactory.createLogin(java.time.LocalDate.now(),null, true);
        Assert.assertTrue(login.isLoginStatus());
    }
}
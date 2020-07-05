package com.group12.factory;

import com.group12.entity.Login;

import java.time.LocalDate;

/**
 * @author Bradley van der Westhuizen - 217218903
 * Desc: Factory for login
 * Date: 3 July 2020
 */

public class LoginFactory
{
    public static Login createLogin(LocalDate loginDate, LocalDate logoutDate, boolean loginStatus)
    {
        return new Login.Builder()
                .setLoginDate(loginDate)
                .setLogoutDate(logoutDate)
                .setLoginStatus(loginStatus)
                .build();
    }
}

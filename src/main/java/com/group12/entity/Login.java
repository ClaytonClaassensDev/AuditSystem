package com.group12.entity;

import java.time.LocalDate;

/**
 * @author Bradley van der Westhuizen - 217218903
 * Desc: Value object for login
 * Date: 3 July 2020
 */

public class Login
{
    private LocalDate loginDate;
    private LocalDate logoutDate;
    private boolean loginStatus;

    private Login(Builder builder)
    {
        this.loginDate = builder.loginDate;
        this.logoutDate = builder.logoutDate;
        this.loginStatus = builder.loginStatus;
    }

    public LocalDate getLoginDate() {
        return loginDate;
    }

    public LocalDate getLogoutDate() {
        return logoutDate;
    }

    public boolean isLoginStatus() {
        return loginStatus;
    }

    @Override
    public String toString()
    {
        return "Login{" +
                "loginDate=" + loginDate +
                ", logoutDate=" + logoutDate +
                ", loginStatus=" + loginStatus +
                '}';
    }

    public static class Builder
    {
        private LocalDate loginDate;
        private LocalDate logoutDate;
        private boolean loginStatus;

        public Builder setLoginDate(LocalDate loginDate)
        {
            this.loginDate = loginDate;
            return this;
        }
        public Builder setLogoutDate(LocalDate logoutDate)
        {
            this.logoutDate = logoutDate;
            return this;
        }
        public Builder setLoginStatus(boolean loginStatus)
        {
            this.loginStatus = loginStatus;
            return this;
        }

        public Builder copy(Login login)
        {
            this.loginDate = login.loginDate;
            this.logoutDate = login.logoutDate;
            this.loginStatus = login.loginStatus;
            return this;
        }

        public Login build()
        {
            return new Login(this);
        }
    }
}

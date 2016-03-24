package com.robertsikora.core.model;

import java.util.Objects;

/**
 * Created by robertsikora on 18.03.2016.
 */
public class User extends RedisEntity<Long> {

    private String login;
    private String password;
    private String fName;
    private String lName;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(fName, user.fName) &&
                Objects.equals(lName, user.lName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, fName, lName);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("login='").append(login).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", fName='").append(fName).append('\'');
        sb.append(", lName='").append(lName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

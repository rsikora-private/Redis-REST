package com.robertsikora.rest.dto;

import java.io.Serializable;

/**
 * Created by robertsikora on 18.03.2016.
 */
public class UserDto implements Dto, Serializable {

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
}

package com.gaguena.pocelk.data;

import java.io.Serializable;

import org.mindrot.jbcrypt.BCrypt;

import lombok.Builder;

@Builder
public class UserData implements Serializable {

    private static final long serialVersionUID = 1L;

    private static Integer WORK = 12;
    private String userName;
    private String password;

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return bCrypt(password);
    }

    private static String bCrypt(final String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(WORK));
    }

}

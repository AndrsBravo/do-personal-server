package com.personal.backoffice.shared.utils;

import com.personal.backoffice.user.entities.Credentials;

public interface IPasswordEncryptProvider {

    public Credentials hash(String password);

    public boolean verifyPassword(String inputPassword, Credentials userCredentials);
}

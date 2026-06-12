package com.personal.backoffice.register.password.services;

import com.personal.backoffice.shared.utils.IPasswordEncryptProvider;
import com.personal.backoffice.user.entities.Credentials;
import com.personal.backoffice.user.entities.User;

public class VerifyPasswordService {

    private final IPasswordEncryptProvider encryptProvider;

    public VerifyPasswordService(IPasswordEncryptProvider encryptProvider) {

        this.encryptProvider = encryptProvider;
    }

    public boolean verify(User user) {

        var password = "";
        var credentials = new Credentials();

        boolean verifyPassword = encryptProvider.verifyPassword(password, credentials);
        return verifyPassword;

    }
}

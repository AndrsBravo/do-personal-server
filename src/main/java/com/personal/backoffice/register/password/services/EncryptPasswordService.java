package com.personal.backoffice.register.password.services;

import com.personal.backoffice.shared.utils.IPasswordEncryptProvider;
import com.personal.backoffice.user.entities.Credentials;

public class EncryptPasswordService {

    private final IPasswordEncryptProvider encryptProvider;

    public EncryptPasswordService(IPasswordEncryptProvider encryptProvider) {

        this.encryptProvider = encryptProvider;
    }

    public Credentials encryptPassword(String password) {

        Credentials credentials = encryptProvider.hash(password);
        return credentials;
    }
}

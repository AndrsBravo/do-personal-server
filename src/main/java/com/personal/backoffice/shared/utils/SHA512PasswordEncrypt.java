package com.personal.backoffice.shared.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import com.personal.backoffice.user.entities.Credentials;

public class SHA512PasswordEncrypt implements IPasswordEncryptProvider {

    public Credentials hash(String password) {
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);

        try {

            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt);

            byte[] hashedPassword = md.digest(password.getBytes());
            String hashed = Base64.getEncoder().encodeToString(hashedPassword);

            return new Credentials(hashed, salt);

        } catch (NoSuchAlgorithmException e) {

            return null;
        }

    }

    public boolean verifyPassword(String inputPassword, Credentials userCredentials) {

        try {

            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(userCredentials.salt());

            byte[] hashedInputPassword = md.digest(inputPassword.getBytes());
            String newHash = Base64.getEncoder().encodeToString(hashedInputPassword);

            return newHash.equals(userCredentials.password());

        } catch (NoSuchAlgorithmException ex) {

            return false;

        }

    }

}

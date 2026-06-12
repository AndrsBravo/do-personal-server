package com.personal.backoffice.register.factories;

import com.personal.backoffice.register.password.services.EncryptPasswordService;
import com.personal.backoffice.register.password.services.VerifyPasswordService;
import com.personal.backoffice.shared.utils.SHA512PasswordEncrypt;

public class UserRegisterServiceFactory {

    public static VerifyPasswordService VerifyPasswordService() {
        SHA512PasswordEncrypt encrypt = new SHA512PasswordEncrypt();
        return new VerifyPasswordService(encrypt);
    }

    public static EncryptPasswordService EncryptPasswordService() {
        SHA512PasswordEncrypt encrypt = new SHA512PasswordEncrypt();
        return new EncryptPasswordService(encrypt);
    }

}

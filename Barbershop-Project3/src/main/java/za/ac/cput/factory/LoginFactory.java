package za.ac.cput.factory;

import za.ac.cput.domain.Login;

public class LoginFactory {

    public static Login createLogin(String username, String password) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        return new Login.Builder()
                .setUsername(username)
                .setPassword(password)
                .build();
    }
}



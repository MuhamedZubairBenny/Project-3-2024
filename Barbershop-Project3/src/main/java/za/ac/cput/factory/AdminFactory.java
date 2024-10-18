package za.ac.cput.factory;

import za.ac.cput.domain.Admin;
import za.ac.cput.util.Helper;

public class AdminFactory {
    public static Admin buildAdmin (String adminId, String username, String password){
        if (Helper.isNullOrEmpty(adminId)){
            throw new IllegalArgumentException("Admin ID cannot be null or empty");
        }
        if (Helper.isNullOrEmpty(username)){
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        if (Helper.isNullOrEmpty(password)){
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        return new Admin.Builder().setAdmin_id(adminId)
                .setUsername(username)
                .setPassword(password)
                .build();
    }

    public static Admin buildAdmin (String username, String password){
        if (Helper.isNullOrEmpty(username)){
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        if (Helper.isNullOrEmpty(password)){
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        String adminId = Helper.generateId();

        return new Admin.Builder().setAdmin_id(adminId)
                .setUsername(username)
                .setPassword(password)
                .build();
    }
}

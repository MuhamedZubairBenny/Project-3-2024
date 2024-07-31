package za.ac.cput.factory;

import za.ac.cput.domain.Admin;
import za.ac.cput.util.Helper;

public class AdminFactory {
    public static Admin buildAdmin (String admin_id, String username, String password){
        if (Helper.isNullOrEmpty(admin_id) || Helper.isNullOrEmpty(username) || Helper.isNullOrEmpty(password))
            return null;

        return new Admin.Builder().setAdmin_id(admin_id)
                .setUsername(username)
                .setPassword(password)
                .build();
    }

    public static Admin buildAdmin (String username, String password){
        if (Helper.isNullOrEmpty(username) || Helper.isNullOrEmpty(password))
            return null;
        String admin_id = Helper.generateId();

        return new Admin.Builder().setAdmin_id(admin_id)
                .setUsername(username)
                .setPassword(password)
                .build();
    }
}

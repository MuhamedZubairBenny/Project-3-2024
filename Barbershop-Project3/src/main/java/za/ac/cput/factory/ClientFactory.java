package za.ac.cput.factory;

import za.ac.cput.domain.Client;
import za.ac.cput.util.Helper;

public class ClientFactory {
    public static Client buildClient(Long id,String username, String password,String userType,String email, String phone,String firstName,String surname){
        if(!Helper.emailIsValid(email)){
            return null;
        }
        else if (Helper.isNullOrEmpty(username)||Helper.isNullOrEmpty(password)||Helper.isNullOrEmpty(phone)
        || Helper.isNullOrEmpty(firstName)||Helper.isNullOrEmpty(surname) ||Helper.isNullOrEmpty(userType)){
            return null;
        }

        return new Client.Builder().setEmail(email)
                .setUsername(username)
                .setPassword(password)
                .setUserType(userType)
                .setPhone(phone)
                .setFirstName(firstName)
                .setSurname(surname)
                .build();
    }
}

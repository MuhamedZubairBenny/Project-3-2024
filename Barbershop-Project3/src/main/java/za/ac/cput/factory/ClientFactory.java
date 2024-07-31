package za.ac.cput.factory;

import za.ac.cput.domain.Client;
import za.ac.cput.util.Helper;

public class ClientFactory {
    public static Client buildClient(String email, String username, String password,String phone,String firstName,String surname){
        if(!Helper.emailIsValid(email)){
            return null;
        }
        else if (Helper.isNullOrEmpty(username)||Helper.isNullOrEmpty(password)||Helper.isNullOrEmpty(phone)
        || Helper.isNullOrEmpty(firstName)||Helper.isNullOrEmpty(surname) ){
            return null;
        }

        return new Client.Builder().setEmail(email)
                .setUsername(username)
                .setPassword(password)
                .setPhone(phone)
                .setFirstName(firstName)
                .setSurname(surname)
                .build();
    }
}

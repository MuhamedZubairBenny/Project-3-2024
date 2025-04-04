package za.ac.cput.factory;

import za.ac.cput.domain.Barber;
import za.ac.cput.util.Helper;

public class BarberFactory {
    public static Barber buildBarber(String id, String username, String name, String password, String specialization, String phoneNum){
        if (Helper.isNullOrEmpty(id)||Helper.isNullOrEmpty(username)||Helper.isNullOrEmpty(name)||Helper.isNullOrEmpty(password)||Helper.isNullOrEmpty(specialization)||Helper.isNullOrEmpty(phoneNum))
            return null;

        return new Barber.Builder().setId(id).setUsername(username).setName(name).setPassword(password).setSpecialization(specialization).setPhoneNum(phoneNum)
                .build();
    }
    public static Barber buildBarber(String username, String name, String password, String specialization, String phoneNum){
        if (Helper.isNullOrEmpty(username)||Helper.isNullOrEmpty(name)||Helper.isNullOrEmpty(password)||Helper.isNullOrEmpty(specialization)||Helper.isNullOrEmpty(phoneNum))
            return null;
        String id = Helper.generateId();

        return new Barber.Builder().setId(id).setUsername(username).setName(name).setPassword(password).setSpecialization(specialization).setPhoneNum(phoneNum)
                .build();
    }
}

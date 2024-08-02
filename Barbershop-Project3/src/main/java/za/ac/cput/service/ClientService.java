package za.ac.cput.service;

import za.ac.cput.domain.Client;

import java.util.List;

public interface ClientService extends IService <Client, Long> {

    List<Client> getAll();

    boolean validateLogin(String username, String password, String userType);

    Client getClientByUsername(String username);

}
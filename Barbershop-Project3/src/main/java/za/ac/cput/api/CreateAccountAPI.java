package za.ac.cput.api;

import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.domain.Client;
import za.ac.cput.factory.ClientFactory;
import za.ac.cput.service.ClientServiceImpl;

@Component
public class CreateAccountAPI {
    @Autowired
    private ClientServiceImpl clientService;

    public Client createClient(String username,String password,String userType,String email,String phone,String firstName,String surname){
        Client client= new Client.Builder()
                .setUsername(username)
                .setPassword(password)
                .setUserType(userType)
                .setEmail(email)
                .setPhone(phone)
                .setFirstName(firstName)
                .setSurname(surname)
                .build();
        System.out.println(client);
        return client;
    }
    public void saveClient(Client client){
        Client createClient= ClientFactory.buildClient(client.getId(),client.getUsername(),client.getPassword(),client.getUserType(),client.getEmail(), client.getPhone(), client.getFirstName(), client.getSurname());
        clientService.create(createClient);
    }
}

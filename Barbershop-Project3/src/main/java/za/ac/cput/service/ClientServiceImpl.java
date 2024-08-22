package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Client;
import za.ac.cput.repository.ClientRepository;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService{
    private ClientRepository clientRepository;
    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {this.clientRepository = clientRepository;}


    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public boolean validateLogin(String username, String password, String userType) {
        return clientRepository.existsByUsernameAndPasswordAndUserType(username,password,userType);
    }

    @Override
    public Client getClientByUsername(String username) {
        return clientRepository.findClientByUsername(username);
    }

    @Override
    public Client create(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client read(Long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public Client update(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public void delete(Long id) {
        clientRepository.deleteById(id);
    }
}

package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Client;
import za.ac.cput.repository.ClientRepository;

import java.util.List;

@Service
public class ClientService implements IClientService{
    private ClientRepository clientRepository;
    @Autowired
    public ClientService(ClientRepository clientRepository) {this.clientRepository = clientRepository;}

    @Override
    public Client create(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client read(String email) {
        return clientRepository.findClientByEmail(email);
    }

    @Override
    public Client update(Client client) {
        return clientRepository.save(client);
    }
    @Override
    public List<Client> getAll() {
        return clientRepository.findAll();
    }

    @Override
    public void delete(String email) {
        clientRepository.deleteById(email);
    }
}

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    Client findClientByEmail(String email);
    void deleteClientByEmail(String email);
    void deleteClientsByEmail(String email);

}

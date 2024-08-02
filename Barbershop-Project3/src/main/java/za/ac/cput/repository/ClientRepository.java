package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    boolean existsByUsernameAndPasswordAndUserType(String username, String password, String userType);
    Client findClientByUsername(String username);
    void deleteClientByEmail(String email);
    void deleteClientsByEmail(String email);

}

package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {
    Admin findByUsername(String username);
}

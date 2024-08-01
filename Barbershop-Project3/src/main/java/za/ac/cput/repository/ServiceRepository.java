package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Service;

import java.util.List;
import java.util.Optional;

public interface ServiceRepository extends JpaRepository<Service, String> {
    Optional<Service> findByServiceName(String serviceName);
    List<Service> findByServicePriceBetween(double minPrice, double maxPrice);
    boolean existsByServiceName(String serviceName);
    List<Service> findByServiceDescriptionContaining(String keyword);
}




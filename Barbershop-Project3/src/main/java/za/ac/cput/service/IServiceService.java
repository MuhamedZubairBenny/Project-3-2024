package za.ac.cput.service;

import za.ac.cput.domain.Service;

import java.util.List;
import java.util.Optional;

public interface IServiceService extends IService<Service, String> {
    Optional<Service> findByName(String serviceName);
    List<Service> findByPriceRange(double minPrice, double maxPrice);
    boolean existsByName(String serviceName);
    List<Service> findByDescriptionContaining(String keyword);
}



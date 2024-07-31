package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.repository.ServiceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceService implements IServiceService {

    private final ServiceRepository serviceRepository;

    @Autowired
    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    @Override
    public za.ac.cput.domain.Service create(za.ac.cput.domain.Service service) {
        return null;
    }

    @Override
    public za.ac.cput.domain.Service read(String s) {
        return null;
    }

    @Override
    public za.ac.cput.domain.Service update(za.ac.cput.domain.Service service) {
        return null;
    }

    @Override
    public void delete(String serviceId) {
        serviceRepository.deleteById(serviceId);
    }

    @Override
    public Optional<za.ac.cput.domain.Service> findByName(String serviceName) {
        return Optional.empty();
    }

    @Override
    public List<za.ac.cput.domain.Service> findByPriceRange(double minPrice, double maxPrice) {
        return null;
    }

    @Override
    public boolean existsByName(String serviceName) {
        return serviceRepository.existsByServiceName(serviceName);
    }

    @Override
    public List<za.ac.cput.domain.Service> findByDescriptionContaining(String keyword) {
        return null;
    }

    //MUST FIX NUR
    //@Override
    //public List<Service> getAll() {
    //    return serviceRepository.findAll();
    //}



}
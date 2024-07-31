package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Barber;
import za.ac.cput.repository.BarberRepository;

import java.util.List;

@Service
public class BarberServiceImpl implements BarberService{
    @Autowired
    private BarberRepository repository;

    @Override
    public Barber create(Barber barber) {
        return repository.save(barber);
    }

    @Override
    public Barber read(String s) {
        return repository.findById(s).orElse(null);
    }

    @Override
    public Barber update(Barber barber) {
        return repository.save(barber);
    }

    @Override
    public void delete(String id) {repository.deleteById(id);}

    @Override
    public List<Barber> getall() {
        return repository.findAll();
    }
}

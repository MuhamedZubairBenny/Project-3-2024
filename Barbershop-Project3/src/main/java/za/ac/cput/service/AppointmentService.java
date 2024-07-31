package za.ac.cput.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Appointment;
import za.ac.cput.repository.AppointmentRepository;

import java.util.List;

@Service
public class AppointmentService implements IAppointmentService{
    AppointmentRepository repository;
    @Autowired
    AppointmentService(AppointmentRepository repository){this.repository = repository;}

    @Override
    public Appointment create(Appointment appointment) {return repository.save(appointment);}

    @Override
    public Appointment read(String id) {return repository.findById(id).orElse(null);}

    @Override
    public Appointment update(Appointment appointment) {return repository.save(appointment);}

    @Override
    public void delete(String id) {repository.deleteById(id);}

    @Override
    public List<Appointment> getAll() {return repository.findAll();}
}

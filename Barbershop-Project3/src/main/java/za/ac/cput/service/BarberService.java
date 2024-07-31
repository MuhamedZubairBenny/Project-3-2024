package za.ac.cput.service;

import za.ac.cput.domain.Barber;

import java.util.List;

public interface BarberService extends IService<Barber, String>{
    List<Barber>getall();

}

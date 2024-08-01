package za.ac.cput.service;

import za.ac.cput.domain.Login;

public interface ILoginService extends IService<Login, String> {
    boolean loginExists(String username);
}




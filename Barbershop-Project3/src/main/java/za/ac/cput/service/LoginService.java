package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Login;
import za.ac.cput.repository.LoginRepository;

@Service
public class LoginService implements ILoginService {

    private final LoginRepository loginRepository;

    @Autowired
    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public Login create(Login login) {
        return loginRepository.save(login);
    }

    @Override
    public Login read(String username) {
        return loginRepository.findByUsername(username).orElse(null);
    }

    @Override
    public Login update(Login login) {
        return loginRepository.save(login);
    }

    @Override
    public void delete(String username) {
        loginRepository.deleteById(username);
    }

    @Override
    public boolean loginExists(String username) {
        return loginRepository.existsByUsername(username);
    }
}




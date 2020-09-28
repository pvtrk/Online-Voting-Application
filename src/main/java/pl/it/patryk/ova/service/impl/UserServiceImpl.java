package pl.it.patryk.ova.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.it.patryk.ova.dao.UserRepository;
import pl.it.patryk.ova.model.User;
import pl.it.patryk.ova.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository (UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public void save(User user) {
        this.userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {
        return this.userRepository.getOne(id);
    }
}

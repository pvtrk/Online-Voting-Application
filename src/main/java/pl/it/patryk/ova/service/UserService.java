package pl.it.patryk.ova.service;

import pl.it.patryk.ova.model.User;

public interface UserService {
    void save(User user);
    User getUserById(Long id);

}

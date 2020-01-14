package fr.formation.inti.services;

import fr.formation.inti.entities.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}

package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    
}

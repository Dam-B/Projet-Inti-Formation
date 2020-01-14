package fr.formation.inti.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	//Find by ID
}

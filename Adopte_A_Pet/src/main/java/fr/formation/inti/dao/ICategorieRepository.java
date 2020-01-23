package fr.formation.inti.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.inti.entities.Categorie;


public interface ICategorieRepository extends JpaRepository<Categorie, Integer> {
    Categorie findByIdcat(Integer idcat);
    Categorie findByCategorie(String categorie);
}

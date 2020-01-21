package fr.formation.inti.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import fr.formation.inti.Iservices.IAdoptionService;
import fr.formation.inti.dao.IAdoptionRepository;
import fr.formation.inti.entities.Adoption;
import fr.formation.inti.entities.Paiement;
import fr.formation.inti.entities.Pet;
import fr.formation.inti.entities.User;

public class AdoptionServiceImpl implements IAdoptionService{
	@Autowired
	private IAdoptionRepository adoptionRepository;

	@Override
	public Adoption findByUser(User user) {
		return adoptionRepository.findByUser(user);
	}

	@Override
	public Adoption findByIdadoption(Integer idadoption) {
		return adoptionRepository.findByIdadoption(idadoption);
	}

	@Override
	public Adoption findByPet(Pet pet) {
		return adoptionRepository.findByPet(pet);
	}

	@Override
	public void save(Adoption adoption) {
		adoptionRepository.save(adoption);
		
	}

	@Override
	public void update(Adoption adoption) {
		Integer idadoption = adoption.getIdadoption();
		Date dateDemande = adoption.getDateDemande();
		Paiement paiement = adoption.getPaiements();
		Pet pet = adoption.getPet();
		User user = adoption.getUser();
		Byte validationpaiement = adoption.getValidationPaiement();
		Byte validationprofil = adoption.getValidationProfile();
		
		Adoption fiche_a_Update = adoptionRepository.findByIdadoption(idadoption);
		
		fiche_a_Update.setDateDemande(dateDemande);
		fiche_a_Update.setPaiements(paiement);
		fiche_a_Update.setPet(pet);
		fiche_a_Update.setUser(user);
		fiche_a_Update.setValidationPaiement(validationpaiement);
		fiche_a_Update.setValidationProfile(validationprofil);
		
		adoptionRepository.saveAndFlush(fiche_a_Update);
		
		
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

}

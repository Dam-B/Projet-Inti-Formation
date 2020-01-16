package fr.formation.inti.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.inti.Iservices.IPetService;
import fr.formation.inti.dao.IPetRepository;
import fr.formation.inti.dao.IUserRepository;
import fr.formation.inti.entities.Adoption;
import fr.formation.inti.entities.Categorie;
import fr.formation.inti.entities.Departement;
import fr.formation.inti.entities.Historique;
import fr.formation.inti.entities.Pet;
import fr.formation.inti.entities.Transfert;
import fr.formation.inti.entities.User;
@Service
public class PetServiceImpl implements IPetService {
	@Autowired
	private IPetRepository petRepository;
	
	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public void save(Pet pet) {
		petRepository.save(pet);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Pet pet) {
		
		Adoption adoption = (Adoption) pet.getAdoptions();
		String age = pet.getAge();
		Categorie categorie = pet.getCategorie();
		int deptId = pet.getDeptid();
		Historique histo = (Historique) pet.getHistoriques();
		Transfert transfert = (Transfert) pet.getTransferts();
		User user = userRepository.findByIduser(Integer.toString(pet.getUser().getIduser()));
		
		Pet petDeBase = petRepository.findByIdpet(Integer.toString(pet.getIdpet()));
		
		petDeBase.setAdoptions((Set<Adoption>) adoption);
		petDeBase.setAge(age);
		petDeBase.setCategorie(categorie);
		petDeBase.setDeptid(deptId);
		petDeBase.setHistoriques((Set<Historique>) histo);
		petDeBase.setTransferts((Set<Transfert>) transfert);
		petDeBase.setUser(user);
		
		petRepository.save(petDeBase);
		
	}

	@Override
	public void delete(long id) {
		petRepository.deleteById(id);
		
	}

	@Override
	public Pet findByIddept(String iddept) {
		return petRepository.findByIddept(iddept);
	}

	@Override
	public Pet findByIduser(String iduser) {
		return petRepository.findByIduser(iduser);
	}

	@Override
	public Pet findByCategorie(String categorie) {
		return petRepository.findByCategorie(categorie);
	}

	@Override
	public Pet findByIdpet(String idpet) {
		return petRepository.findByIdpet(idpet);
	}

}

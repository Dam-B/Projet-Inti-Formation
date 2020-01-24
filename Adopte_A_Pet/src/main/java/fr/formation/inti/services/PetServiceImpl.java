package fr.formation.inti.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	public Pet save(Pet pet) {
		return petRepository.save(pet);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Pet update(Pet pet) {
		
		Adoption adoption = (Adoption) pet.getAdoptions();
		String age = pet.getAge();
		Categorie categorie = pet.getCategorie();
		Departement dept = pet.getDepartement();
		Historique histo = (Historique) pet.getHistoriques();
		Transfert transfert = (Transfert) pet.getTransferts();
		User user = userRepository.findByIduser(pet.getUser().getIduser());
		
		Pet petDeBase = petRepository.findByIdpet(pet.getIdpet());
		
		petDeBase.setAdoptions((Set<Adoption>) adoption);
		petDeBase.setAge(age);
		petDeBase.setCategorie(categorie);
		petDeBase.setDepartement(dept);
		petDeBase.setHistoriques((Set<Historique>) histo);
		petDeBase.setTransferts((Set<Transfert>) transfert);
		petDeBase.setUser(user);
		
		return petRepository.save(petDeBase);
		
	}

	@Override
	public void delete(Integer id) {
		petRepository.deleteById(id);
		
	}

	@Override
	public List<Pet> findByDepartement(Departement dept) {
		return petRepository.findByDepartement(dept);
	}

	@Override
	public Pet findByUser(User user) {
		return petRepository.findByUser(user);
	}

	@Override
	public List<Pet> findByCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		return petRepository.findByCategorie(categorie);
	}

	@Override
	public List<Pet> findAllPet() {
		Iterable<Pet> it = petRepository.findAll();
		List<Pet> employees = new ArrayList<Pet>();
		it.forEach(employees:: add);
		return employees;
	}
	
	public List<Pet> getAllPet(Integer pageNo, Integer pageSize, String sortBy)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
 
        Page<Pet> pagedResult = petRepository.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Pet>();
        }
    }
	
	public Page<Pet> getPage(Pageable pageable){
        return petRepository.findAll(pageable);
    }

	@Override
	public Pet findByIdpet(Integer idpet) {
		return petRepository.findByIdpet(idpet);
	}

	

}

package fr.formation.inti.Iservices;

import fr.formation.inti.entities.IndividualId;

public interface IIndividualsService {
	void save(IndividualId centre);
	void update(IndividualId centre);
	void delete(long id);
	
	IndividualId findByIduser(String iduser);
	IndividualId findByIddept(String iddept);
}

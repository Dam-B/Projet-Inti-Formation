package fr.formation.inti.jpa.dao;

import fr.formation.inti.entities.Employee;

/**
 * Notre classe EmployeeDaoImpl suit le modèle de conception Singleton qui
 * garantit qu'une seule instance de cette classe sera créée dans l'application.
 * Lors de la première création de classe, la méthode getEntityManager () est
 * chargée de créer une instance de EntityManager.
 * 
 * @author 
 *
 */
public class EmployeeDaoImpl extends GenericDaoImpl<Employee, Integer> implements IGenericDao<Employee, Integer>{
	public EmployeeDaoImpl() {
		setClazz(Employee.class);
	}

	
}

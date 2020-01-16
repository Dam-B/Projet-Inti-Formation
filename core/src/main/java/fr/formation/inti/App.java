package fr.formation.inti;

import fr.formation.inti.dao.DepartementHome;
import fr.formation.inti.dao.PetHome;
import fr.formation.inti.entities.Departement;
import fr.formation.inti.entities.Pet;
import fr.formation.inti.entities.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Departement dept = new Departement(150, 150, "LA MISERE");
    	DepartementHome deee = new DepartementHome();
        
        deee.persist(dept);
    }
}

package fr.formation.inti.filter;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.formation.inti.Iservices.IPetService;
import fr.formation.inti.entities.Categorie;
import fr.formation.inti.entities.Departement;
import fr.formation.inti.entities.Pet;
import fr.formation.inti.services.PetServiceImpl;

@Controller
@SessionAttributes("dtFilterView")
public class FilterViewPet implements Serializable {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Pet> pet1;
    private List<Pet> pet2;
 
    private List<Pet> filteredpet1;
    private List<Pet> filteredpet2;


    private IPetService service;
 
   
    public void init() {
        pet1 = service.findAllPet();
        pet2 = service.findAllPet();
    }
 
    public boolean filterByPrice(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if (filterText == null || filterText.equals("")) {
            return true;
        }
 
        if (value == null) {
            return false;
        }
 
        return ((Comparable) value).compareTo(getInteger(filterText)) > 0;
    }
 
//    public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
//        String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
//        if (filterText == null || filterText.equals("")) {
//            return true;
//        }
//        int filterInt = getInteger(filterText);
// 
//        Car car = (Car) value;
//        return car.getId().toLowerCase().contains(filterText)
//                || car.getBrand().toLowerCase().contains(filterText)
//                || car.getColor().toLowerCase().contains(filterText)
//                || (car.isSold() ? "sold" : "sale").contains(filterText)
//                || car.getYear() < filterInt
//                || car.getPrice() < filterInt;
//    }
 
    private int getInteger(String string) {
        try {
            return Integer.valueOf(string);
        }
        catch (NumberFormatException ex) {
            return 0;
        }
    }
 
    public List<Pet> getCat(Categorie categorie) {
        return service.findByCategorie(categorie);
    }
 
    public List<Pet> getLocation(Departement dept) {
        return service.findByDepartement(dept);
    }
 
    public List<Pet> getPet1() {
        return pet1;
    }
 
    public List<Pet> getPet2() {
        return pet2;
    }
 
    public List<Pet> getFilteredPet1() {
        return filteredpet1;
    }
 
    public void setFilteredPet1(List<Pet> filteredPet1) {
        this.filteredpet1 = filteredPet1;
    }
 
    public List<Pet> getFilteredPet2() {
        return filteredpet2;
    }
 
    public void setFilteredCars2(List<Pet> filteredPet2) {
        this.filteredpet2 = filteredPet2;
    }
 
    public void setService(PetServiceImpl service) {
        this.service = service;
    }
}
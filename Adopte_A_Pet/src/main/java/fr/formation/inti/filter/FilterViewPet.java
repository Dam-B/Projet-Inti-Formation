import java.io.Serializable;
import java.util.List;
import java.util.Locale;

import javax.annotation.PostConstruct;

import fr.formation.inti.entities.Categorie;
import fr.formation.inti.entities.Pet;
import fr.formation.inti.services.PetServiceImpl;

public class FilterViewPet implements Serializable {
 
    private List<Pet> pet1;
    private List<Pet> pet2;
 
    private List<Pet> filteredpet1;
    private List<Pet> filteredpet2;


    private PetServiceImpl service;
 
    @PostConstruct
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
 
    public List<String> getCat(Categorie categorie) {
        return service.findByCategorie(categorie);
    }
 
    public List<String> getColors() {
        return service.getColors();
    }
 
    public List<Car> getCars1() {
        return pet1;
    }
 
    public List<Car> getCars2() {
        return pet2;
    }
 
    public List<Car> getFilteredCars1() {
        return filteredpet1;
    }
 
    public void setFilteredCars1(List<Car> filteredCars1) {
        this.filteredpet1 = filteredCars1;
    }
 
    public List<Car> getFilteredCars2() {
        return filteredpet2;
    }
 
    public void setFilteredCars2(List<Car> filteredCars2) {
        this.filteredpet2 = filteredCars2;
    }
 
    public void setService(CarService service) {
        this.service = service;
    }
}
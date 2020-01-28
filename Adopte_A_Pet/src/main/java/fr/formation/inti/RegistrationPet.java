package fr.formation.inti;

public class RegistrationPet {

	private String name;
	private String race;
	private String age;
	private String idpet;

	public RegistrationPet() {
		// TODO Auto-generated constructor stub
	}

	public RegistrationPet(String name, String race, String age) {
		super();
		this.name = name;
		this.race = race;
		this.age = age;
	}

	public RegistrationPet(String name, String race, String age, String idpet) {
		super();
		this.name = name;
		this.race = race;
		this.age = age;
		this.idpet = idpet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getIdpet() {
		return idpet;
	}

	public void setIdpet(String idpet) {
		this.idpet = idpet;
	}

}

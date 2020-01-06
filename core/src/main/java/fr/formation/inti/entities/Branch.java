package fr.formation.inti.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity Customer
 * 
 * @author pc 07/12/2019
 */
@Entity
@Table(name = "branch")
public class Branch implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Set<Employee> employees = new HashSet<Employee>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "branch")
	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	private Integer branchId;

	@Column(name = "ADDRESS")
	private String adress;

	@Column(name = "CITY")
	private String city;

	@Column(name = "NAME")
	private String name;

	@Column(name = "STATE")
	private String state;

	@Column(name = "ZIP_CODE")
	private String zipCode;

	public Branch() {
		// TODO Auto-generated constructor stub
	}

	public Branch(String adress, String city, String name, String state, String zipCode) {
		super();
		this.adress = adress;
		this.city = city;
		this.name = name;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	
	public Branch(Integer branchId, String adress, String city, String name, String state,
			String zipCode) {
		super();
		this.branchId = branchId;
		this.adress = adress;
		this.city = city;
		this.name = name;
		this.state = state;
		this.zipCode = zipCode;
	}

	@Id
	@Column(name = "BRANCH_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Branch [branchId=" + branchId + ", adress=" + adress + ", city=" + city + ", name=" + name + ", state="
				+ state + ", zipCode=" + zipCode + "]";
	}

}

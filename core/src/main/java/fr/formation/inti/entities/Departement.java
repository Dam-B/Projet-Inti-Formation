package fr.formation.inti.entities;
// Generated 15 janv. 2020 16:53:54 by Hibernate Tools 5.2.12.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Departement generated by hbm2java
 */
@Entity
@Table(name = "departement", catalog = "adopt_a_pet")
public class Departement implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int deptid;
	private int departementCode;
	private String name;
	private Set<Centre> centres = new HashSet<Centre>(0);
	private Set<User> users = new HashSet<User>(0);

	public Departement() {
	}

	public Departement(int deptid, int departementCode, String name) {
		this.deptid = deptid;
		this.departementCode = departementCode;
		this.name = name;
	}

	public Departement(int deptid, int departementCode, String name, Set<Centre> centres,
			Set<User> users) {
		this.deptid = deptid;
		this.departementCode = departementCode;
		this.name = name;
		this.centres = centres;
		this.users = users;
	}

	@Id

	@Column(name = "deptid", unique = true, nullable = false)
	public int getDeptid() {
		return this.deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	@Column(name = "departement_code", nullable = false)
	public int getDepartementCode() {
		return this.departementCode;
	}

	public void setDepartementCode(int departementCode) {
		this.departementCode = departementCode;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departement")
	public Set<Centre> getCentres() {
		return this.centres;
	}

	public void setCentres(Set<Centre> centres) {
		this.centres = centres;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departement")
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

}

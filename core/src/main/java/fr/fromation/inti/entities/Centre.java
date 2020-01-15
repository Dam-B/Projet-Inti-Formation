package fr.fromation.inti.entities;
// Generated 15 janv. 2020 16:53:54 by Hibernate Tools 5.2.12.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Centre generated by hbm2java
 */
@Entity
@Table(name = "centre", catalog = "adopt_a_pet")
public class Centre implements java.io.Serializable {

	private Integer idcentre;
	private Departement departement;
	private User user;
	private String name;
	private String tel;
	private String city;
	private String postalCode;

	public Centre() {
	}

	public Centre(Departement departement, User user, String name) {
		this.departement = departement;
		this.user = user;
		this.name = name;
	}

	public Centre(Departement departement, User user, String name, String tel, String city, String postalCode) {
		this.departement = departement;
		this.user = user;
		this.name = name;
		this.tel = tel;
		this.city = city;
		this.postalCode = postalCode;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idcentre", unique = true, nullable = false)
	public Integer getIdcentre() {
		return this.idcentre;
	}

	public void setIdcentre(Integer idcentre) {
		this.idcentre = idcentre;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "deptid", nullable = false)
	public Departement getDepartement() {
		return this.departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "iduser", nullable = false)
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "tel", length = 45)
	public String getTel() {
		return this.tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Column(name = "city", length = 45)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "postal_code", length = 45)
	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

}

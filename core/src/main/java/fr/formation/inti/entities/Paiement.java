package fr.formation.inti.entities;
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
 * Paiement generated by hbm2java
 */
@Entity
@Table(name = "paiement", catalog = "adopt_a_pet")
public class Paiement implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idpaiement;
	private Adoption adoption;

	public Paiement() {
	}

	public Paiement(Adoption adoption) {
		this.adoption = adoption;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idpaiement", unique = true, nullable = false)
	public Integer getIdpaiement() {
		return this.idpaiement;
	}

	public void setIdpaiement(Integer idpaiement) {
		this.idpaiement = idpaiement;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idadoption", nullable = false)
	public Adoption getAdoption() {
		return this.adoption;
	}

	public void setAdoption(Adoption adoption) {
		this.adoption = adoption;
	}

}

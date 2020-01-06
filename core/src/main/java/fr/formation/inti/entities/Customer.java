package fr.formation.inti.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity Customer
 * @author pc
 * 07/12/2019
 */
@Entity
@Table(name = "customer")
public class Customer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CUST_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer custId;
	
	@Column(name = "ADDRESS")
	private String adress;
	
	@Column(name = "CITY")
	private String	city;
	
	@Column(name = "CUST_TYPE_CD",nullable = false)
	private String custTypeCd;
	
	@Column(name = "FED_ID",nullable = false)
	private String fedId;
	
	@Column(name = "POSTAL_CODE")
	private String postalCode;
	
	@Column(name = "STATE")
	private String state;
	
	public Integer getCustId() {
		return custId;
	}
	public void setCustId(Integer custId) {
		this.custId = custId;
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
	public String getCustTypeCd() {
		return custTypeCd;
	}
	public void setCustTypeCd(String custTypeCd) {
		this.custTypeCd = custTypeCd;
	}
	public String getFedId() {
		return fedId;
	}
	public void setFedId(String fedId) {
		this.fedId = fedId;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Customer(String adress, String city, String custTypeCd, String fedId, String postalCode, String state) {
		super();
		this.adress = adress;
		this.city = city;
		this.custTypeCd = custTypeCd;
		this.fedId = fedId;
		this.postalCode = postalCode;
		this.state = state;
	}
	
	public Customer() {
	}
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", adress=" + adress + ", city=" + city + ", custTypeCd=" + custTypeCd
				+ ", fedId=" + fedId + ", postalCode=" + postalCode + ", state=" + state + "]";
	}
	
	
}

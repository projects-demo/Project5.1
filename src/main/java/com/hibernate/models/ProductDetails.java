package com.hibernate.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "product_details")
public class ProductDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPfunctionality() {
		return pfunctionality;
	}

	public void setPfunctionality(String pfunctionality) {
		this.pfunctionality = pfunctionality;
	}

	private String pname;
	
	private String pfunctionality;
	
	



}

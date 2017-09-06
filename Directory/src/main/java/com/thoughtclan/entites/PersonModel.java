package com.thoughtclan.entites;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class PersonModel {

	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	public Integer id;

	private String name;
	private String phoneno;
	private String secondaryphoneno;

	@OneToMany(mappedBy = "person")
	private List<AddressModel> address = new ArrayList<AddressModel>();

	public PersonModel(Integer id, String name, String phoneno, String secondaryphoneno, List<AddressModel> address) {
		super();
		this.id = id;
		this.name = name;
		this.phoneno = phoneno;
		this.secondaryphoneno = secondaryphoneno;
		this.address = address;
	}

	public PersonModel() {

	}

	public List<AddressModel> getAddress() {
		return address;
	}

	public void setAddress(List<AddressModel> address) {
		this.address = address;
	}

	public String getSecondaryphoneno() {
		return secondaryphoneno;
	}

	public void setSecondaryphoneno(String secondaryphoneno) {
		this.secondaryphoneno = secondaryphoneno;
	}

	@NotEmpty(message = "name cannot be null")
	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id2) {
		this.id = id2;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

}
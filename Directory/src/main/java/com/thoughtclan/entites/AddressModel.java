package com.thoughtclan.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class AddressModel {
    private int houseNo;
    private String street;
    private String locality;
    private String city;
    private String state;
    private String zipcode;
    private String addressType;
    
    @ManyToOne(targetEntity = PersonModel.class)
    private PersonModel person;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int addressid;

    public PersonModel getPerson() {
        return person;
    }

    public void setPerson(PersonModel person) {
        this.person = person;
    }

    public int getAddressid() {
        return addressid;
    }

    public void setAddressid(int addressid) {
        this.addressid = addressid;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    // @Override
    // public String toString() {
    // return "Address [employee=" + person.getId() + ", project=" +
    // person.getPhoneno() + "]";
    // }
    

    public AddressModel() {

    }

    public AddressModel(int addressid,int houseNo, String street, String locality, String city, String state, String zipcode,
            String addressType, PersonModel person) {
        super();
        this.addressid = addressid;

        this.houseNo = houseNo;
        this.street = street;
        this.locality = locality;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.addressType = addressType;
        this.person = person;
    }

}
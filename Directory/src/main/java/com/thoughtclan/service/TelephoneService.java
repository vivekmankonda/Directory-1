package com.thoughtclan.service;
import com.thoughtclan.entites.*;
import java.util.*;
public interface TelephoneService {

	public abstract boolean addPerson(String name, String phoneno);

	public abstract boolean delete(int id);

	public abstract void edit(PersonModel person);

	public abstract PersonModel searchId(int id);

	public abstract void display();
	
	public abstract List<PersonModel> getAllPersons();
	
	public abstract List<PersonModel> searchName(String name);
	
	public abstract PersonModel searchPhone(String phoneno);
}

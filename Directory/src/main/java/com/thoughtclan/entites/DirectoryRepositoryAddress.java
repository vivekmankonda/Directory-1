package com.thoughtclan.entites;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectoryRepositoryAddress extends CrudRepository<AddressModel, String> {
	

}

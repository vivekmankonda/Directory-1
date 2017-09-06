package com.thoughtclan.entites;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectoryRepository extends CrudRepository<PersonModel, Integer> {
	// Person findOneById(int id);
	List<PersonModel> findByName(String name);

	 PersonModel findByPhoneno(String phoneno);
}

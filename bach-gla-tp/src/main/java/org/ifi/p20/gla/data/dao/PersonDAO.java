package org.ifi.p20.gla.data.dao;

import java.util.List;

import org.ifi.p20.gla.data.model.Address;
import org.ifi.p20.gla.data.model.Person;
import org.ifi.p20.gla.data.model.PhoneNumber;

public interface PersonDAO {

	void save(Person person);

	void update(Person person);

	void delete(Person person);
	
	void delete(PhoneNumber phoneNumber);
	
	void delete(Address address);

	Person findByPersonId(int personId);
	
	List<Person> findByPersonName(String personName);
	
	List<Person> findAllPerson();
	
}

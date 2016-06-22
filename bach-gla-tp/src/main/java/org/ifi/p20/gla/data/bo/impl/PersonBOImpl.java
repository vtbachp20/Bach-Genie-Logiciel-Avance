package org.ifi.p20.gla.data.bo.impl;

import java.util.List;

import org.ifi.p20.gla.data.bo.PersonBO;
import org.ifi.p20.gla.data.dao.PersonDAO;
import org.ifi.p20.gla.data.model.Address;
import org.ifi.p20.gla.data.model.Person;
import org.ifi.p20.gla.data.model.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("personBO")
public class PersonBOImpl implements PersonBO {

	@Autowired
	PersonDAO personDAO;

	@Override
	public void save(Person person) {
		// TODO Auto-generated method stub
		personDAO.save(person);
	}

	@Override
	public void update(Person person) {
		// TODO Auto-generated method stub
		personDAO.update(person);
	}

	@Override
	public void delete(Person person) {
		// TODO Auto-generated method stub
		personDAO.delete(person);
	}

	@Override
	public Person findByPersonId(int personId) {
		return personDAO.findByPersonId(personId);
	}

	@Override
	public List<Person> findAllPerson() {
		return personDAO.findAllPerson();
	}

	@Override
	public List<Person> findByPersonName(String personName) {
		return personDAO.findByPersonName(personName);
	}

	@Override
	public void delete(PhoneNumber phoneNumber) {
		personDAO.delete(phoneNumber);
	}

	@Override
	public void delete(Address address) {
		personDAO.delete(address);
	}

}

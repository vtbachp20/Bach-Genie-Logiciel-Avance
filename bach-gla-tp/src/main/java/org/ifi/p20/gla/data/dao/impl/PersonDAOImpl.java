package org.ifi.p20.gla.data.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.ifi.p20.gla.data.dao.PersonDAO;
import org.ifi.p20.gla.data.model.Address;
import org.ifi.p20.gla.data.model.Person;
import org.ifi.p20.gla.data.model.PhoneNumber;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository("personDAO")
public class PersonDAOImpl implements PersonDAO {

	@PersistenceContext
	private EntityManager entityManager;

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	public void save(Person person) {
		entityManager.persist(person);
	}

	@Transactional
	public void update(Person person) {
		entityManager.merge(person);
	}

	@Transactional
	public void delete(Person person) {
		entityManager.remove(person);
	}

	public Person findByPersonId(int personId) {
		Person person = entityManager.find(Person.class, personId);
		entityManager.flush();
		return person;
	}

	public List<Person> findByPersonName(String personName) {
		return entityManager.createNamedQuery("Person.findPersonByName", Person.class)
				.setParameter("personName", "%" + personName + "%").getResultList();
	}

	public List<Person> findAllPerson() {
		return entityManager.createNamedQuery("Person.findAll", Person.class).getResultList();
	}

	@Override
	public void delete(PhoneNumber phoneNumber) {
		entityManager.remove(phoneNumber);
	}

	@Override
	public void delete(Address address) {
		entityManager.remove(address);
	}


}

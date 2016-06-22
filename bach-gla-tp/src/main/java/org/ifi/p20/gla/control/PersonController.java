package org.ifi.p20.gla.control;

import java.util.List;

import org.ifi.p20.gla.data.bo.PersonBO;
import org.ifi.p20.gla.data.model.Address;
import org.ifi.p20.gla.data.model.Person;
import org.ifi.p20.gla.data.model.PhoneNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Transactional
public class PersonController {
	@Autowired
	private PersonBO personBO;

	public void setPersonBO(PersonBO personBO) {
		this.personBO = personBO;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String redirectToHome() {
		return "redirect:/persons";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam("personName") String personName, Model model) {
		List<Person> persons = personBO.findByPersonName(personName);
		model.addAttribute("person", new Person());
		model.addAttribute("listPersons", persons);
		if (persons.size() <= 0)
			model.addAttribute("msg", "Desole, On n'a rien trouve avec le mot: " + personName);
		return "person";
	}

	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute("person", new Person());
		List<Person> list = this.personBO.findAllPerson();
		System.out.println("" + list.size());
		model.addAttribute("listPersons", list);
		return "person";
	}

	// For add and update person both
	@RequestMapping(value = "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") Person person) {

		if (person.getPersonId() == 0) {
			// new person, add it
			this.personBO.save(person);
		} else {
			// existing person, call update
			this.personBO.update(person);
		}

		return "redirect:/persons";

	}

	@RequestMapping(value = "/remove/{id}")
	public String removePerson(@PathVariable("id") int id) {
		Person person = personBO.findByPersonId(id);
		if (person != null)
			personBO.delete(person);

		return "redirect:/persons";
	}

	@RequestMapping("/edit/{id}")
	public String editPerson(@PathVariable("id") int id, Model model) {
		Person person = personBO.findByPersonId(id);
		if (person != null) {
			model.addAttribute("person", person);
		} else {
			model.addAttribute("person", new Person());
			model.addAttribute("msg", "Desole, On ne peut pas trouver cette personne!");
		}
		model.addAttribute("listPersons", this.personBO.findAllPerson());
		model.addAttribute("address", new Address());
		model.addAttribute("phoneNumber", new PhoneNumber());
		return "person";
	}

	@RequestMapping(value = "/edit/{id}/address", method = RequestMethod.POST)
	public String editPerson(@ModelAttribute("address") Address address, @PathVariable("id") int id, Model model) {
		Person person = personBO.findByPersonId(id);
		person.addAddress(address);

		return "redirect:/edit/" + id;
	}

	@RequestMapping(value = "/edit/{id}/phone", method = RequestMethod.POST)
	public String editPerson(@ModelAttribute("phoneNumber") PhoneNumber phoneNumber, @PathVariable("id") int id,
			Model model) {
		Person person = personBO.findByPersonId(id);
		person.addPhoneNumber(phoneNumber);

		return "redirect:/edit/" + id;
	}

	@RequestMapping(value = "/removeaddress/{id}/{idAddress}", method = RequestMethod.GET)
	public String editPersonAddress(@PathVariable("id") int id, @PathVariable("idAdress") int idAddress, Model model) {
		Person person = personBO.findByPersonId(id);
		if (person != null) {
			List<Address> addresses = person.getAddresses();
			for (Address address : addresses) {
				if (address.getAddressId() == idAddress) {
					person.removeAddress(address);
					// personBO.delete(address);
					break;
				}
			}
		}

		return "redirect:/edit/" + id;
	}

	@RequestMapping(value = "/removephone/{id}/{idPhone}", method = RequestMethod.GET)
	public String editPersonPhone(@PathVariable("id") int id, @PathVariable("idPhone") int idPhone, Model model) {
		Person person = personBO.findByPersonId(id);
		if (person != null) {
			List<PhoneNumber> phoneNumbers = person.getPhoneNumbers();
			for (PhoneNumber phoneNumber : phoneNumbers) {
				if (phoneNumber.getPhoneNumberId() == idPhone) {
					person.removePhoneNumber(phoneNumber);
					// personBO.delete(phoneNumber);
					break;
				}
			}
		}

		return "redirect:/edit/" + id;
	}
}

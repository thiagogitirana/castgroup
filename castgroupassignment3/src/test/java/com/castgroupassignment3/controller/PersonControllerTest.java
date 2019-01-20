package com.castgroupassignment3.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.castgroupassignment3.entity.Address;
import com.castgroupassignment3.entity.Person;
import com.castgroupassignment3.entity.Phone;
import com.castgroupassignment3.exception.BusinessException;
import com.castgroupassignment3.repository.PersonRepository;

/**
 * Testa o controlador rest Pessoa
 * @author Thiago Gitirana
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonControllerTest {

	@Mock
	private PersonRepository repository;

	@InjectMocks
	private PersonController controller;

	private List<Person> persons;

	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);

		createPersons();

		when(repository.findAll()).thenReturn(persons);

		Optional<Person> person = Optional.of(persons.get(0));
		when(repository.findById(1l)).thenReturn(person);

		when(repository.save(Mockito.any())).thenReturn(new Person());
		Mockito.doNothing().when(repository).deleteById(Mockito.any());
	}

	private void createPersons() {
		persons = new ArrayList<Person>();

		Person person1 = new Person();
		person1.setId(1L);
		person1.setName("João");

		Address address1 = new Address(1l, "Rua teste1", 123, "Afogados", "Recife", "Pernambuco", person1);
		person1.setAddress(address1);

		Phone phone1 = new Phone(1l, 954954954l, 123456789l, person1);
		Phone phone2 = new Phone(2l, 88558844l, 5646543l, person1);
		List<Phone> phones1 = new ArrayList<Phone>();
		phones1.add(phone1);
		phones1.add(phone2);

		person1.setPhones(phones1);

		Person person2 = new Person();
		person2.setId(1l);
		person2.setName("Maria");

		Address address2 = new Address(2l, "Rua teste2", 321, "Boa Viagem", "Recife", "Pernambuco", person2);
		person2.setAddress(address2);

		Phone phone3 = new Phone(3l, 99889898l, 2233225l, person2);
		Phone phone4 = new Phone(4l, 88558844l, 5646543l, person2);
		List<Phone> phones2 = new ArrayList<Phone>();
		phones2.add(phone3);
		phones2.add(phone4);

		person2.setPhones(phones2);

		persons.add(person1);
		persons.add(person2);
	}

	@Test
	public void testListAllPersons() throws BusinessException {
		ResponseEntity<List<Person>> retorno = controller.listAllPersons();
		List<Person> persons = retorno.getBody();

		assertEquals("João", persons.get(0).getName());
		assertEquals("Maria", persons.get(1).getName());
	}

	@Test
	public void testFindPersonById() throws BusinessException {
		ResponseEntity<Person> retorno = controller.findPersonById(1);
		Person persons = retorno.getBody();

		assertEquals("João", persons.getName());

	}

	@Test
	public void testSavePerson() throws BusinessException {
		ResponseEntity<String> retorno = controller.savePerson(persons.get(0));
		assertEquals("Success", retorno.getBody());

	}

	@Test
	public void testDeleteById() throws BusinessException {
		ResponseEntity<String> retorno = controller.deleteById(1);
		assertEquals("Success", retorno.getBody());

	}

}

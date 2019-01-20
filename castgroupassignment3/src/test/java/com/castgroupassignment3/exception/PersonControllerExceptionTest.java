package com.castgroupassignment3.exception;

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

import com.castgroupassignment3.controller.PersonController;
import com.castgroupassignment3.dto.OutputError;
import com.castgroupassignment3.entity.Address;
import com.castgroupassignment3.entity.Person;
import com.castgroupassignment3.entity.Phone;
import com.castgroupassignment3.repository.PersonRepository;

/**
 * Testa o controlador rest Pessoa
 * 
 * @author Thiago Gitirana
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonControllerExceptionTest {

	@InjectMocks
	private PersonController controller;

	@Before
	public void before() {
		MockitoAnnotations.initMocks(this);
	}

	@Test(expected = BusinessException.class)
	public void testListAllPersons() throws BusinessException {
		ResponseEntity<List<Person>> retorno = controller.listAllPersons();
		List<Person> persons = retorno.getBody();

		assertEquals("João", persons.get(0).getName());
		assertEquals("Maria", persons.get(1).getName());
	}

	@Test(expected = BusinessException.class)
	public void testFindPersonById() throws BusinessException {
		ResponseEntity<Person> retorno = controller.findPersonById(1);
		Person persons = retorno.getBody();

		assertEquals("João", persons.getName());

	}

	@Test(expected = BusinessException.class)
	public void testSavePerson() throws BusinessException {
		ResponseEntity<String> retorno = controller.savePerson(new Person());
		assertEquals("Success", retorno.getBody());

	}

	@Test(expected = BusinessException.class)
	public void testDeleteById() throws BusinessException {
		ResponseEntity<String> retorno = controller.deleteById(1);
		assertEquals("Success", retorno.getBody());

	}

	@Test
	public void testhandleAuthenticationException() {
		ResponseEntity<Object> retorno = controller
				.handleAuthenticationException(new BusinessException("Erro teste", 1));
		OutputError error = (OutputError) retorno.getBody();
		assertEquals("Erro teste", error.getMessage());
		assertEquals(Integer.valueOf(1), error.getErrorCode());
	}

}

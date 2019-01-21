package com.castgroupassignment3.exception;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.castgroupassignment3.controller.PersonController;
import com.castgroupassignment3.dto.OutputError;
import com.castgroupassignment3.entity.Person;

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
		controller.listAllPersons();
	}

	@Test(expected = BusinessException.class)
	public void testFindPersonById() throws BusinessException {
		controller.findPersonById(1L);

	}

	@Test(expected = BusinessException.class)
	public void testSavePerson() throws BusinessException {
		 controller.savePerson(new Person());

	}

	@Test(expected = BusinessException.class)
	public void testDeleteById() throws BusinessException {
		controller.deleteById(1L);
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

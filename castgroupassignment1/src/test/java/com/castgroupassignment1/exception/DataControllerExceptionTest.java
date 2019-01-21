package com.castgroupassignment1.exception;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.castgroupassignment1.controller.DataController;
import com.castgroupassignment1.dto.DataDTO;
import com.castgroupassignment1.dto.OutputError;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataControllerExceptionTest {

	@Autowired
	private DataController controller;

	@Before
	public void setUp() throws Exception {
	}

	@Test(expected = BusinessException.class)
	public void testSaveLeft() throws BusinessException {
		controller.saveLeft(1l, new DataDTO(null, null));
	}

	@Test(expected = BusinessException.class)
	public void testSaveRight() throws BusinessException {
		controller.saveRight(1l, new DataDTO(null, null));
	}

	@Test(expected = BusinessException.class)
	public void testAvaluateCondicao1() throws BusinessException {
		controller.avaluate(123l);
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

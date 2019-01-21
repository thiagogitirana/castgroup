package com.castgroupassignment1.controller;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.castgroupassignment1.dto.DataDTO;
import com.castgroupassignment1.entity.DataEntity;
import com.castgroupassignment1.exception.BusinessException;
import com.castgroupassignment1.repository.DataRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataControllerTest {
	
	@Autowired
	private DataController controller;
	
	@Autowired
	private DataRepository repository;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testSaveLeft() throws BusinessException {
		ResponseEntity<?> response = controller.saveLeft(1l, new DataDTO(null, "dGVzdGU="));
		Optional<DataEntity> retorno = repository.findById(1l);
		
		DataEntity entity = retorno.get();
		
		assertEquals("dGVzdGU=", entity.getLeftData());
		assertEquals("Sucess", response.getBody());
		
	}

	@Test
	public void testSaveRight() throws BusinessException {
		ResponseEntity<?> response = controller.saveRight(1l, new DataDTO(null, "dGVzdGU="));
		Optional<DataEntity> retorno = repository.findById(1l);
		
		DataEntity entity = retorno.get();
		
		assertEquals("dGVzdGU=", entity.getLeftData());
		assertEquals("Sucess", response.getBody());
	}

	@Test
	public void testAvaluateCondicao1() throws BusinessException {
		ResponseEntity<?> response = controller.avaluate(1l);
		assertEquals("True", response.getBody());
	}
	
	@Test
	public void testAvaluateCondicao2() throws BusinessException {
		controller.saveLeft(1l, new DataDTO(null, "dGVzdGU="));
		controller.saveRight(1l, new DataDTO(null, "dGV4dGU="));
		
		ResponseEntity<?> response = controller.avaluate(1l);
		
		assertEquals("Mainly offsets: 11 lengh 2 ", response.getBody());
	}
	
	@Test
	public void testAvaluateCondicao3() throws BusinessException {
		controller.saveLeft(1l, new DataDTO(null, "dGVzdGU="));
		controller.saveRight(1l, new DataDTO(null, "dGVzdGVz"));
		
		ResponseEntity<?> response = controller.avaluate(1l);
		
		assertEquals("Left size [5] - Right size [6]", response.getBody());
	}

}

package com.castgroupassignment3.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.castgroupassignment3.dto.OutputError;
import com.castgroupassignment3.entity.Person;
import com.castgroupassignment3.exception.BusinessException;
import com.castgroupassignment3.repository.PersonRepository;

/**
 * Controlador responsável por tratar as requisições rest
 * 
 * @author Thiago Gitirana
 *
 */
@RestController
@RequestMapping(path = "/rest")
public class PersonController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);

	@Autowired
	private PersonRepository personRepository;

	/**
	 * Lista todas as pessoas
	 * 
	 * @return List<Person>
	 * @throws BusinessException
	 */
	@RequestMapping(path = "/pessoas")
	public ResponseEntity<List<Person>> listAllPersons() throws BusinessException {
		try {
			List<Person> persons = (List<Person>) personRepository.findAll();			
			return ResponseEntity.ok(persons);
		} catch (Exception e) {
			LOGGER.error(e.getLocalizedMessage());
			throw new BusinessException(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST.value());
		}

	}

	/**
	 * Lista uma pessoa pelo id
	 * 
	 * @param id
	 * @return Person
	 * @throws BusinessException
	 */
	@RequestMapping(path = "/pessoa")
	public ResponseEntity<Person> findPersonById(long id) throws BusinessException {
		try {
			Optional<Person> person = personRepository.findById(id);
			return ResponseEntity.ok(person.get());
		} catch (Exception e) {
			LOGGER.error(e.getLocalizedMessage());
			throw new BusinessException(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST.value());
		}
	}

	/**
	 * Insere uma pessoa na base
	 * 
	 * @param person
	 * @return String
	 * @throws BusinessException
	 */
	@RequestMapping(path = "/pessoa/save")
	public ResponseEntity<String> savePerson(@RequestBody Person person) throws BusinessException {
		try {
			personRepository.save(person);
			LOGGER.info("Pessoa "+person.getName()+" salva com sucesso.");
			return ResponseEntity.ok("Success");
		} catch (Exception e) {
			LOGGER.error(e.getLocalizedMessage());
			throw new BusinessException(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST.value());
		}
	}

	/**
	 * Deleta pessoas pelo id
	 * 
	 * @param id
	 * @return String
	 * @throws BusinessException
	 */
	@RequestMapping(path = "/pessoa/remove")
	public ResponseEntity<String> deleteById(long id) throws BusinessException {
		try {
			personRepository.deleteById(id);
			LOGGER.info("Pessoa com id "+id+" deletada com sucesso.");
			return ResponseEntity.ok("Success");
		} catch (Exception e) {
			LOGGER.error(e.getLocalizedMessage());
			throw new BusinessException(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST.value());
		}
	}

	/**
	 * Trata as exceções de negócio
	 * 
	 * @param business
	 * @return ResponseEntity
	 */
	@ExceptionHandler({ BusinessException.class })
	public ResponseEntity<Object> handleAuthenticationException(BusinessException business) {
		OutputError error = new OutputError();
		error.setMessage(business.getMessage());
		error.setErrorCode(business.getCode());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}

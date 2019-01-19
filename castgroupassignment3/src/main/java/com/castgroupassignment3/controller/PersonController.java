package com.castgroupassignment3.controller;

import java.util.List;
import java.util.Optional;

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

@RestController
@RequestMapping(path = "/rest")
public class PersonController {

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
		List<Person> persons = (List<Person>) personRepository.findAll();
		return ResponseEntity.ok(persons);
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
		Optional<Person> person = personRepository.findById(id);
		return ResponseEntity.ok(person.get());
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
		personRepository.save(person);
		return ResponseEntity.ok("Success");
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
		personRepository.deleteById(id);
		return ResponseEntity.ok("Success");
	}

	/**
	 * Método responsável por tratar as exceções de negócio
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

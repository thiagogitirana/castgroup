package com.castgroupassignment1.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.castgroupassignment1.dto.DataDTO;
import com.castgroupassignment1.dto.OutputError;
import com.castgroupassignment1.enums.DataSide;
import com.castgroupassignment1.exception.BusinessException;
import com.castgroupassignment1.service.DataService;

/**
 * Controlador responsável por tratar as requisições rest
 * 
 * @author Thiago Gitirana
 *
 */
@RestController
@RequestMapping(path = "/v1/diff/{id}")
public class DataController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DataController.class);

	@Autowired
	private DataService service;

	/**
	 * @param id Iformar o id do dado base64 a ser comparado
	 * @param data Dado criptografado em base64
	 * @return Sucesso caso seja inserido na base
	 * @throws BusinessException
	 */
	@RequestMapping(path = "/left")
	public ResponseEntity<?> saveLeft(@PathVariable Long id, @RequestBody DataDTO data) throws BusinessException {
		try {
			data.setId(id);
			service.saveData(data, DataSide.LEFT);
			return ResponseEntity.ok("Sucess");
		} catch (Exception e) {
			throw new BusinessException(e.getLocalizedMessage(), 0);
		}
	}

	/**
	 * @param id Iformar o id do dado base64 a ser comparado
	 * @param data Dado criptografado em base64
	 * @return Sucesso caso seja inserido na base
	 * @throws BusinessException
	 */
	@RequestMapping(path = "/right")
	public ResponseEntity<?> saveRight(@PathVariable Long id, @RequestBody DataDTO data) throws BusinessException {
		try {
			data.setId(id);
			service.saveData(data, DataSide.RIGHT);
			return ResponseEntity.ok("Sucess");
		} catch (Exception e) {
			throw new BusinessException(e.getLocalizedMessage(), 0);
		}
	}

	/**
	 * @param id Informar o id dos dados a serem comparados
	 * @return True caso sejam iguais, o tamanho caso tenham tamanhos diferentes, e
	 *         as diferenças caso tenham o mesmo tamanho e não sejam iguais
	 * @throws BusinessException
	 */
	@RequestMapping(path = "/avaluate")
	public ResponseEntity<?> avaluate(@PathVariable Long id) throws BusinessException {

		try {
			String retorno = service.evaluateData(id);
			return ResponseEntity.ok(retorno);
		} catch (Exception e) {
			throw new BusinessException(e.getLocalizedMessage(), 0);
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
		LOGGER.error(business.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}

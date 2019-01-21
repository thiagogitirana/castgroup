package com.castgroupassignment1.service;

import com.castgroupassignment1.dto.DataDTO;
import com.castgroupassignment1.entity.DataEntity;
import com.castgroupassignment1.enums.DataSide;
import com.castgroupassignment1.exception.BusinessException;

/**
 * @author Thiago Gitirana
 *
 */
public interface DataService {

	/**
	 * Salva o objeto java na base
	 * 
	 * @param data Dado criptografado em base64
	 * @param side Qual lado deve ser gravado
	 * @return Objedo gravado na base
	 * @throws BusinessException
	 */
	public DataEntity saveData(DataDTO data, DataSide side) throws BusinessException;

	/**
	 * Valida os valores left e right
	 * 
	 * @param id Identificador dos dados a serem comparados
	 * @return True caso sejam iguais, o tamanho caso tenham tamanhos diferentes, e
	 *         as diferenças caso tenham o mesmo tamanho e não sejam iguais
	 * @throws BusinessException
	 */
	public String evaluateData(Long id) throws BusinessException;
}

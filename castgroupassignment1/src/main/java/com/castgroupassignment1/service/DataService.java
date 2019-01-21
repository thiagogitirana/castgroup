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
	 * @param data
	 * @param side
	 * @return DataEntity
	 * @throws BusinessException
	 */
	public DataEntity saveData(DataDTO data, DataSide side) throws BusinessException;

	/**
	 * Valida os valores left e right
	 * 
	 * @param id
	 * @return String
	 * @throws BusinessException
	 */
	public String evaluateData(Long id) throws BusinessException;
}

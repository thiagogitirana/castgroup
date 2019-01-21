package com.castgroupassignment1.util;

import java.util.Base64;

import com.castgroupassignment1.dto.DataDTO;
import com.castgroupassignment1.entity.DataEntity;
import com.castgroupassignment1.exception.BusinessException;

/**
 * Valida os dados do objeto data
 * 
 * @author Thiago Gitirana
 *
 */
public class ValidateData {

	/**
	 * Valida se o valor é criptografado usando a base64
	 * 
	 * @param data
	 * @return boolean
	 */
	public static boolean validateDataBase64(String data) {

		try {
			if (data == null)
				return false;
			Base64.getDecoder().decode(data);
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	/**
	 * Valida os valores passados pelo serviço
	 * 
	 * @param data
	 * @throws BusinessException Caso o objeto de entrada do serviço seja nulo, não
	 *                           seja base64 ou não seja informado o id
	 */
	public static void validateData(DataDTO data) throws BusinessException {
		if (data == null) {
			throw new BusinessException("Objeto data esta nulo", 1);
		} else if (!ValidateData.validateDataBase64(data.getData())) {
			throw new BusinessException("O valor do objeto não esta criptografado com base64", 2);
		} else if (data.getId() == null || data.getId() == 0) {
			throw new BusinessException("Id do objeto inválido", 3);
		}
	}

	/**
	 * Valida os campos left e right
	 * 
	 * @param entity
	 * @throws BusinessException Caso os dados left e right sejam nulos
	 */
	public static void validateData(DataEntity entity) throws BusinessException {
		if (entity.getLeftData() == null || entity.getLeftData().isEmpty()) {
			throw new BusinessException("É necessário o valor left para a avaliação", 4);
		}

		if (entity.getRightData() == null || entity.getRightData().isEmpty()) {
			throw new BusinessException("É necessário o valor right para a avaliação", 4);
		}
	}

}

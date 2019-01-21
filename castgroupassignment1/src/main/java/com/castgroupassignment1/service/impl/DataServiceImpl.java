package com.castgroupassignment1.service.impl;

import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castgroupassignment1.dto.DataDTO;
import com.castgroupassignment1.entity.DataEntity;
import com.castgroupassignment1.enums.DataSide;
import com.castgroupassignment1.exception.BusinessException;
import com.castgroupassignment1.repository.DataRepository;
import com.castgroupassignment1.service.DataService;
import com.castgroupassignment1.util.ValidateData;

/**
 * Serviço responsável por validar, gravar e avaliar os dados base64
 * 
 * @author Thiago Gitirana
 *
 */
@Service
public class DataServiceImpl implements DataService {

	@Autowired
	private DataRepository repository;

	@Override
	public DataEntity saveData(DataDTO data, DataSide side) throws BusinessException {

		ValidateData.validateData(data);
		DataEntity entity = getData(data.getId());

		if (entity == null) {
			entity = new DataEntity();
			entity.setId(data.getId());
		}

		if (DataSide.LEFT.equals(side)) {
			entity.setLeftData(data.getData());
		} else if (DataSide.RIGHT.equals(side)) {
			entity.setRightData(data.getData());
		}

		return repository.save(entity);
	}

	@Override
	public String evaluateData(Long id) throws BusinessException {

		DataEntity entity = getData(id);

		ValidateData.validateData(entity);

		byte[] leftBytes = Base64.getDecoder().decode(entity.getLeftData());
		byte[] rightBytes = Base64.getDecoder().decode(entity.getRightData());

		if (Arrays.equals(leftBytes, rightBytes)) {
			return "True";
		} else if (leftBytes.length != rightBytes.length) {
			return String.format("Left size [%s] - Right size [%s]", leftBytes.length, rightBytes.length);
		} else {

			StringBuilder builder = new StringBuilder();
			builder.append("Mainly offsets: ");
			for (int i = 0; i < rightBytes.length; i++) {
				byte leftByte = leftBytes[i];
				byte rightByte = rightBytes[i];

				int offset = leftByte ^ rightByte;

				if (offset != 0) {
					builder.append(offset).append(" lengh ").append(i).append(" - ");
				}
			}
			builder.replace(builder.length() - 2, builder.length(), "");
			return builder.toString();
		}
	}

	/**
	 * @param id
	 * @return DataEntity
	 * @throws BusinessException Caso não seja encontrado o id, ou o objeto
	 *                           retornado não contenhas os dados left e right
	 */
	private DataEntity getData(Long id) throws BusinessException {
		DataEntity entity = null;
		try {
			Optional<DataEntity> repoEntity = repository.findById(id);
			if (repoEntity.isPresent()) {
				entity = repoEntity.get();
			}

			return entity;
		} catch (IllegalArgumentException e) {
			throw new BusinessException(e.getLocalizedMessage(), 5);
		}
	}

}

package com.castgroupassignment1.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.castgroupassignment1.dto.DataDTO;
import com.castgroupassignment1.entity.DataEntity;
import com.castgroupassignment1.exception.BusinessException;

public class ValidateDataTest {

	@Test
	public void testValidateDataBase64Null() {
		assertTrue(ValidateData.validateDataBase64("dGVzdGU="));
		assertFalse(ValidateData.validateDataBase64("*****"));
		assertFalse(ValidateData.validateDataBase64(null));
	}


	@Test(expected = BusinessException.class)
	public void testValidateDataDataDTO() throws BusinessException {
		DataDTO data = null;
		ValidateData.validateData(data);
	}
	
	@Test(expected = BusinessException.class)
	public void testValidateDataDataDTONotValid() throws BusinessException {
		DataDTO data = new DataDTO();
		data.setData("*****");
		ValidateData.validateData(data);
	}

	@Test(expected = BusinessException.class)
	public void testValidateDataDataDTOInvalidId() throws BusinessException {
		DataDTO data = new DataDTO();
		data.setId(null);
		data.setData("dGVzdGU=");
		ValidateData.validateData(data);
	}
	
	@Test(expected = BusinessException.class)
	public void testValidateDataDataEntityLeftNull() throws BusinessException {
		DataEntity data = new DataEntity();
		ValidateData.validateData(data);
	}
	
	@Test(expected = BusinessException.class)
	public void testValidateDataDataEntityLeftEmpty() throws BusinessException {
		DataEntity data = new DataEntity();
		data.setLeftData("");
		ValidateData.validateData(data);
	}
	
	@Test(expected = BusinessException.class)
	public void testValidateDataDataEntityRightNull() throws BusinessException {
		DataEntity data = new DataEntity();
		data.setLeftData("dGVzdGU=");
		ValidateData.validateData(data);
	}
	
	@Test(expected = BusinessException.class)
	public void testValidateDataDataEntityRightEmpty() throws BusinessException {
		DataEntity data = new DataEntity();
		data.setLeftData("dGVzdGU=");
		data.setRightData("");
		ValidateData.validateData(data);
	}

}

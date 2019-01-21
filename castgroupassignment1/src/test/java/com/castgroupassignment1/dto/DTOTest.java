package com.castgroupassignment1.dto;

import static org.junit.Assert.assertNull;

import java.lang.reflect.Method;

import org.junit.Test;

import com.castgroupassignment1.entity.DataEntity;

/**
 * Teste das entidades e DTOs
 * 
 * @author Thiago Gitirana
 *
 */
public class DTOTest {

	@Test
	public void test() throws Exception {
		DataDTO dataDTO = new DataDTO();
		DataEntity dataEntity = new DataEntity();
		OutputError error = new OutputError();

		entityMethodsCoverage(dataDTO, dataEntity, error);
	}

	private void entityMethodsCoverage(Object... objects) throws Exception {
		for (Object obj : objects) {
			Class<? extends Object> clazz = obj.getClass();
			Method[] allMethods = clazz.getDeclaredMethods();
			for (Method method : allMethods) {
				String methodName = method.getName();
				if (methodName.startsWith("set")) {
					method.invoke(obj, new Object[] { null });
				}
				if (methodName.startsWith("get")) {
					assertNull(method.invoke(obj));
				}
			}
		}
	}

}

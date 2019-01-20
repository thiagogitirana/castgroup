package com.castgroupassignment3.entity;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.assertNull;

import com.castgroupassignment3.dto.OutputError;
import com.castgroupassignment3.entity.Address;
import com.castgroupassignment3.entity.Person;
import com.castgroupassignment3.entity.Phone;

/**
 * Teste das entidades e DTOs
 * 
 * @author Thiago Gitirana
 *
 */
public class EntityTest {

	@Test
	public void test() throws Exception {
		Address address = new Address();
		Person person = new Person();
		Phone phone = new Phone();
		OutputError error = new OutputError();

		entityMethodsCoverage(address, person, phone, error);
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

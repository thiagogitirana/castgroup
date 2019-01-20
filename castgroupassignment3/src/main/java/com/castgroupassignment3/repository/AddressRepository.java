package com.castgroupassignment3.repository;

import org.springframework.data.repository.CrudRepository;

import com.castgroupassignment3.entity.Address;

/**
 * @author Thiago Gitirana
 *
 */
public interface AddressRepository extends CrudRepository<Address, Long> {

}

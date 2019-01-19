package com.castgroupassignment3.repository;

import org.springframework.data.repository.CrudRepository;

import com.castgroupassignment3.entity.Person;

/**
 * @author Thiago Gitirana
 *
 */
public interface PersonRepository extends CrudRepository<Person, Long> {

}

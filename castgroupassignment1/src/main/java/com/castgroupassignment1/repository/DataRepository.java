package com.castgroupassignment1.repository;

import org.springframework.data.repository.CrudRepository;

import com.castgroupassignment1.entity.DataEntity;

/**
 * @author Thiago Gitirana
 *
 */
public interface DataRepository extends CrudRepository<DataEntity, Long> {

}

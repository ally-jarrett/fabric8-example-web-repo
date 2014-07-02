package org.fabric8.angular.dao.interfaces;

import java.util.List;

import org.fabric8.angular.entity.Entity;

public interface Dao<T extends Entity, I>
{

	List<T> findAll();


	T find(I id);


	T save(T user);


	void delete(I id);

}

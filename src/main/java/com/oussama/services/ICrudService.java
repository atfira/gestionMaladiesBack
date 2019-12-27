package com.oussama.services;

import java.util.List;

public interface ICrudService<T,ID> {

	List<T> getAll();
	
	T getById(ID id);
	
	void add(T entity);
	
	void update(T entity);
	
	void delete(ID id);
	
	void saveAll(Iterable<T> iterable);
}

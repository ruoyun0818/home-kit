package com.whitesky.home.service;

import java.util.List;

public interface GenericService<T> {
	T getModelById(int id);
	
	List<T> getModelList();
	
	int insert(T model);
}

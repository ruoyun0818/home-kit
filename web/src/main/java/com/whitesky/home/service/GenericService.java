package com.whitesky.home.service;

import java.util.List;

public interface GenericService<T> {
	List<T> getModelList();
	
	int insert(T model);
}

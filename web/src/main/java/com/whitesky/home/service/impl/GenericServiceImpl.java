package com.whitesky.home.service.impl;

import java.util.List;

import com.whitesky.home.dao.GenericMapper;
import com.whitesky.home.service.GenericService;

public abstract class GenericServiceImpl<T> implements GenericService<T> {
	
	protected GenericMapper<T> genericMapper;
	
	public GenericServiceImpl(GenericMapper<T> genericMapper) {
		this.genericMapper = genericMapper;
	}

	public T getModelById(int id) {
		return genericMapper.selectByPrimaryKey(id);
	}

	public List<T> getModelList() {
		return genericMapper.selectAll();
	}

	public int insert(T model) {
		return genericMapper.insertSelective(model);
	}

}

package com.whitesky.home.service.impl;

import java.io.Serializable;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.whitesky.home.dao.BaseMapper;
import com.whitesky.home.service.GenericService;
import com.whitesky.home.utils.ReflectionUtil;

public abstract class GenericServiceImpl<T, PK extends Serializable> implements GenericService<T, PK> {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	private Class<?> entityMapperClass;

	protected BaseMapper<T, PK> getBaseMapper() {
		SqlSession session = sqlSessionFactory.openSession();
		entityMapperClass = ReflectionUtil.getMatcherMapper(getClass());
		@SuppressWarnings("unchecked")
		BaseMapper<T, PK> baseMapper = (BaseMapper<T, PK>) session.getMapper(entityMapperClass);
		return baseMapper;
	}

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public void insert(T entity) {
		getBaseMapper().insert(entity);
	}

	@Override
	public void delete(PK primaryKey) {
		getBaseMapper().delete(primaryKey);
	}

	@Override
	public void update(T entity) {
		getBaseMapper().update(entity);
	}

	@Override
	public List<T> queryAll() {
		return getBaseMapper().queryAll();
	}

	@Override
	public T queryByPrimaryKey(PK primaryKey) {
		return getBaseMapper().queryByPrimaryKey(primaryKey);
	}

	@Override
	public List<T> queryAllByEntity(T entity) {
		return getBaseMapper().queryAllByEntity(entity);
	}

}

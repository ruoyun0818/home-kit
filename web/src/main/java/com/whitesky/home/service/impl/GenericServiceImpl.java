package com.whitesky.home.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.whitesky.home.dao.BaseMapper;
import com.whitesky.home.service.GenericService;
import com.whitesky.home.utils.ReflectionUtil;

public abstract class GenericServiceImpl<T extends BaseMapper<?, ?>> implements GenericService<T> {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	protected T mapper;
	
	@SuppressWarnings("unchecked")
	protected T getMapper(){
		if(mapper == null){
			SqlSession session = sqlSessionFactory.openSession();
			mapper = (T)session.getMapper(ReflectionUtil.getArgumentType(getClass()));
		}
		return mapper;
	}
	
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

}

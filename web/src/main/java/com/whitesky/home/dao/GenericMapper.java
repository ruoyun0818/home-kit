package com.whitesky.home.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericMapper<T> extends Serializable {
	int deleteByPrimaryKey(Integer id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);
    
    List<T> selectAll();
}

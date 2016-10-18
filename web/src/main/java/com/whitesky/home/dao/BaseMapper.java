package com.whitesky.home.dao;

import java.io.Serializable;
import java.util.List;

public abstract interface BaseMapper<T, PK extends Serializable> {
	/**  
     * 插入一个实体  
     * @param entity  
     */  
    PK insert(T entity) ;  
      
    /**  
     * 根据实体主键删除一个实体  
     * @param primaryKey  
     */  
    void delete(PK primaryKey);  
      
    /**  
     * 更新一个实体  
     * @param entity  
     */  
    void update(T entity);   
      
    /**  
     * 查询所有实体  
     * @return  
     */  
    List<T> queryAll();  
  
    /**  
     * 查询所有实体,根据实体属性值为判断条件查询所有实体，  
     * @param entity  
     * @return  
     */  
    List<T> queryAllByEntity(T entity);  
      
    /**  
     * 根据主键获取一个实体  
     * @param primaryKey  
     * @return  
     */  
    T queryByPrimaryKey(PK primaryKey);  
}

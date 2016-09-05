package com.whitesky.home.dao;

import java.io.Serializable;
import java.util.List;

public abstract interface GenericMapper<T> extends Serializable {
    int insert(T record);
    List<T> selectAll();
    List<T> queryList(T t);
}

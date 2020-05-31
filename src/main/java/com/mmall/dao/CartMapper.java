package com.mmall.dao;

import com.mmall.pojo.Cart;
import org.codehaus.jackson.map.annotate.JsonSerialize;


public interface CartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);
}
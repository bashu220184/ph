package com.itheima.mapper;

import com.itheima.domain.Order;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {

    @Select("select * from orders where uid=#{id}")
    public List<Order> findOrderByUid(int id);


    @Select("select * from orders")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "ordertime",property = "ordertime"),
            @Result(column = "total",property = "total"),
            @Result(
                    property = "user",
                    column = "uid",
                    javaType = User.class,
                    one = @One(select = "com.itheima.mapper.UserMapper.findUserById")
            )
    })
    public List<Order> findAll();

    /*@Select("select *,o.id oid from user u,orders o where u.id=o.uid")
    @Results({
            @Result(column = "oid",property = "id"),
            @Result(column = "ordertime",property = "ordertime"),
            @Result(column = "total",property = "total"),
            @Result(column = "uid",property = "user.id"),
            @Result(column = "username",property = "user.username"),
            @Result(column = "password",property = "user.password"),
    })
    public List<Order> findAll();*/
}

package com.itheima.mapper;

import com.itheima.domain.Role;
import com.itheima.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Insert("insert into user values(#{id},#{username},#{password},#{birthday})")
    public void save(User user);

    @Update("delete from user where id=#{id}")
    public void delete(int id);

    @Update("update user set password=#{password},username=#{username} where id=#{id}")
    public void update(User user);

    @Select("select * from user where id=#{id}")
    public User findUserById(int id);

    @Select("select * from user")
    public List<User> findAll();

    @Select("select * from user")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(
                    property = "orderList",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.itheima.mapper.OrderMapper.findOrderByUid")
            )
    })
    public List<User> findUserAndOrder();

    @Select("select * from user")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(
                    property = "roleList",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "com.itheima.mapper.RoleMapper.findRoleByUid")
            )
    })
    public List<User> findUserAndRole();
}

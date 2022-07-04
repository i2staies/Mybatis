package com.itguigu.mybatis.mapper;

import com.itguigu.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    /*
    * MyBaties面向接口编程两个一直：
    * 1. 映射文件的namespace要和mapper接口的全类名保持一直
    * 2. 映射文件中的sql语句的id要和mapper接口中的方法名一致
    * */

    /**
     * 添加用户信息
     */
    int insertUser();

    /**
     * 修改用户信息
     */
    int updateUser();

    /**
     * 删除用户信息
     */
    int deleteUser();

    /**
     * 根据id查询用户信息
     */
    User getUserById();

    /**
     * 查询所有的用户信息
     */
    List<User> getAllUser();

}

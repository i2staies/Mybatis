package com.itguigu.mybatis.test;

import com.itguigu.mybatis.mapper.UserMapper;
import com.itguigu.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

//版本1
 /*优化一：
 * SqlServer默认不自动提交事务，若需要自动提交事务
 * 可以适用SqlSessionFactory.openSession(true)开启自动提交事务
 *
 * 优化二：
 * 日志文件，显示执行sql语句的过程
 * */
public class MyBatisTest1 {
    @Test
    public void testMyBatis() throws IOException {
        //1. 加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取sqlServerFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取sqlSessionFactor
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取sqlSession
        //优化自动提交事务
        //openSession()有一个boolean形参，默认为false，改为true时自动提交事务
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //代理模式，实例化接口
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //测试功能
        int i = mapper.insertUser();
        System.out.println("result:"+i);
        //提交事务
        sqlSession.commit();
    }

    @Test
    public void testCRUD() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //mapper.updateUser();//修改功能
        //mapper.deleteUser();//删除功能
        //User user = mapper.getUserById();//获取单个数据
        List<User> allUser = mapper.getAllUser();
        allUser.forEach(System.out::println);
    }
}

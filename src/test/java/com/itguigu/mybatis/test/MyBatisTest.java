package com.itguigu.mybatis.test;

import com.itguigu.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class MyBatisTest {
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
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //代理模式，实例化接口
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //测试功能
        int i = mapper.insertUser();
        System.out.println("result:"+i);
        //提交事务
        sqlSession.commit();
    }
}

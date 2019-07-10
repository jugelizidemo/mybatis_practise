package com.hxl;


import com.hxl.dao.UserInfoDao;
import com.hxl.domain.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;


/**
 * mybatis测试用例
 */
public class TestMybatis {

    public static void main(String[] args) throws Exception {

        /**
         * 读取配置文件时的一般方法(绝对路径与相对路径都不是好方式,绝对路径换个服务器可能就不存在,相对路径可能换个目录就不存在了):
         * 1.使用类加载器路径,只能读取类路径的配置文件
         * 2.使用servletContext对象的getRealPath()获取当前服务运行的路径
         */
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        /**
         * 创建sqlsessionfactory工厂
         * 构建者模式:mybatis使用了构建者模式:mybatis提供了sqlsessionfactory的构建者builder,只需要将构建信息传给builder,
         * builder就会创建一个sqlsessionfactory返回给用户,屏蔽了很多构建的繁琐操作
         */
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        /**
         *使用工厂生产sqlsession对象
         *工厂模式:解耦,降低了类与解耦之间的依赖关系
         */
        SqlSession sqlSession = factory.openSession();
        /**
         * 使用sqlsession创建dao接口的代理对象(对接口的增强,不改变代码的情况下,对功能增强:动态代理)
         * 代理模式
         */
        UserInfoDao userInfoDaoImpl = sqlSession.getMapper(UserInfoDao.class);
        //使用代理对象执行方法
        List<UserInfo> listUserInfo =  userInfoDaoImpl.findAll();
        for(UserInfo userInfo : listUserInfo){
            System.out.println(userInfo);
        }
        //释放资源
        sqlSession.close();
        in.close();
    }
}

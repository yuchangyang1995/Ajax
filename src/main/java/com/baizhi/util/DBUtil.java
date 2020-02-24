package com.baizhi.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class DBUtil {
	private static SqlSessionFactory factory=null;
	static{
		SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
			factory=builder.build(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	private final static ThreadLocal<SqlSession> tl=new ThreadLocal<SqlSession>(); 
	public  static  SqlSession openSession(){
		SqlSession session=tl.get();
		if(session==null){
			session=factory.openSession();
			tl.set(session);
		}
		return session;
	}

	public static Object getDaoImpl(Class daoClass){
		SqlSession session=openSession();
		Object dao=session.getMapper(daoClass);
		return dao;
	}
	public static void rollback(){
		SqlSession session=openSession();
		session.rollback();
		close();
	}
	public static void commit(){
		SqlSession session=openSession();
		session.commit();
		close();
	}
	public static void close(){
		SqlSession session=openSession();
		session.close();
		tl.remove();
	}
}
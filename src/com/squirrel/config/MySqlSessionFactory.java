package com.squirrel.config;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MySqlSessionFactory {
	private static SqlSessionFactory sqlSessionFactory = null; // 다른 메서드에서 사용하기 위한 변수로 선언
	static {
		String resource = "com/squirrel/config/Configuration.xml"; // Configuration 파일 연결
		InputStream inputStream=null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sqlSessionFactory =
		 new SqlSessionFactoryBuilder().build(inputStream); // 값만 할당
	}
	
	public static SqlSession getSession() {
		return sqlSessionFactory.openSession();
	}
}

package co.mass.mybatis.comm;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;



public class DataSource {
	//org.apache.ibatis.session. ��Ű���� �����ߴ�.
	private static SqlSessionFactory sqlSessionFactory;
	
	public static SqlSessionFactory getInstance() {
		//mybatis Ȩ������ ���� �ܾ�ͼ� ������̴�
		String resource = "mybatis-config.xml";
		
		try {
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return sqlSessionFactory;
	}

}

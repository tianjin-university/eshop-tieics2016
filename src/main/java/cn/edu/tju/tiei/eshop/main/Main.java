package cn.edu.tju.tiei.eshop.main;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.edu.tju.tiei.eshop.dao.RankMapper;
import cn.edu.tju.tiei.eshop.model.Rank;

public class Main {

	public static void main(String[] args) {
		// default classpath would be eshop/src/main/java or eshop/src/main/resources
		String resource = "MapperConfig.xml";
		try {
			Reader inputStream = Resources.getResourceAsReader(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			SqlSession sqlSession = sqlSessionFactory.openSession();

		    RankMapper mapper = sqlSession.getMapper(RankMapper.class);
		    List<Rank> allRecords = mapper.selectByExample(null);
		    
		    for (Rank record : allRecords) {
		    	System.out.println(record);
		    }
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

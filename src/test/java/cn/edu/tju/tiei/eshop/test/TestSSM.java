package cn.edu.tju.tiei.eshop.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import cn.edu.tju.tiei.eshop.model.Rank;
import cn.edu.tju.tiei.eshop.service.IRankService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestSSM {

	private static Logger logger = Logger.getLogger(TestSSM.class);
	
    @Autowired
    private IRankService service;
    
    @Test
    public void test() {
    	List<Rank> list = service.findAll();
    	logger.info(JSON.toJSONString(list));
    }  
}

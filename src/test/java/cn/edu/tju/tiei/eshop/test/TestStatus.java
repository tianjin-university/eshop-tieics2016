package cn.edu.tju.tiei.eshop.test;

import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

import cn.edu.tju.tiei.eshop.model.OrderStatus;
import cn.edu.tju.tiei.eshop.service.IOrderStatusService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class TestStatus {
	
	private static Logger logger = Logger.getLogger(TestSSM.class);
	
	@Autowired private IOrderStatusService service;

	@Test
	public void test(){
		// test select all
		List<OrderStatus> statuses = service.findAll();
		logger.info(JSON.toJSONString(statuses));
		
		// test insert
		OrderStatus status = new OrderStatus();
		status.setName("insert test");
		service.create(status);
		logger.info(JSON.toJSONString(service.findAll()));
		
		// test update
		statuses.get(0).setName("updated name");
		service.update(statuses.get(0));
		logger.info(JSON.toJSONString(service.findAll()));
		
		// test delete
		service.deleteById(service.findAll().get(service.findAll().size() - 1).getId());
		logger.info(JSON.toJSONString(service.findAll()));		
		
	}
	
}

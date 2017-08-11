package cn.edu.tju.tiei.eshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.tju.tiei.eshop.dao.OrderStatusMapper;
import cn.edu.tju.tiei.eshop.model.OrderStatus;
import cn.edu.tju.tiei.eshop.service.IOrderStatusService;

@Service("OrderStatusService")
public class OrderStatusServiceImpl implements IOrderStatusService {

	@Resource private OrderStatusMapper mapper;
	
	public OrderStatusMapper getStatusMapper(){
		return mapper;
	}
	
	@Autowired void setMapper(OrderStatusMapper mapper){
		this.mapper = mapper;
	}
	
	@Override
	public List<OrderStatus> findAll() {
		return mapper.selectByExample(null);
	}

	@Override
	public OrderStatus findById(int id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public void create(OrderStatus status) {
		mapper.insert(status);
	}

	@Override
	public boolean isExist(OrderStatus status) {
		return mapper.selectByPrimaryKey(status.getId()) != null;
	}

	@Override
	public void update(OrderStatus status) {
		mapper.updateByPrimaryKey(status);
	}

	@Override
	public void deleteById(int id) {
		mapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteAll() {
		mapper.deleteByExample(null);
	}

}

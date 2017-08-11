package cn.edu.tju.tiei.eshop.service;

import java.util.List;

import cn.edu.tju.tiei.eshop.model.OrderStatus;

public interface IOrderStatusService {

	List<OrderStatus> findAll();

	OrderStatus findById(int id);

	void create(OrderStatus status);

	boolean isExist(OrderStatus status);

	void update(OrderStatus status);

	void deleteById(int id);

	void deleteAll();
	
}

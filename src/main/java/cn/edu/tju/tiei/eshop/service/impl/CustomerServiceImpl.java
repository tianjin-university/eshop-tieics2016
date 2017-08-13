package cn.edu.tju.tiei.eshop.service.impl;

import java.util.List;

import cn.edu.tju.tiei.eshop.dao.CustomerMapper;
import cn.edu.tju.tiei.eshop.model.Customer;
import cn.edu.tju.tiei.eshop.service.ICustomerService;

public class CustomerServiceImpl implements ICustomerService{
	private CustomerMapper customerMapper;
	
	public Customer getInfoByUsername(String username) {
		return customerMapper.getInfoByUsername(username);
	}
	
	public void insert(Customer record) {
		customerMapper.insert(record);
	}
	
	public boolean isExist(Customer record) {
		return getInfoByUsername(record.getUsername())!=null;
	}
	
	public List<Customer> findAllUsers(){
		return customerMapper.findAllUsers();
	}
	
	public void updateUser(Customer record) {
		customerMapper.updateByUsername(record);
	}
	
	public void deleteUser(String username) {
		customerMapper.deleteByUsername(username);
	}
}

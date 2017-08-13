package cn.edu.tju.tiei.eshop.service.impl;

import java.util.List;

import cn.edu.tju.tiei.eshop.dao.CustomerMapper;
import cn.edu.tju.tiei.eshop.model.Customer;
import cn.edu.tju.tiei.eshop.service.ICustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("customerService")
public class CustomerServiceImpl implements ICustomerService{
	@Resource
	private CustomerMapper customerMapper;
	
	public Customer getInfoByUsername(String username) {
		return customerMapper.selectByPrimaryKey(username);
	}
	
	public void insert(Customer record) {
		customerMapper.insert(record);
	}
	
	public boolean isExist(Customer record) {
		return getInfoByUsername(record.getUsername())!=null;
	}
	
	public List<Customer> findAllUsers(){
		return customerMapper.selectByExample(null);
	}
	
	public void updateUser(Customer record) {
		customerMapper.updateByPrimaryKey(record);
	}
	
	public void deleteUser(String username) {
		customerMapper.deleteByPrimaryKey(username);
	}
}

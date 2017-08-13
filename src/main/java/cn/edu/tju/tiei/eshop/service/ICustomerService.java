package cn.edu.tju.tiei.eshop.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.edu.tju.tiei.eshop.model.Customer;

public interface ICustomerService {
	Customer getInfoByUsername(@Param("username") String username);
	void insert(Customer record);
	boolean isExist(Customer record);
	List<Customer> findAllUsers();
	void updateUser(Customer record);
	void deleteUser(String username);
}

package cn.edu.tju.tiei.eshop.service;

import java.util.List;

import cn.edu.tju.tiei.eshop.model.Customer;
import org.apache.ibatis.annotations.Param;

public interface ICustomerService {
	Customer getInfoByUsername(@Param("username") String username);
	void insert(Customer record);
	boolean isExist(Customer record);
	List<Customer> findAllUsers();
	void updateUser(Customer record);
	void deleteUser(String username);
}

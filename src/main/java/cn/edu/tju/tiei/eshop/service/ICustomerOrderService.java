package cn.edu.tju.tiei.eshop.service;

import cn.edu.tju.tiei.eshop.model.CustomerOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by tevenfeng on 17-8-1.
 */
public interface ICustomerOrderService {
    List<CustomerOrder> getOrderOfCustomer(@Param("userName") String username);
}

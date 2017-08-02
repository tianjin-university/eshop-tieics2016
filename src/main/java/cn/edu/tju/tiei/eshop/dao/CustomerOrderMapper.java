package cn.edu.tju.tiei.eshop.dao;

import cn.edu.tju.tiei.eshop.model.CustomerOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Feng Dingwen(2016229064) on 17-8-2.
 */
public interface CustomerOrderMapper {
    List<CustomerOrder> getOrderOfCustomer(@Param("userName") String username);
}

package cn.edu.tju.tiei.eshop.service.impl;

import cn.edu.tju.tiei.eshop.dao.CustomerOrderMapper;
import cn.edu.tju.tiei.eshop.model.CustomerOrder;
import cn.edu.tju.tiei.eshop.service.ICustomerOrderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tevenfeng on 17-8-2.
 */
@Service("customerOrderService")
public class CustomerOrderServiceImpl implements ICustomerOrderService{
    @Resource
    private CustomerOrderMapper customerOrderMapper;

    public List<CustomerOrder> getOrderOfCustomer(@Param("userName") String username){
        return this.customerOrderMapper.getOrderOfCustomer(username);
    }
}

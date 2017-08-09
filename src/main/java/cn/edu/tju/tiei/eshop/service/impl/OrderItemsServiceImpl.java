package cn.edu.tju.tiei.eshop.service.impl;

import cn.edu.tju.tiei.eshop.dao.OrderItemsMapper;
import cn.edu.tju.tiei.eshop.model.OrderItems;
import cn.edu.tju.tiei.eshop.service.IOrderItemsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("OrderItemsService")
public class OrderItemsServiceImpl implements IOrderItemsService {
    @Resource
    private OrderItemsMapper orderItemsMapper;

    public List<OrderItems> getItemsOfOrder(@Param("orderId") long orderid){
        return this.orderItemsMapper.getItemsOfOrder(orderid);
    }
}

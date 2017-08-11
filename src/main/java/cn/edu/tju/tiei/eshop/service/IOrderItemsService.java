package cn.edu.tju.tiei.eshop.service;

import cn.edu.tju.tiei.eshop.model.OrderItems;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IOrderItemsService {
    List<OrderItems> getItemsOfOrder(@Param("orderId") long orderid);
}


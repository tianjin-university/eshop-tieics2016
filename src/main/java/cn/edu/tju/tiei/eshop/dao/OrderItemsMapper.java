package cn.edu.tju.tiei.eshop.dao;

import cn.edu.tju.tiei.eshop.model.OrderItems;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderItemsMapper {
    List<OrderItems> getItemsOfOrder(@Param("orderId") long orderid);
}

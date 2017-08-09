package cn.edu.tju.tiei.eshop.service.impl;

import cn.edu.tju.tiei.eshop.dao.OrderMapper;
import cn.edu.tju.tiei.eshop.model.Order;
import cn.edu.tju.tiei.eshop.model.Rank;
import cn.edu.tju.tiei.eshop.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements IOrderService {

    @Resource
    private OrderMapper orderMapper;

    public OrderMapper getOrderMapper() {
        return orderMapper;
    }

    @Autowired
    public void setPersonMapper(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    public List<Order> findAll() {
        return orderMapper.selectByExample(null);
    }

    @Override
    public Order findById(int id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    @Override
    public void create(Order order) {
        orderMapper.insert(order);
    }

    @Override
    public boolean isExist(Order order) {
        return orderMapper.selectByPrimaryKey(order.getId()) != null;
    }

    @Override
    public void update(Order order) {
        orderMapper.updateByPrimaryKey(order);
    }

    @Override
    public void deleteById(int id) {
        orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteAll() {
        orderMapper.deleteByExample(null);
    }

}

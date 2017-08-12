package cn.edu.tju.tiei.eshop.service.impl;


import cn.edu.tju.tiei.eshop.dao.OrdersMapper;
import cn.edu.tju.tiei.eshop.model.Orders;
import cn.edu.tju.tiei.eshop.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("ordersService")
public class OrdersServiceImpl implements IOrdersService {

    @Resource
    private OrdersMapper ordersMapper;

    public OrdersMapper getOrdersMapper() {
        return ordersMapper;
    }

    @Autowired
    public void setPersonMapper(OrdersMapper ordersMapper) {
        this.ordersMapper = ordersMapper;
    }

    public List<Orders> findAll() {
        return ordersMapper.selectByExample(null);
    }

    @Override
    public Orders findById(int id) {
        return ordersMapper.selectByPrimaryKey(id);
    }

    @Override
    public void create(Orders orders) {
        ordersMapper.insert(orders);
    }

    @Override
    public boolean isExist(Orders orders) {
        return ordersMapper.selectByPrimaryKey(orders.getId()) != null;
    }

    @Override
    public void update(Orders orders) {
        ordersMapper.updateByPrimaryKey(orders);
    }

    @Override
    public void deleteById(int id) {
        ordersMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteAll() {
        ordersMapper.deleteByExample(null);
    }


}

package cn.edu.tju.tiei.eshop.service;

import cn.edu.tju.tiei.eshop.model.Order;
import cn.edu.tju.tiei.eshop.model.Rank;

import java.util.List;

public interface IOrderService {

    /**
        * Load all ranks
        * @return
    */
    List<Order> findAll();

    Order findById(int id);

    void create(Order order);

    boolean isExist(Order order);

    void update(Order order);

    void deleteById(int id);

    void deleteAll();

}

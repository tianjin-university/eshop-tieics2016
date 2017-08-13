package cn.edu.tju.tiei.eshop.service;

import cn.edu.tju.tiei.eshop.model.Orders;

import java.util.List;

public interface IOrdersService {

    /**
     * Load all ranks
     * @return
     */
    List<Orders> findAll();

    Orders findById(int id);

    void create(Orders orders);

    boolean isExist(Orders orders);

    void update(Orders orders);

    void deleteById(int id);

    void deleteAll();


}

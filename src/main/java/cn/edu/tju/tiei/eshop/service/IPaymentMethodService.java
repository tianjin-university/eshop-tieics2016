package cn.edu.tju.tiei.eshop.service;

import java.util.List;

import cn.edu.tju.tiei.eshop.model.PaymentMethod;

public interface IPaymentMethodService {

    /**
     * Load all paymentMethods
     * @return
     */
    List<PaymentMethod> findAll();

    PaymentMethod findById(Integer id);

    void create(PaymentMethod paymentMethod);

    boolean isExist(PaymentMethod paymentMethod);

    void update(PaymentMethod paymentMethod);

    void deleteById(Integer id);

    void deleteAll();
}

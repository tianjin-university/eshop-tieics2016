package cn.edu.tju.tiei.eshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.edu.tju.tiei.eshop.dao.PaymentMethodMapper;
import cn.edu.tju.tiei.eshop.model.PaymentMethod;
import cn.edu.tju.tiei.eshop.service.IPaymentMethodService;

@Service("paymentMethodService")
public class PaymentMethodServiceImpl implements IPaymentMethodService {

    @Resource
    private PaymentMethodMapper paymentMethodMapper;

    public PaymentMethodMapper getPaymentMethodMapper() {
        return paymentMethodMapper;
    }

    @Autowired
    public void setPersonMapper(PaymentMethodMapper paymentMethodMapper) {
        this.paymentMethodMapper = paymentMethodMapper;
    }

    public List<PaymentMethod> findAll() {
        return paymentMethodMapper.selectByExample(null);
    }

    @Override
    public PaymentMethod findById(Integer id) {
        return paymentMethodMapper.selectByPrimaryKey(id);
    }

    @Override
    public void create(PaymentMethod paymentMethod) {
        paymentMethodMapper.insert(paymentMethod);
    }

    @Override
    public boolean isExist(PaymentMethod paymentMethod) {
        return paymentMethodMapper.selectByPrimaryKey(paymentMethod.getId()) != null;
    }

    @Override
    public void update(PaymentMethod paymentMethod) {
        paymentMethodMapper.updateByPrimaryKey(paymentMethod);
    }

    @Override
    public void deleteById(Integer id) {
        paymentMethodMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteAll() {
        paymentMethodMapper.deleteByExample(null);
    }

}

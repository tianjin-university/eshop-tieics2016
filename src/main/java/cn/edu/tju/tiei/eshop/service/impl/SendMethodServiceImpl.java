package cn.edu.tju.tiei.eshop.service.impl;

import javax.annotation.Resource;

import cn.edu.tju.tiei.eshop.service.ISendMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import  cn.edu.tju.tiei.eshop.dao.SendMethodMapper;
import cn.edu.tju.tiei.eshop.model.SendMethod;
import org.springframework.stereotype.Service;

@Service("sendMethodService")
public class SendMethodServiceImpl implements ISendMethodService{
    @Resource
    private SendMethodMapper sendMethodMapper;

    public SendMethodMapper getSendMethodMapper() {
        return sendMethodMapper;
    }

    @Autowired
    public void setSendMethodMapper(SendMethodMapper sendMethodMapper) {
        this.sendMethodMapper = sendMethodMapper;
    }

    public List<SendMethod> findAll() {
        return sendMethodMapper.selectByExample(null);
    }

    @Override
    public SendMethod findById(int id) {
        return sendMethodMapper.selectByPrimaryKey(id);
    }

    @Override
    public void create(SendMethod sendMethod) {
        sendMethodMapper.insert(sendMethod);
    }

    @Override
    public boolean isExist(SendMethod sendMethod) {
        return sendMethodMapper.selectByPrimaryKey(sendMethod.getId()) != null;
    }

    @Override
    public void update(SendMethod sendMethod) {
        sendMethodMapper.updateByPrimaryKey(sendMethod);
    }

    @Override
    public void deleteById(int id) {
        sendMethodMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteAll() {
        sendMethodMapper.deleteByExample(null);
    }
}

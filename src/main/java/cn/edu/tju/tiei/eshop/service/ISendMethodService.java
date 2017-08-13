package cn.edu.tju.tiei.eshop.service;

import java.util.List;
import cn.edu.tju.tiei.eshop.model.SendMethod;

public interface ISendMethodService {
    /**
     * Load all methodss
     * @return
     */
    List<SendMethod> findAll();

    SendMethod findById(int id);

    void create(SendMethod sendMethod);

    boolean isExist(SendMethod sendMethod);

    void update(SendMethod sendMethod);

    void deleteById(int id);

    void deleteAll();
}

package cn.edu.tju.tiei.eshop.service;

import cn.edu.tju.tiei.eshop.model.Category;
import cn.edu.tju.tiei.eshop.model.Rank;

import java.util.List;

/**
 * Created by geekyzk on 2017/8/11.
 */
public interface ICategoryService {
    List<Category> findAll();

    Category findById(Integer id);

    void create(Category category);

    boolean isExist(Category category);

    void update(Category category);

    void deleteById(Integer id);

    void deleteAll();
}

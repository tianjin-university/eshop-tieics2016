package cn.edu.tju.tiei.eshop.service.impl;

import cn.edu.tju.tiei.eshop.dao.CategoryMapper;
import cn.edu.tju.tiei.eshop.model.Category;
import cn.edu.tju.tiei.eshop.service.ICategoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by geekyzk on 2017/8/11.
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Resource
    CategoryMapper categoryMapper;

    @Override
    public List<Category> findAll() {
        return categoryMapper.selectByExample(null);
    }

    @Override
    public Category findById(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    @Override
    public void create(Category category) {
        categoryMapper.insert(category);
    }

    @Override
    public boolean isExist(Category category) {

        return categoryMapper.selectByPrimaryKey(category.getId()) !=null;
    }

    @Override
    public void update(Category category) {
        categoryMapper.updateByPrimaryKey(category);
    }

    @Override
    public void deleteById(Integer id) {
        categoryMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteAll() {
        categoryMapper.deleteByExample(null);
    }
}

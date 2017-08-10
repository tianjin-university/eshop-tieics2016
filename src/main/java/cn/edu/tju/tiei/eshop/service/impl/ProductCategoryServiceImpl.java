package cn.edu.tju.tiei.eshop.service.impl;

import cn.edu.tju.tiei.eshop.dao.ProductCategoryMapper;
import cn.edu.tju.tiei.eshop.model.ProductCategory;
import cn.edu.tju.tiei.eshop.service.IProductCategoryService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("productCategoryService")
public class ProductCategoryServiceImpl implements IProductCategoryService{

    @Resource
    private ProductCategoryMapper productCategoryMapper;

    public List<ProductCategory> getProductCategory(@Param("min_market_price") double min_market_price,@Param("max_market_price") double max_market_price, @Param("pub_date")String pub_date){
        return productCategoryMapper.getProductCategory(min_market_price,max_market_price,pub_date);
    }

}

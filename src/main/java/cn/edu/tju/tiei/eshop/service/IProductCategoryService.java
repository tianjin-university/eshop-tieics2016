package cn.edu.tju.tiei.eshop.service;

import cn.edu.tju.tiei.eshop.model.ProductCategory;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**Created by Zhangjie(2016229085) 2017-08-09**/

public interface IProductCategoryService {

    List<ProductCategory> getProductCategory(@Param("min_market_price") double min_market_price,@Param("max_market_price") double max_market_price, @Param("pub_date")String pub_date);
}

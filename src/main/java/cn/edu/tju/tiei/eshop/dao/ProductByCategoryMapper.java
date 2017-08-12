package cn.edu.tju.tiei.eshop.dao;

import cn.edu.tju.tiei.eshop.model.ProductCategory;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author Li Ting (2016229068)
 * date : 2017-08-11
 * 15:20
 *
 */

public interface ProductByCategoryMapper {
	 List<ProductCategory> getProductByCategory(@Param("category_name") String category_name);

}

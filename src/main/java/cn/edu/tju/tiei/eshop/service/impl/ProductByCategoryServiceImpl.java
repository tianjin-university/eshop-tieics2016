package cn.edu.tju.tiei.eshop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import cn.edu.tju.tiei.eshop.dao.ProductByCategoryMapper;
import cn.edu.tju.tiei.eshop.model.ProductCategory;
import cn.edu.tju.tiei.eshop.service.IProductByCategoryService;

/**
 * 
 * @author Li Ting
 *time : 2017-08-11
 *15:40
 */

@Service("productByCategoryService")
public class ProductByCategoryServiceImpl implements IProductByCategoryService {
	@Resource
    private ProductByCategoryMapper productByCategoryMapper;
	
	public List<ProductCategory> getProductByCategory(@Param("category_name") String category_name){
		return productByCategoryMapper.getProductByCategory(category_name);
	}
}

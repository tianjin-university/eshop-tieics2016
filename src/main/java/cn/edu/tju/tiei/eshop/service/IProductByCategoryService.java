package cn.edu.tju.tiei.eshop.service;

import cn.edu.tju.tiei.eshop.model.ProductCategory;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 
 * @author Li Ting(2016229068)
 *time: 2016-08-11
 *15:40
 */

public interface IProductByCategoryService {
	List<ProductCategory> getProductByCategory(@Param("category_name")String category_name);

}

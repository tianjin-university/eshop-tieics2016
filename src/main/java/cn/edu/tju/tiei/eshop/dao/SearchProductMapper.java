package cn.edu.tju.tiei.eshop.dao;

import cn.edu.tju.tiei.eshop.model.SearchProduct;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SearchProductMapper {
	List<SearchProduct> searchByKeywords(@Param("productName") String productName, @Param("summary") String summary, @Param("detail") String detail);
}
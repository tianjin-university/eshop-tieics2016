package cn.edu.tju.tiei.eshop.service;

import cn.edu.tju.tiei.eshop.model.SearchProduct;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ISearchProductService {

    List<SearchProduct> searchByKeywords(@Param("product") String productName, @Param("summary") String summary, @Param("detail") String detail);
}

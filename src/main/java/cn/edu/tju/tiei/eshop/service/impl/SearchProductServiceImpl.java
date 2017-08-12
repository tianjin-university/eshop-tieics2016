package cn.edu.tju.tiei.eshop.service.impl;

import cn.edu.tju.tiei.eshop.dao.SearchProductMapper;
import cn.edu.tju.tiei.eshop.model.SearchProduct;
import cn.edu.tju.tiei.eshop.service.ISearchProductService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("searchProductService")
public class SearchProductServiceImpl implements ISearchProductService{

    @Resource
    private SearchProductMapper searchProductMapper;

    public List<SearchProduct> searchByKeywords(@Param("productName") String productName, @Param("summary") String summary, @Param("detail") String detail){
    	return searchProductMapper.searchByKeywords(productName, summary, detail);
    }

}
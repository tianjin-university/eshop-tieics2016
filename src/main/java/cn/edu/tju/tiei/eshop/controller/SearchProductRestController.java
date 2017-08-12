package cn.edu.tju.tiei.eshop.controller;


import cn.edu.tju.tiei.eshop.model.SearchProduct;
import cn.edu.tju.tiei.eshop.service.ISearchProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SearchProductRestController {

    @Autowired
    private ISearchProductService searchProductService;

    
    /**
     * Retrieve a list of products
     * @param productName, summary, detail
     * @return
     */
    @RequestMapping(value = "/searchProduct/{productName}/{summary}/{detail}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SearchProduct>> get(@PathVariable("productName") String productName, @PathVariable("summary") String summary, @PathVariable("detail") String detail) {
    	List<SearchProduct> searchProductList = searchProductService.searchByKeywords(productName, summary, detail);
        if (searchProductList.isEmpty()) {
            return new ResponseEntity<List<SearchProduct>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<SearchProduct>>(searchProductList, HttpStatus.OK);
    }
}
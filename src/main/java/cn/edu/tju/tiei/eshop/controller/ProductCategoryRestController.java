package cn.edu.tju.tiei.eshop.controller;


import cn.edu.tju.tiei.eshop.model.ProductCategory;
import cn.edu.tju.tiei.eshop.service.IProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@RestController
public class ProductCategoryRestController {

    @Autowired
    private IProductCategoryService productCategoryService;

    @RequestMapping(value = "/productCategory/{min_market_price}/{max_market_price}/{year}/{month}/{day}/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ProductCategory>> get(@PathVariable("min_market_price") double min_market_price,@PathVariable("max_market_price") double max_market_price, @PathVariable("year") String year, @PathVariable("month") String month, @PathVariable("day") String day) {
        String pub_date = year + "-" + month + "-" + day;
       // System.out.println(pub_date);

        List<ProductCategory> productCategoryList = productCategoryService.getProductCategory(min_market_price,max_market_price, pub_date);
        if (productCategoryList.isEmpty()) {
            return new ResponseEntity<List<ProductCategory>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<ProductCategory>>(productCategoryList, HttpStatus.OK);
    }
}
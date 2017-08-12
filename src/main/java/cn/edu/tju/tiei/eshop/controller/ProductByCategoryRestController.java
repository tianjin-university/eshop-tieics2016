package cn.edu.tju.tiei.eshop.controller;

import cn.edu.tju.tiei.eshop.model.ProductCategory;
import cn.edu.tju.tiei.eshop.service.IProductByCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 
 * @author Li Ting(2016229068)
 * Time: 2017-08-11 17:50
 *
 */
@RestController
public class ProductByCategoryRestController {
	@Autowired
    private IProductByCategoryService productByCategory;
	
	 @RequestMapping(value = "/productByCategory/{category_name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<List<ProductCategory>> get(@PathVariable("category_name") String category_name){
		 
		 List<ProductCategory> productByCategoryList = productByCategory.getProductByCategory(category_name);
		 
		 if (productByCategoryList.isEmpty()) {
	            return new ResponseEntity<List<ProductCategory>>(HttpStatus.NOT_FOUND);
	     }
		 return new ResponseEntity<List<ProductCategory>>(productByCategoryList, HttpStatus.OK);
	 }
}

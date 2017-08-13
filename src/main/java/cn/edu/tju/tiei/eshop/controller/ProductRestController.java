package cn.edu.tju.tiei.eshop.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import cn.edu.tju.tiei.eshop.model.Product;
import cn.edu.tju.tiei.eshop.service.IProductService;

@RestController
public class ProductRestController {

	@Autowired
	private IProductService productService;
	
	/**
	 * Retrieve all products
	 * @return
	 */
    @RequestMapping(value = "/product/", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> listAll(){
        List<Product> products = productService.findAll();
        if (products.isEmpty()) {
            return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }
    
    /**
     * Retrieve a single product
     * @param id
     * @return
     */
    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> get(@PathVariable("id") Integer id) {
    	Product product = productService.findById(id);
        if (product == null) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
    
    /**
     * Create a product
     * @param product
     * @param ucBuilder
     * @return
     */
    @RequestMapping(value = "/product/", method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody Product product, UriComponentsBuilder ucBuilder) {
        if (productService.isExist(product)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        productService.create(product);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/product/{id}").buildAndExpand(product.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    /**
     * Update a product
     * @param id
     * @param product
     * @return
     * @throws ParseException 
     */
    @RequestMapping(value = "/product/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Product> update(@PathVariable("id") Integer id, @RequestBody Product product) throws ParseException {
        Product oldProduct = productService.findById(id);
        if (oldProduct==null) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
        oldProduct.setCategoryId(product.getCategoryId());
        oldProduct.setImage(product.getImage());
        oldProduct.setName(product.getName());
        oldProduct.setMarketPrice(product.getMarketPrice());
        oldProduct.setIsOnSale(product.getIsOnSale());
        oldProduct.setDiscount(product.getDiscount());
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    	
        
        oldProduct.setPubDate(product.getPubDate());
        oldProduct.setStockCount(product.getStockCount());
        oldProduct.setSaleCount(product.getSaleCount());
        oldProduct.setSummary(product.getSummary());
        oldProduct.setDetail(product.getDetail());
        productService.update(oldProduct);
        return new ResponseEntity<Product>(oldProduct, HttpStatus.OK);
    }
    
    /**
     * Delete a product
     * @param id
     * @return
     */
    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Product> delete(@PathVariable("id") Integer id) {
        Product product = productService.findById(id);
        if (product == null) {
             return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
        productService.deleteById(id);
        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
    }
    
    /**
     * Delete all products
     * @return
     */
    @RequestMapping(value = "/product/", method = RequestMethod.DELETE)
    public ResponseEntity<Product> deleteAll() {
        productService.deleteAll();
        return new ResponseEntity<Product>(HttpStatus.NO_CONTENT);
    }

}

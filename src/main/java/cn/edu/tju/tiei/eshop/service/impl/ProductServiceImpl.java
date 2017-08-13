package cn.edu.tju.tiei.eshop.service.impl;

import cn.edu.tju.tiei.eshop.dao.ProductMapper;

import cn.edu.tju.tiei.eshop.model.Product;
import cn.edu.tju.tiei.eshop.service.IProductService;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("productService")
public class ProductServiceImpl implements IProductService {

		@Resource
	    private ProductMapper productMapper;

	    public ProductMapper getProductMapper() {
	        return productMapper;
	    }

	    @Autowired
	    public void setProductMapper(ProductMapper productMapper) {
	        this.productMapper = productMapper;
	    }

	    public List<Product> findAll() {
	        return productMapper.selectByExample(null);
	    }

	 
	    public Product findById(Integer id) {
	        return productMapper.selectByPrimaryKey(id);
	    }

	    @Override
	    public void create(Product product) {
	    	productMapper.insert(product);
	    }

	    @Override
	    public boolean isExist(Product product) {
	        return productMapper.selectByPrimaryKey(product.getId()) != null;
	    }

	    @Override
	    public void update(Product order) {
	    	productMapper.updateByPrimaryKey(order);
	    }

	    @Override
	    public void deleteById(Integer id) {
	    	productMapper.deleteByPrimaryKey(id);
	    }

	    @Override
	    public void deleteAll() {
	    	productMapper.deleteByExample(null);
	    }

}

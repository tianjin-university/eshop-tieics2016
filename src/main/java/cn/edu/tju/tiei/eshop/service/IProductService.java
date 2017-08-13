package cn.edu.tju.tiei.eshop.service;

import java.util.List;

import cn.edu.tju.tiei.eshop.model.Product;

public interface IProductService {
	 /**
     * Load all ranks
     * @return
     */
    List<Product> findAll();

	Product findById(Integer id);

	void create(Product product);

	boolean isExist(Product product);

	void update(Product product);

	void deleteById(Integer id);

	void deleteAll();

}

package cn.edu.tju.tiei.eshop.service;

import java.util.List;
import cn.edu.tju.tiei.eshop.model.Item;

public interface IItemService {
	
    List<Item> findAll();

	Item findById(int id);

	void create(Item item);

	boolean isExist(Item item);

	void update(Item item);

	void deleteById(int id);

	void deleteAll();
}

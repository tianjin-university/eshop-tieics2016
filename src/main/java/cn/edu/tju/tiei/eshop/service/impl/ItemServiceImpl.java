package cn.edu.tju.tiei.eshop.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.edu.tju.tiei.eshop.dao.ItemMapper;
import cn.edu.tju.tiei.eshop.model.Item;
import cn.edu.tju.tiei.eshop.service.IItemService;

@Service("itemService")
public class ItemServiceImpl implements IItemService{

	@Resource private ItemMapper mapper;
	
	public ItemMapper getItemMapper(){
		return mapper;
	}
	
	@Autowired void setMapper(ItemMapper mapper){
		this.mapper = mapper;
	}
	
	@Override
	public List<Item> findAll() {
		return mapper.selectByExample(null);
	}

	@Override
	public Item findById(int id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public void create(Item item) {
		mapper.insert(item);
	}

	@Override
	public boolean isExist(Item item) {
		return mapper.selectByPrimaryKey(item.getId()) != null;
	}

	@Override
	public void update(Item item) {
		mapper.updateByPrimaryKey(item);
	}

	@Override
	public void deleteById(int id) {
		mapper.deleteByPrimaryKey(id);
	}

	@Override
	public void deleteAll() {
		mapper.deleteByExample(null);
	}
}

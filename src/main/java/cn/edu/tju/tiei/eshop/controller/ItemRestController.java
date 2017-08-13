package cn.edu.tju.tiei.eshop.controller;

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

import cn.edu.tju.tiei.eshop.model.Item;
import cn.edu.tju.tiei.eshop.service.IItemService;

@RestController
public class ItemRestController {
	@Autowired
	private IItemService itemService;

	@RequestMapping(value = "/item/", method = RequestMethod.GET)
	public ResponseEntity<List<Item>> get() {
		List<Item> item = itemService.findAll();
		if (item.isEmpty()) {
			return new ResponseEntity<List<Item>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Item>>(item, HttpStatus.OK);
	}

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Item> get(@PathVariable("id") int id) {
    	Item item = itemService.findById(id);
        if (item == null) {
            return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Item>(item, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/item/", method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody Item item, UriComponentsBuilder ucBuilder) {
        if (itemService.isExist(item)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        itemService.create(item);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/item/{id}").buildAndExpand(item.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/item/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Item> update(@PathVariable("id") byte id, @RequestBody Item item) {
        Item oldItem = itemService.findById(id);
        if (oldItem==null) {
            return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
        }
        oldItem.setOrderId(item.getOrderId());
        oldItem.setProductId(item.getProductId());
        oldItem.setCount(item.getCount());
        oldItem.setPrice(item.getPrice());
        itemService.update(oldItem);
        return new ResponseEntity<Item>(oldItem, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/item/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Item> delete(@PathVariable("id") byte id) {
        Item item = itemService.findById(id);
        if (item == null) {
             return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
        }
        itemService.deleteById(id);
        return new ResponseEntity<Item>(HttpStatus.NO_CONTENT);
    }
    
    @RequestMapping(value = "/item/", method = RequestMethod.DELETE)
    public ResponseEntity<Item> deleteAll() {
        itemService.deleteAll();
        return new ResponseEntity<Item>(HttpStatus.NO_CONTENT);
    }
}

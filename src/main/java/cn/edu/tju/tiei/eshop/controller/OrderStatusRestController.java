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

import cn.edu.tju.tiei.eshop.model.OrderStatus;
import cn.edu.tju.tiei.eshop.service.IOrderStatusService;

@RestController
public class OrderStatusRestController {

	@Autowired
	private IOrderStatusService statusService;

	@RequestMapping("/status/")
	public ResponseEntity<List<OrderStatus>> getStatus() {
		List<OrderStatus> stauts = statusService.findAll();
		if (stauts.isEmpty()) {
			return new ResponseEntity<List<OrderStatus>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<OrderStatus>>(stauts, HttpStatus.OK);
	}

    @RequestMapping(value = "/status/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrderStatus> get(@PathVariable("id") byte id) {
    	OrderStatus status = statusService.findById(id);
        if (status == null) {
            return new ResponseEntity<OrderStatus>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<OrderStatus>(status, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/status/", method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody OrderStatus status, UriComponentsBuilder ucBuilder) {
        if (statusService.isExist(status)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        statusService.create(status);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/status/{id}").buildAndExpand(status.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/status/{id}", method = RequestMethod.PUT)
    public ResponseEntity<OrderStatus> update(@PathVariable("id") byte id, @RequestBody OrderStatus status) {
        OrderStatus oldOrderStatus = statusService.findById(id);
        if (oldOrderStatus==null) {
            return new ResponseEntity<OrderStatus>(HttpStatus.NOT_FOUND);
        }
        oldOrderStatus.setName(status.getName());
        statusService.update(oldOrderStatus);
        return new ResponseEntity<OrderStatus>(oldOrderStatus, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/status/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<OrderStatus> delete(@PathVariable("id") byte id) {
        OrderStatus status = statusService.findById(id);
        if (status == null) {
             return new ResponseEntity<OrderStatus>(HttpStatus.NOT_FOUND);
        }
        statusService.deleteById(id);
        return new ResponseEntity<OrderStatus>(HttpStatus.NO_CONTENT);
    }
    
    @RequestMapping(value = "/status/", method = RequestMethod.DELETE)
    public ResponseEntity<OrderStatus> deleteAll() {
        statusService.deleteAll();
        return new ResponseEntity<OrderStatus>(HttpStatus.NO_CONTENT);
    }
	
}

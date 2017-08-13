package cn.edu.tju.tiei.eshop.controller;


import cn.edu.tju.tiei.eshop.model.Orders;
import cn.edu.tju.tiei.eshop.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class OrdersRestController {

    @Autowired
    private IOrdersService ordersService;

    /**
     * Retrieve all orders
     * @return
     */
    @RequestMapping(value = "/order/", method = RequestMethod.GET)
    public ResponseEntity<List<Orders>> listAll(){
        List<Orders> orderss = ordersService.findAll();
        if (orderss.isEmpty()) {
            return new ResponseEntity<List<Orders>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Orders>>(orderss, HttpStatus.OK);
    }

    /**
     * Retrieve a single orders
     * @param id
     * @return
     */
    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Orders> get(@PathVariable("id") int id) {
        Orders orders = ordersService.findById(id);
        if (orders == null) {
            return new ResponseEntity<Orders>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Orders>(orders, HttpStatus.OK);
    }

    /**
     * Create a orders
     * @param orders
     * @param ucBuilder
     * @return
     */
    @RequestMapping(value = "/order/", method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody Orders orders, UriComponentsBuilder ucBuilder) {
        if (ordersService.isExist(orders)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        ordersService.create(orders);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/orders/{id}").buildAndExpand(orders.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    /**
     * Update a order
     * @param id
     * @param order
     * @return
     */
    @RequestMapping(value = "/order/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Orders> update(@PathVariable("id") int id, @RequestBody Orders orders) {
        Orders oldOrders = ordersService.findById(id);
        if (oldOrders==null) {
            return new ResponseEntity<Orders>(HttpStatus.NOT_FOUND);
        }
        oldOrders.setCustomerId(orders.getCustomerId());
        oldOrders.setStatusId(orders.getStatusId());
        oldOrders.setPrice(orders.getPrice());
        oldOrders.setPaymentMethodId(orders.getPaymentMethodId());
        oldOrders.setSendMethodId(orders.getSendMethodId());
        oldOrders.setPlaceTime(orders.getPlaceTime());
        oldOrders.setSendTime(orders.getSendTime());
        oldOrders.setInvoiceTitle(orders.getInvoiceTitle());
        oldOrders.setInvoiceItem(orders.getInvoiceItem());
        ordersService.update(oldOrders);
        return new ResponseEntity<Orders>(oldOrders, HttpStatus.OK);
    }

    /**
     * Delete a order
     * @param id
     * @return
     */
    @RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Orders> delete(@PathVariable("id") int id) {
        Orders orders = ordersService.findById(id);
        if (orders == null) {
            return new ResponseEntity<Orders>(HttpStatus.NOT_FOUND);
        }
        ordersService.deleteById(id);
        return new ResponseEntity<Orders>(HttpStatus.NO_CONTENT);
    }

    /**
     * Delete all ranks
     * @return
     */
    @RequestMapping(value = "/order/", method = RequestMethod.DELETE)
    public ResponseEntity<Orders> deleteAll() {
        ordersService.deleteAll();
        return new ResponseEntity<Orders>(HttpStatus.NO_CONTENT);
    }


}

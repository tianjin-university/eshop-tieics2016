package cn.edu.tju.tiei.eshop.controller;

import cn.edu.tju.tiei.eshop.model.Order;
import cn.edu.tju.tiei.eshop.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class OrderRestController {

    @Autowired
    private IOrderService orderService;

    /**
     * Retrieve all orders
     * @return
     */
    @RequestMapping(value = "/order/", method = RequestMethod.GET)
    public ResponseEntity<List<Order>> listAll(){
        List<Order> orders = orderService.findAll();
        if (orders.isEmpty()) {
            return new ResponseEntity<List<Order>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Order>>(orders, HttpStatus.OK);
    }

    /**
     * Retrieve a single order
     * @param id
     * @return
     */
    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> get(@PathVariable("id") int id) {
        Order order = orderService.findById(id);
        if (order == null) {
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Order>(order, HttpStatus.OK);
    }

    /**
     * Create a order
     * @param order
     * @param ucBuilder
     * @return
     */
    @RequestMapping(value = "/order/", method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody Order order, UriComponentsBuilder ucBuilder) {
        if (orderService.isExist(order)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        orderService.create(order);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/order/{id}").buildAndExpand(order.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    /**
     * Update a order
     * @param id
     * @param order
     * @return
     */
    @RequestMapping(value = "/order/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Order> update(@PathVariable("id") int id, @RequestBody Order order) {
        Order oldOrder = orderService.findById(id);
        if (oldOrder==null) {
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        }
        oldOrder.setCustomerId(order.getCustomerId());
        oldOrder.setStatusId(order.getStatusId());
        oldOrder.setPrice(order.getPrice());
        oldOrder.setPaymentMethodId(order.getPaymentMethodId());
        oldOrder.setSendMethodId(order.getSendMethodId());
        oldOrder.setPlaceTime(order.getPlaceTime());
        oldOrder.setSendTime(order.getSendTime());
        oldOrder.setInvoiceTitle(order.getInvoiceTitle());
        oldOrder.setInvoiceItem(order.getInvoiceItem());
        orderService.update(oldOrder);
        return new ResponseEntity<Order>(oldOrder, HttpStatus.OK);
    }

    /**
     * Delete a order
     * @param id
     * @return
     */
    @RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Order> delete(@PathVariable("id") int id) {
        Order order = orderService.findById(id);
        if (order == null) {
            return new ResponseEntity<Order>(HttpStatus.NOT_FOUND);
        }
        orderService.deleteById(id);
        return new ResponseEntity<Order>(HttpStatus.NO_CONTENT);
    }

    /**
     * Delete all ranks
     * @return
     */
    @RequestMapping(value = "/order/", method = RequestMethod.DELETE)
    public ResponseEntity<Order> deleteAll() {
        orderService.deleteAll();
        return new ResponseEntity<Order>(HttpStatus.NO_CONTENT);
    }

}

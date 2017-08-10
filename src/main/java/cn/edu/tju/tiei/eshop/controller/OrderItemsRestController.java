package cn.edu.tju.tiei.eshop.controller;

import cn.edu.tju.tiei.eshop.model.OrderItems;
import cn.edu.tju.tiei.eshop.service.IOrderItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderItemsRestController {
    @Autowired
    private IOrderItemsService orderItemsService;

    /**
     * Retrieve all orders of a single customer
     * @param orderid
     * @return
     */
    @RequestMapping(value = "/orderItems/{orderId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OrderItems>> get(@PathVariable("orderId") long orderid) {
        List<OrderItems> orderItemsList = orderItemsService.getItemsOfOrder(orderid);
        if (orderItemsList.isEmpty()) {
            return new ResponseEntity<List<OrderItems>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<OrderItems>>(orderItemsList, HttpStatus.OK);
    }
}

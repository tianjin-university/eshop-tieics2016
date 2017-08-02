package cn.edu.tju.tiei.eshop.controller;

import java.util.List;

import cn.edu.tju.tiei.eshop.model.Customer;
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

import cn.edu.tju.tiei.eshop.model.CustomerOrder;
import cn.edu.tju.tiei.eshop.service.ICustomerOrderService;

/**
 * Created by tevenfeng on 17-8-2.
 */
@RestController
public class CustomerOrderRestController {
    @Autowired
    private ICustomerOrderService customerOrderService;

    /**
     * Retrieve all orders of a single customer
     * @param userName
     * @return
     */
    @RequestMapping(value = "/customerOrder/{userName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CustomerOrder>> get(@PathVariable("userName") String userName) {
        List<CustomerOrder> customerOrderList = customerOrderService.getOrderOfCustomer(userName);
        if (customerOrderList.isEmpty()) {
            return new ResponseEntity<List<CustomerOrder>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<CustomerOrder>>(customerOrderList, HttpStatus.OK);
    }
}

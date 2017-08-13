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

import cn.edu.tju.tiei.eshop.model.PaymentMethod;
import cn.edu.tju.tiei.eshop.service.IPaymentMethodService;

@RestController
public class PaymentMethodRestController {

    @Autowired
    private IPaymentMethodService paymentMethodService;

    /**
     * Retrieve all paymentMethods
     * @return
     */
    @RequestMapping(value = "/paymentMethod/", method = RequestMethod.GET)
    public ResponseEntity<List<PaymentMethod>> listAll(){
        List<PaymentMethod> paymentMethods = paymentMethodService.findAll();
        if (paymentMethods.isEmpty()) {
            return new ResponseEntity<List<PaymentMethod>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<PaymentMethod>>(paymentMethods, HttpStatus.OK);
    }

    /**
     * Retrieve a single paymentMethod
     * @param id
     * @return
     */
    @RequestMapping(value = "/paymentMethod/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PaymentMethod> get(@PathVariable("id") Integer id) {
        PaymentMethod paymentMethod = paymentMethodService.findById(id);
        if (paymentMethod == null) {
            return new ResponseEntity<PaymentMethod>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PaymentMethod>(paymentMethod, HttpStatus.OK);
    }

    /**
     * Create a paymentMethod
     * @param paymentMethod
     * @param ucBuilder
     * @return
     */
    @RequestMapping(value = "/paymentMethod/", method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody PaymentMethod paymentMethod, UriComponentsBuilder ucBuilder) {
        if (paymentMethodService.isExist(paymentMethod)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        paymentMethodService.create(paymentMethod);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/paymentMethod/{id}").buildAndExpand(paymentMethod.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    /**
     * Update a paymentMethod
     * @param id
     * @param paymentMethod
     * @return
     */
    @RequestMapping(value = "/paymentMethod/{id}", method = RequestMethod.PUT)
    public ResponseEntity<PaymentMethod> update(@PathVariable("id") Integer id, @RequestBody PaymentMethod paymentMethod) {
        PaymentMethod oldPaymentMethod = paymentMethodService.findById(id);
        if (oldPaymentMethod==null) {
            return new ResponseEntity<PaymentMethod>(HttpStatus.NOT_FOUND);
        }
        oldPaymentMethod.setName(paymentMethod.getName());
        paymentMethodService.update(oldPaymentMethod);
        return new ResponseEntity<PaymentMethod>(oldPaymentMethod, HttpStatus.OK);
    }

    /**
     * Delete a paymentMethod
     * @param id
     * @return
     */
    @RequestMapping(value = "/paymentMethod/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<PaymentMethod> delete(@PathVariable("id") Integer id) {
        PaymentMethod paymentMethod = paymentMethodService.findById(id);
        if (paymentMethod == null) {
            return new ResponseEntity<PaymentMethod>(HttpStatus.NOT_FOUND);
        }
        paymentMethodService.deleteById(id);
        return new ResponseEntity<PaymentMethod>(HttpStatus.NO_CONTENT);
    }

    /**
     * Delete all paymentMethods
     * @return
     */
    @RequestMapping(value = "/paymentMethod/", method = RequestMethod.DELETE)
    public ResponseEntity<PaymentMethod> deleteAll() {
        paymentMethodService.deleteAll();
        return new ResponseEntity<PaymentMethod>(HttpStatus.NO_CONTENT);
    }

}

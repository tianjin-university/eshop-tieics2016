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

import cn.edu.tju.tiei.eshop.model.SendMethod;
import cn.edu.tju.tiei.eshop.service.ISendMethodService;

@RestController
public class SendMethodRestController {
    @Autowired
    private ISendMethodService sendMethodService;

    /**
     * Retrieve all sendMethods
     * @return
     */
    @RequestMapping(value = "/sendMethod/", method = RequestMethod.GET)
    public ResponseEntity<List<SendMethod>> listAll(){
        List<SendMethod> sendMethods = sendMethodService.findAll();
        if (sendMethods.isEmpty()) {
            return new ResponseEntity<List<SendMethod>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<SendMethod>>(sendMethods, HttpStatus.OK);
    }

    /**
     * Retrieve a single sendMethod
     * @param id
     * @return
     */
    @RequestMapping(value = "/sendMethod/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SendMethod> get(@PathVariable("id") int id) {
        SendMethod sendMethod = sendMethodService.findById(id);
        if (sendMethod == null) {
            return new ResponseEntity<SendMethod>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<SendMethod>(sendMethod, HttpStatus.OK);
    }

    /**
     * Create a sendMethod
     * @param sendMethod
     * @param ucBuilder
     * @return
     */
    @RequestMapping(value = "/sendMethod/", method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody SendMethod sendMethod, UriComponentsBuilder ucBuilder) {
        if (sendMethodService.isExist(sendMethod)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        sendMethodService.create(sendMethod);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/sendMethod/{id}").buildAndExpand(sendMethod.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    /**
     * Update a sendMethod
     * @param id
     * @param sendMethod
     * @return
     */
    @RequestMapping(value = "/sendMethod/{id}", method = RequestMethod.PUT)
    public ResponseEntity<SendMethod> update(@PathVariable("id") int id, @RequestBody SendMethod sendMethod) {
        SendMethod oldSendMethod = sendMethodService.findById(id);
        if (oldSendMethod==null) {
            return new ResponseEntity<SendMethod>(HttpStatus.NOT_FOUND);
        }
        oldSendMethod.setName(sendMethod.getName());
        sendMethodService.update(oldSendMethod);
        return new ResponseEntity<SendMethod>(oldSendMethod, HttpStatus.OK);
    }

    /**
     * Delete a sendMethod
     * @param id
     * @return
     */
    @RequestMapping(value = "/sendMethod/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<SendMethod> delete(@PathVariable("id") int id) {
        SendMethod sendMethod = sendMethodService.findById(id);
        if (sendMethod == null) {
            return new ResponseEntity<SendMethod>(HttpStatus.NOT_FOUND);
        }
        sendMethodService.deleteById(id);
        return new ResponseEntity<SendMethod>(HttpStatus.NO_CONTENT);
    }

    /**
     * Delete all sendMethods
     * @return
     */
    @RequestMapping(value = "/sendMethod/", method = RequestMethod.DELETE)
    public ResponseEntity<SendMethod> deleteAll() {
        sendMethodService.deleteAll();
        return new ResponseEntity<SendMethod>(HttpStatus.NO_CONTENT);
    }

}

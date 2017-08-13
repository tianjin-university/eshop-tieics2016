package cn.edu.tju.tiei.eshop.controller;


import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import cn.edu.tju.tiei.eshop.model.Customer;
import cn.edu.tju.tiei.eshop.service.ICustomerService;

public class CustomerController {
	private ICustomerService customerService;
	
	@RequestMapping(value = "/customer/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<Customer> get(@PathVariable("username") String username) {
		 System.out.println("Fetching User with username " + username);
		 Customer result = customerService.getInfoByUsername(username);
		 if (result == null) {
			 System.out.println("User with username " + username + " not found");
			 return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
			 }
		 return new ResponseEntity<Customer>(result, HttpStatus.OK);
		 }
	
	@RequestMapping(value = "/customer/", method = RequestMethod.GET)
	    public ResponseEntity<List<Customer>> listAllUsers() {
	        List<Customer> users = customerService.findAllUsers();
	        if(users.isEmpty()){
	            return new ResponseEntity<List<Customer>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
	        }
	        return new ResponseEntity<List<Customer>>(users, HttpStatus.OK);
	    }
	 
	    @RequestMapping(value = "/customer/", method = RequestMethod.POST)
	    public ResponseEntity<Void> create(@RequestBody Customer record, UriComponentsBuilder ucBuilder) {
	    	System.out.println("Creating User " + record.getUsername());
	    	
	        if (customerService.isExist(record)) {
	        	System.out.println("A User with name " + record.getUsername() + " already exist");
	            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
	        }
	        customerService.insert(record);
	        HttpHeaders headers = new HttpHeaders();
	        headers.setLocation(ucBuilder.path("/customer/{username}").buildAndExpand(record.getUsername()).toUri());
	        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	    }
	    
	    @RequestMapping(value = "/customer/{username}", method = RequestMethod.PUT)
	    public ResponseEntity<Customer> updateUser(@PathVariable("username") String username, @RequestBody Customer user) {
	        System.out.println("Updating User " + username);
	          
	        Customer currentUser = customerService.getInfoByUsername(username);
	          
	        if (currentUser==null) {
	            System.out.println("User with id " + username + " not found");
	            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	        }
	  
	        currentUser.setUsername(user.getUsername());
	        currentUser.setPassword(user.getPassword());
	        currentUser.setRealName(user.getRealName());
	        currentUser.setScore(user.getScore());
	        currentUser.setRankId(user.getRankId());
	        currentUser.setBirthday(user.getBirthday());
	        currentUser.setMobile(user.getMobile());
	        currentUser.setGender(user.getGender());
	        currentUser.setQuestion(user.getQuestion());
	        currentUser.setAnswer(user.getAnswer());
	        currentUser.setProvince(user.getProvince());
	        currentUser.setCity(user.getCity());
	        currentUser.setCounty(user.getCounty());
	        currentUser.setAddress(user.getAddress());
	        currentUser.setEmail(user.getEmail());
	        currentUser.setZipcode(user.getZipcode());
	          
	        customerService.updateUser(currentUser);
	        return new ResponseEntity<Customer>(currentUser, HttpStatus.OK);
	    }
	    
	    @RequestMapping(value = "/customer/{username}", method = RequestMethod.DELETE)
	    public ResponseEntity<Customer> deleteUser(@PathVariable("username") String username) {
	        System.out.println("Fetching & Deleting User with username " + username);
	  
	        Customer user = customerService.getInfoByUsername(username);
	        if (user == null) {
	            System.out.println("Unable to delete. User with username " + username + " not found");
	            return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
	        }	  
	        customerService.deleteUser(username);
	        return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
	    }	 
}

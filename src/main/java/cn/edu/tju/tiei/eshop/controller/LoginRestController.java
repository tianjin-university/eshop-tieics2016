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

import cn.edu.tju.tiei.eshop.model.Login;
import cn.edu.tju.tiei.eshop.service.LoginService;

@RestController
public class LoginRestController {

	@Autowired
	private LoginService loginService;
	
	/**
	 * Retrieve all login
	 * @return
	 */
    @RequestMapping(value = "/login/", method = RequestMethod.GET)
    public ResponseEntity<List<Login>> listAll(){
        List<Login> logins = loginService.findAll();
        if (logins.isEmpty()) {
            return new ResponseEntity<List<Login>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Login>>(logins, HttpStatus.OK);
    }
    
    /**
     * Retrieve a single login
     * @param id
     * @return
     */
    @RequestMapping(value = "/login/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Login> get(@PathVariable("id") Integer id) {
    	Login login = loginService.findById(id);
        if (login == null) {
            return new ResponseEntity<Login>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Login>(login, HttpStatus.OK);
    }
    
    /**
     * Create a login
     * @param login
     * @param ucBuilder
     * @return
     */
    @RequestMapping(value = "/login/", method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody Login login, UriComponentsBuilder ucBuilder) {
        if (loginService.isExist(login)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        loginService.create(login);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/login/{id}").buildAndExpand(login.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }
    
    /**
     * Update a login
     * @param id
     * @param login
     * @return
     */
    @RequestMapping(value = "/login/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Login> update(@PathVariable("id") Integer id, @RequestBody Login login) {
        Login oldLogin = loginService.findById(id);
        if (oldLogin==null) {
            return new ResponseEntity<Login>(HttpStatus.NOT_FOUND);
        }
        oldLogin.setUsername(login.getUsername());
        oldLogin.setIpAddr(login.getIpAddr());
        oldLogin.setLoginTime(login.getLoginTime());
        loginService.update(oldLogin);
        return new ResponseEntity<Login>(oldLogin, HttpStatus.OK);
    }
    
    /**
     * Delete a login
     * @param id
     * @return
     */
    @RequestMapping(value = "/login/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Login> delete(@PathVariable("id") Integer id) {
        Login login = loginService.findById(id);
        if (login == null) {
             return new ResponseEntity<Login>(HttpStatus.NOT_FOUND);
        }
        loginService.deleteById(id);
        return new ResponseEntity<Login>(HttpStatus.NO_CONTENT);
    }
    
    /**
     * Delete all login
     * @return
     */
    @RequestMapping(value = "/login/", method = RequestMethod.DELETE)
    public ResponseEntity<Login> deleteAll() {
        loginService.deleteAll();
        return new ResponseEntity<Login>(HttpStatus.NO_CONTENT);
    }

}

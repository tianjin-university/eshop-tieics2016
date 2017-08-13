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

import cn.edu.tju.tiei.eshop.model.UserRoles;
import cn.edu.tju.tiei.eshop.service.IUserRolesService;

@RestController
public class UserRolesRestController {

	@Autowired
    private IUserRolesService userrolesService;

	@Autowired
	public void setRankService(IUserRolesService userrolesService) {
		this.userrolesService = userrolesService;
	}
	/**
     * Retrieve all user_roles
     * @return
     */
	@RequestMapping(value = "/user_roles/", method = RequestMethod.GET)
    public ResponseEntity<List<UserRoles>> listAll(){
        List<UserRoles> userroles = userrolesService.findAll();
        if (userroles.isEmpty()) {
            return new ResponseEntity<List<UserRoles>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<UserRoles>>(userroles, HttpStatus.OK);
    }

	/**
     * Retrieve a single user_roles
     * @param id
     * @return
     */
    @RequestMapping(value = "/user_roles/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserRoles> get(@PathVariable("id") int id) {
    	UserRoles userroles = userrolesService.findById(id);
        if (userroles == null) {
            return new ResponseEntity<UserRoles>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<UserRoles>(userroles, HttpStatus.OK);
    }

    /**
     * Create a userroles
     * @param userroles
     * @param ucBuilder
     * @return
     */
    @RequestMapping(value = "/user_roles/", method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody UserRoles userroles, UriComponentsBuilder ucBuilder) {
        if (userrolesService.isExist(userroles)) {
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        userrolesService.create(userroles);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user_roles/{id}").buildAndExpand(userroles.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    /**
     * Update a userroles
     * @param id
     * @param userroles
     * @return
     */
    @RequestMapping(value = "/user_roles/{id}", method = RequestMethod.PUT)
    public ResponseEntity<UserRoles> update(@PathVariable("id") int id, @RequestBody UserRoles userroles) {
    	UserRoles oldUserRoles = userrolesService.findById(id);
        if (oldUserRoles==null) {
            return new ResponseEntity<UserRoles>(HttpStatus.NOT_FOUND);
        }
        oldUserRoles.setId(userroles.getId());
        oldUserRoles.setUsername(userroles.getUsername());
        oldUserRoles.setRolename(userroles.getRolename());
        userrolesService.update(oldUserRoles);
        return new ResponseEntity<UserRoles>(oldUserRoles, HttpStatus.OK);
    }

    /**
     * Delete a userroles
     * @param id
     * @return
     */
    @RequestMapping(value = "/user_roles/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<UserRoles> delete(@PathVariable("id") int id) {
    	UserRoles userroles = userrolesService.findById(id);
        if (userroles == null) {
            return new ResponseEntity<UserRoles>(HttpStatus.NOT_FOUND);
        }
        userrolesService.deleteById(id);
        return new ResponseEntity<UserRoles>(HttpStatus.NO_CONTENT);
    }

    /**
     * Delete all userroles
     * @return
     */
    @RequestMapping(value = "/user_roles/", method = RequestMethod.DELETE)
    public ResponseEntity<UserRoles> deleteAll() {
    	userrolesService.deleteAll();
        return new ResponseEntity<UserRoles>(HttpStatus.NO_CONTENT);
    }

}

package cn.edu.tju.tiei.eshop.controller;

import cn.edu.tju.tiei.eshop.model.Category;
import cn.edu.tju.tiei.eshop.model.Rank;
import cn.edu.tju.tiei.eshop.service.ICategoryService;
import cn.edu.tju.tiei.eshop.service.IRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
public class CategoryRestController {

	@Autowired
	private ICategoryService categoryService;
	
	/**
	 * Retrieve all categories
	 * @return
	 */
    @RequestMapping(value = "/category/", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> listAll(){
        List<Category> categories = categoryService.findAll();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
    
    /**
     * Retrieve a single category
     * @param id
     * @return
     */
    @RequestMapping(value = "/category/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> get(@PathVariable("id") Integer id) {
    	Category category = categoryService.findById(id);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
    
    /**
     * Create a category
     * @param category
     * @param ucBuilder
     * @return
     */
    @RequestMapping(value = "/category/", method = RequestMethod.POST)
    public ResponseEntity<Void> create(@RequestBody Category category, UriComponentsBuilder ucBuilder) {
        if (categoryService.isExist(category)) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        categoryService.create(category);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/category/{id}").buildAndExpand(category.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
    
    /**
     * Update a category
     * @param id
     * @param category
     * @return
     */
    @RequestMapping(value = "/category/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Category> update(@PathVariable("id") Integer id, @RequestBody Category category) {
        Category oldCategory = categoryService.findById(id);
        if (oldCategory==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        oldCategory.setName(category.getName());
        oldCategory.setDescription(category.getDescription());
        categoryService.update(oldCategory);
        return new ResponseEntity<>(oldCategory, HttpStatus.OK);
    }
    
    /**
     * Delete a category
     * @param id
     * @return
     */
    @RequestMapping(value = "/category/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Category> delete(@PathVariable("id") Integer id) {
        Category category = categoryService.findById(id);
        if (category == null) {
             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    /**
     * Delete all categories
     * @return
     */
    @RequestMapping(value = "/category/", method = RequestMethod.DELETE)
    public ResponseEntity<Category> deleteAll() {
        categoryService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

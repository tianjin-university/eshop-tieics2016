package cn.edu.tju.tiei.eshop.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.edu.tju.tiei.eshop.dao.CategoryMapper;
import cn.edu.tju.tiei.eshop.model.Category;

@RestController
public class CategoryRestController {
	
	@Resource
	private CategoryMapper cMapper;
	
	/**
	 * @author Liting(2016229068)
	 * Time: 2017-08-11 17:55
	 * （请不要改这个函数，谢谢）
	 * Retrieve all ranks
	 * @return
	 */
    @RequestMapping(value = "/category/", method = RequestMethod.GET)
    public ResponseEntity<List<Category>> listAll(){
        List<Category> ranks = cMapper.selectByExample(null);
        if (ranks.isEmpty()) {
            return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Category>>(ranks, HttpStatus.OK);
    }
}

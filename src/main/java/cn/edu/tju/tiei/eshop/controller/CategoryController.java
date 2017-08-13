package cn.edu.tju.tiei.eshop.controller;

import cn.edu.tju.tiei.eshop.model.Category;
import cn.edu.tju.tiei.eshop.model.Rank;
import cn.edu.tju.tiei.eshop.service.ICategoryService;
import cn.edu.tju.tiei.eshop.service.IRankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/categoryController")
public class CategoryController {


	private ICategoryService categoryService;

	@Autowired
	public CategoryController(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@RequestMapping("/showCategory")
    public String showRanks(Model model){
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "index";
    }
}

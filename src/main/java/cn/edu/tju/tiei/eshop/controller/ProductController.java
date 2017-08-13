package cn.edu.tju.tiei.eshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.tju.tiei.eshop.model.Product;
import cn.edu.tju.tiei.eshop.service.IProductService;

@Controller
@RequestMapping("/productController")

public class ProductController {
	
	private IProductService productService;
	
	public IProductService getProductService() {
		return productService;
	}
	
	@Autowired
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}
	
    @RequestMapping("/showProduct")
    public String showProducts(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("product", products);
        return "index";
    }	

}

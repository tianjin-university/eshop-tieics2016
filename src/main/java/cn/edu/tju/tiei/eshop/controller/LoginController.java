package cn.edu.tju.tiei.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.edu.tju.tiei.eshop.service.LoginService;

@Controller
@RequestMapping("/loginController")
public class LoginController {

	private LoginService loginService;

	public LoginService getPersonService() {
		return loginService;
	}

	@Autowired
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
   
    @RequestMapping("/login")
    public String index(Model model){
   
        return "login";
    }
 
}

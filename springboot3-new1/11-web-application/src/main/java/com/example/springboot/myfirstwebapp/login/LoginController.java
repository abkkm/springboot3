package com.example.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class LoginController {
	
	///login => com.example.springboot.myfirstwebapp.login.LoginController => login.jsp
	
	
	public LoginController() {
	}


	private AuthenticationService authenticationService;
	
	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	
	@RequestMapping(value="login",method = RequestMethod.GET)
	public String gotoLoginPage() {
		return "login";
	}
	
	
	//http://localhost:8080/login?name=AB
	//Model
	@RequestMapping(value="login",method = RequestMethod.POST)
	public String gotoLoginPage(@RequestParam String name,
			@RequestParam String password,  ModelMap model) {
		//model.put("name", name);
		//System.out.println("Request param is " + name); //NOT RECOMMENDED FOR PROD CODE
		//return "login";
		if(authenticationService.authenticate(name, password)) {
			
			model.put("name", name);
			//Authentication 
			//name - example
			//password - dummy
			
			return "welcome";
		}
		
		return "login";
	}
}
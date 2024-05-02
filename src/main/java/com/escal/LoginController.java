package com.escal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ModelAttribute;
//it is very important to define the controller using annotations
@Controller
public class LoginController {

	@RequestMapping("/welcome")
	public ModelAndView Validate(){
		//create two pages success and failure
		
		System.out.println("executing controller function");
		return new ModelAndView("welcome");
	
	}
	 @Value("${user}") private String VerifyUsername;
	 @Value("${password}") private String VerifyPassword;

	 @RequestMapping(value ="/validate", method = RequestMethod.POST)
	    public ModelAndView result(@RequestParam("username")String username , @RequestParam("password")String password){
		 
		  
			System.out.println("successfully posted to the function with the username"+username +password);
			System.out.println("successfully posted to the function with the username"+VerifyUsername +VerifyPassword+(VerifyUsername = username));

			System.out.println("failure page returned");
			if(username.toString() == VerifyUsername.toString())
			{
				 if(VerifyPassword.equals(password))
				 {
				return new  ModelAndView("success");
				 }
			}

			return new  ModelAndView("failure");
			
	    }
}

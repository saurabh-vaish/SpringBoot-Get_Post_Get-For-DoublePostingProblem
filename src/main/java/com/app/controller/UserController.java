package com.app.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.model.User;

/****
 * 
 * Double Posting Problem :- when a user submit a form then if he will refresh the page then again form will submit with same data 
 * 							To prevent with this problem GET-POST-GET pattern is used .
 * 							In this pattern instead of sending response from save method to user we redirect response to another get 
 * 							method . so if user is again refreshing then get request will come and form will not submit
 * 
 *  In this pattern --
 *  
 *		 		1. First user will get register page using get request  (G)
 * 				2. Submit form using post								(P)
 * 				3. Redirect it to another get request method 			(G)
 * 
 * 
 * 	  RedirectAttributes :-
 * 							When we redirect a request then model attribute will not go with that request , so to send these attributes
 * 							value to another redirected method we use RedirectAttributes (I) having method --  addFlashAttribute()
 * 
 * 
 ***/



@Controller
public class UserController {

	// enable logging for this controller
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping("/reg")
	public String getRegister(Model map)
	{
		// form backing object
		map.addAttribute("user",new User());
		
		return "register";
	}
	
	
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public String saveUser(@ModelAttribute User user,RedirectAttributes attributes)  // RedirectAttributes so that it will come in redirected method also
	{
		logger.info("user registred successfully "+user);
		
		// flash attribute to go with redirection
		attributes.addFlashAttribute("msg","user registred successfully");
		
		return "redirect:successfullRegister";
	
		// or 
		// return "redirect:reg";   // we can also redirect to same register page also
		
		
	}
	
	// another get method to send response to user 
	@RequestMapping("/successfullRegister")
	public String successRegister(Model map)
	{
		map.addAttribute("user",new User());
		return "register";
	}
	
	
}

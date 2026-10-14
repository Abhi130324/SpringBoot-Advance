package in.sp.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import in.sp.main.entities.User;
import in.sp.main.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MyController {

	@Autowired
	private UserService userService;

	@GetMapping("/regPage") // since it is sending get request
	public String openRegPage(Model model) {

		model.addAttribute("user", new User());// this user object will go to register page and then automatically store
												// the value
		return "register";
	}

	@PostMapping("/regForm")
	public String submitRegForm(@ModelAttribute("user") User user,Model model) {// fetch the above value and we take this to service
																	// impl
		boolean status = userService.registerUser(user);//now it will store all the value in db
		
		if(status) {
			model.addAttribute("successMSG", "User Registered Successfully");
		}else {
			model.addAttribute("errorMSG", "User Not Registered due to Some Error");
		}
		
		return "register";
	}
	
	@GetMapping("/loginPage")
	public String openLoginPage(Model model) {
		
		model.addAttribute("user", new User());
		return "login";
	}
	
	@PostMapping("/loginForm")
	public String submitLoginForm(@ModelAttribute("user") User user,Model model) {//this will store pass and email
		
	User validUser =	userService.loginUser(user.getEmail(), user.getPassword());//so to get the login part we will use model above
		if(validUser != null) {
			model.addAttribute("modelName", validUser.getName());
			return "profile";
		}else {
			model.addAttribute("errorMSG", "Email Id and Password didn't Match");
			return "login";
		}
	}
	
		@GetMapping("/logout")
		public String logoutUser(HttpServletRequest request) {
			
			HttpSession session = request.getSession(false);
			if(session != null) {
				session.invalidate();
			}
			return "login";
			
		}
		
	
		
		
	
	
	
}

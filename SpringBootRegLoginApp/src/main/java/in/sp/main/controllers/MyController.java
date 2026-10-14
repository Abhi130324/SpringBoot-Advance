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

	@Autowired//it will autowire only when you provide @Service in userserviceimpl
	private UserService userService;
	
	
	@GetMapping("/regPage")
	public String openRegPage(Model model) {
		
		model.addAttribute("user", new User());//his creates a fresh instance of your User class.
		return "register";//take user object with you through model
	}
	
	@PostMapping("/regForm")
	public String submitRegForm(@ModelAttribute("user")User user,Model model) {//bind the form data 
		
		boolean status = userService.registerUser(user);
		if(status) {
			model.addAttribute("successMsg", "User Registered Successfully");
		}else {
			model.addAttribute("errorMsg", "User Not Registered Due to some error");
		}
		return "register";
	}
	
	@GetMapping("/loginPage")//it will take user object in login page
	public String openLoginPage(Model model) {
		
		model.addAttribute("user", new User());//helps with a new empty set
		return "login";
		}
	
	@PostMapping("/loginForm")
	public String submitLoginForm(@ModelAttribute("user")User user,Model model) {//bind through modelattribute
		
		User validUser = userService.loginUser(user.getEmail(), user.getPassword());
		if(validUser != null) {
			model.addAttribute("modelName", validUser.getName());
			return "profile";
		}else {
			
			model.addAttribute("errorMsg", "Email Id and Password didn't Match");
			return "login";
		}
		
		
	}
	

	@GetMapping("/Logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);//getting the current session
		if(session != null) {
			session.invalidate();
		}
		
		return "redirect:/loginPage";
	}
	
	
}

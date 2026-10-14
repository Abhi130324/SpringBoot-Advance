package in.sp.main.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

	@GetMapping("/openProfile")
	public String openProfilePage(Model model) {//through model we can take tbe value anywhere
		
		String name = "ABhijeet Gaikwad";//currently we can doing this statiscally but we have to do dynamically.
		model.addAttribute("modelName", name);
		return "profile";
	}
	
	
	@GetMapping("/openConditional")//Conditional rendering
	public String openConditionalPage(Model model) {
		
		
		int num1 = 10;
		int num2 = 20;
		model.addAttribute("number1", num1);
		model.addAttribute("number2", num2);
		
		
		
		return "Conditional";
	}
	
	
	@GetMapping("/openLooping")
	public String openLoopingPage(Model model) {
		
		List<Integer> numbers = List.of(1,2,3,4,5);
		model.addAttribute("modelNumbers", numbers);
	
		return "Looping";
		
		
	}
	
	
}

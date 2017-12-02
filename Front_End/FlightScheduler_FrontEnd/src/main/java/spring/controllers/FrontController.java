package spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FrontController
{
	@GetMapping("/front")

	public String welcome(Model model)
	{
		//model.addAttribute("firstName", "Elizabeth");  //model is a map
		//model.addAttribute("name", "John Doe");
		return "frontMessage";
	}
}

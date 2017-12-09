package spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController
{
	@GetMapping("/welcome")
	public String welcome(Model model)
	{
		//code to get info from db
		//varIWant = db.query
		model.addAttribute("firstName", "Elizabeth");  //model is a map
		//model.addAttribute("name", "John Doe");
		return "welcomeMessage";
	}
}


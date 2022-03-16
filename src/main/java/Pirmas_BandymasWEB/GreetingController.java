package Pirmas_BandymasWEB;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;

import geometrija.Apskritimas;

@Controller
public class GreetingController {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		//Apskritimas apskritimas = new Apskritimas(7, 9, 11);
		
		ArrayList<Apskritimas> apskritimai = new ArrayList<Apskritimas>();
		
		for ( int i = 0; i < 20; i++ ) {
			
			apskritimai.add(new Apskritimas(-100, 100, -100, 100, 100));
			
		}
		
		model.addAttribute("apskritimai", apskritimai);
		
		return "greeting";

	}
}
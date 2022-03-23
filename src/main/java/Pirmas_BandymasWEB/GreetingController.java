package Pirmas_BandymasWEB;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;

import geometrija.Apskritimas;

@Controller
public class GreetingController {

	@RequestMapping("/greeting")
	public String greeting(
			@RequestParam(name="name", required=false, defaultValue="World") String name, 
			@RequestParam(name="sukurimas", required=false, defaultValue="World")String sukurk,
			@RequestParam(name="xkoor", required=false, defaultValue="0")Double x,
			@RequestParam(name="ykoor", required=false, defaultValue="0")Double y,
			@RequestParam(name="radius", required=false, defaultValue="0")Double radius,
			Model model)
	{
		model.addAttribute("name", name);
		ArrayList<Apskritimas> apskritimai = new ArrayList<Apskritimas>();
		
		/*for ( int i = 0; i < 20; i++ ) {
			
			apskritimai.add(new Apskritimas(-100, 100, -100, 100, 100));
			
		}*/
		
		if(sukurk != null) {
			
			apskritimai.add(new Apskritimas(x, y, radius));
			
		}
		
		model.addAttribute("apskritimai", apskritimai);
		
		return "greeting";

	}
}
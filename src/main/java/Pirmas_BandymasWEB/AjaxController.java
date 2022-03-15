package Pirmas_BandymasWEB;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import geometrija.Apskritimas;

@Controller
public class AjaxController {

	@GetMapping("/apskritimai")
	@ResponseBody
	public ArrayList<Apskritimas> apskritimai() {
		
		// Apskritimas apskritimas = new Apskritimas ( 5.0, 7.2, 4.1 );
		ArrayList<Apskritimas> apskritimai = new ArrayList<Apskritimas>();
		
		for ( int i = 0; i < 20; i++ ) {
			apskritimai.add(new Apskritimas(-100, 100, -100, 100, 100));
		}
		
		return apskritimai;
	}
	
}

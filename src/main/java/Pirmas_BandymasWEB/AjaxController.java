package Pirmas_BandymasWEB;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import geometrija.Apskritimas;
import geometrija.Zaidimas;

@Controller
public class AjaxController {


	@GetMapping("/apskritimai")
	@ResponseBody
	public ArrayList<Apskritimas> apskritimai() {
		
		Zaidimas zaidimas = new Zaidimas();
		
		zaidimas.apskritimuNuskaitymas();
		
		ArrayList<Apskritimas> apskritimai = zaidimas.pasiimtiApskritimus();
		
		return apskritimai;
	}
	
}
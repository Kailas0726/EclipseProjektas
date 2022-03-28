package Pirmas_BandymasWEB;

import java.io.IOException;
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
	public ArrayList<Apskritimas> apskritimai() throws IOException {
		
		Zaidimas zaidimas = new Zaidimas();
		
		zaidimas.apskritimuSukurimas();
		
		zaidimas.apskritimuIssaugojimas();
		
		//zaidimas.apskritimuNuskaitymas("duomenu_issaugojimas/issaugomi_apskritimai.csv");
		
		ArrayList<Apskritimas> apskritimai = zaidimas.pasiimtiApskritimus();
			
		return apskritimai;
	}
	
}
package Pirmas_BandymasWEB;

import java.io.IOException;
//import java.util.ArrayList;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

//import geometrija.Apskritimas;
import geometrija.Zaidimas;

@Controller
public class AjaxController {


	@GetMapping("/zaidimas")
	@ResponseBody
	
	public Zaidimas apskritimai() throws IOException{
		
		Zaidimas zaidimas = new Zaidimas();
		
		//zaidimas.apskritimuSukurimas();
		
		zaidimas.apskritimuNuskaitymas("duomenu_issaugojimas/issaugomi_apskritimai.csv");
		
		//zaidimas.plotoSkaiciavimas();
		
		zaidimas.zaidejuPlotoSkaiciavimas();

		//ArrayList<Apskritimas> apskritimai = zaidimas.getApskritimai();
		
		return zaidimas;
	
	}
	
	/*public void	apskritimaiAntrasMetodas() throws IOException{
		
		Zaidimas zaidimas = new Zaidimas();
		
		zaidimas.apskritimuSukurimas();
		
		zaidimas.apskritimuIssaugojimas();
		
		
	}*/
	
}
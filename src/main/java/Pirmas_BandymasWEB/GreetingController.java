package Pirmas_BandymasWEB;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;

import geometrija.Apskritimas;
import geometrija.Zaidimas;

@Controller
public class GreetingController {

	@RequestMapping("/greeting")
	public String greeting(
			@RequestParam(name="name", required=false, defaultValue="World") String name, 
			@RequestParam(name="sukurimas", required=false, defaultValue="world") String sukurk,
			@RequestParam(name="xkoor", required=false, defaultValue="0") Double x,
			@RequestParam(name="ykoor", required=false, defaultValue="0") Double y,
			@RequestParam(name="radius", required=false, defaultValue="0") Double radius,
			@RequestParam(name="zaidimas", required=false, defaultValue="0") String zaisk,
			Model model)
	{
		model.addAttribute("name", name);
		Zaidimas zaidimas = new Zaidimas();
		zaidimas.apskritimuNuskaitymas("duomenu_issaugojimas/issaugomi_apskritimai.csv");
		//zaidimas.plotoSkaiciavimas();
		ArrayList<Apskritimas> apskritimai = zaidimas.getApskritimai();
		
		try {
	
		
			if(sukurk.equals("sukurk")) {
				
				//zaidimas.apskritimuNuskaitymas("duomenu_issaugojimas/issaugomi_apskritimai.csv");
				apskritimai.add(new Apskritimas(x, y, radius));
				zaidimas.zaidejoApskritimoIssaugojimas();
				//zaidimas.apskritimuIstrinimas();
				
			}
			
			if(zaisk.equals("zaisk")) {
				
				zaidimas.apskritimuIstrinimas();
				zaidimas.failoSukurimas();
				zaidimas.apskritimuSukurimas();
				zaidimas.apskritimuIssaugojimas();
			}
		
		}catch(Exception e){
		
			e.printStackTrace();
			
		}
		zaidimas.zaidejuPlotoSkaiciavimas();
		model.addAttribute("apskritimai", zaidimas.getApskritimai());
		
		return "greeting";

	}
}
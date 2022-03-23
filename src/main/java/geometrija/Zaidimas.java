package geometrija;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Zaidimas {
	
	ArrayList<Apskritimas> apskritimai = new ArrayList<Apskritimas>();

	public Zaidimas(ArrayList<Apskritimas> apskritimai) {
		
		super();
		this.apskritimai = apskritimai;
		
	}

	public Zaidimas() {
		
		super();
		
	}
	
	public void apskritimuIssaugojimas( ArrayList<Apskritimas> perduoti_apskritimai ) throws IOException {
		
		FileWriter issaugojimas = new FileWriter("duomenu_issaugojimas/isaugomi_apskritimai.csv");
		
		for (int i = 0; i < apskritimai.size(); i++) {
		
		issaugojimas.write("" + perduoti_apskritimai.get(i).getX() + ",");
		issaugojimas.write("" + perduoti_apskritimai.get(i).getY() + ",");
		issaugojimas.write("" + perduoti_apskritimai.get(i).getRadius() + "\n");
	
		}
		
		issaugojimas.close();
		this.apskritimai = perduoti_apskritimai;
	}
	
	public void zaidejoApskritimoIssaugojimas(Apskritimas apskritimas) throws IOException {
		
		FileWriter zaidejoIssaugojimas = new FileWriter("duomenu_issaugojimas/issaugomi_zaidejo_apskritimai.csv", true);
		
		zaidejoIssaugojimas.write("" + apskritimas.getX() + ",");
		zaidejoIssaugojimas.write("" + apskritimas.getY() + ",");
		zaidejoIssaugojimas.write("" + apskritimas.getRadius() + "\n");
		
		zaidejoIssaugojimas.close();
	}
	
	public void apskritimuNuskaitymas() {
		
	
		try {
			
			File failas = new File("duomenu_issaugojimas/issaugomi_zaidejo_apskritimai.csv");
		
			Scanner nuskaitymas;
		
			nuskaitymas = new Scanner(failas);
		
			while (nuskaitymas.hasNextLine()) {
			
				String isskirimas = nuskaitymas.nextLine();
				String[] reiksmes = isskirimas.split(",");
				double x = Double.parseDouble(reiksmes[0]);
				double y = Double.parseDouble(reiksmes[1]);
				double radius = Double.parseDouble(reiksmes[2]);
				apskritimai.add(new Apskritimas(x, y, radius));
				
			}
			
			nuskaitymas.close();
			
		}catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public void apskritimuSukurimas() {
		
		for (int i = 0; i < 10; i++) {
			
			apskritimai.add(new Apskritimas(-100, 100, -100, 100, 100));
			
		}
		
	}
	
	public ArrayList<Apskritimas> pasiimtiApskritimus(){
		
		return apskritimai;
		
	}
	
}

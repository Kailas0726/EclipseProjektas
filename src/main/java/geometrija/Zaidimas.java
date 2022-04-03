package geometrija;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
//import geometrija.Apskritimas; 

public class Zaidimas {
	
	protected ArrayList<Apskritimas> apskritimai = new ArrayList<Apskritimas>();
	protected boolean ar_persidengia = false;
	protected int sugeneruotu_apskritimu_kiekis = 2;
	protected int taskai = 0;

	public Zaidimas(ArrayList<Apskritimas> apskritimai) {
		
		super();
		this.apskritimai = apskritimai;
		
	}

	public Zaidimas() {
		
		super();
		
	}
	
	public void apskritimuIssaugojimas() throws IOException {
		
		try {
			
			FileWriter issaugojimas = new FileWriter("duomenu_issaugojimas/issaugomi_apskritimai.csv");
			
			for (int i = 0; i < apskritimai.size(); i++) {
			
				issaugojimas.write("" + apskritimai.get(i).getX() + ",");
				issaugojimas.write("" + apskritimai.get(i).getY() + ",");
				issaugojimas.write("" + apskritimai.get(i).getRadius() + "\n");
		
			}
			
			issaugojimas.close();
			//this.apskritimai = perduoti_apskritimai;
			
		}catch (IOException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public void zaidejoApskritimoIssaugojimas() throws IOException {
		
		FileWriter zaidejoIssaugojimas = new FileWriter("duomenu_issaugojimas/issaugomi_apskritimai.csv", true);
		
		zaidejoIssaugojimas.write(""+apskritimai.get(apskritimai.size()-1).getX()+",");
		zaidejoIssaugojimas.write(""+apskritimai.get(apskritimai.size()-1).getY()+",");
		zaidejoIssaugojimas.write(""+apskritimai.get(apskritimai.size()-1).getRadius()+ "\n");
		
		
		zaidejoIssaugojimas.close();
	}
	
	public void apskritimuNuskaitymas(String nuskaitymoFailas) {
		
	
		try {
			
			File failas = new File(nuskaitymoFailas);
		
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
	
	public void apskritimuSukurimas() throws IOException{
		//apskritimai =  new ArrayList<Apskritimas>();
		for (int i = 0; i < sugeneruotu_apskritimu_kiekis; i++) {
			
			apskritimai.add(new Apskritimas(-100, 100, -100, 100, 100));
		
		}
		
	}
	
	public ArrayList<Apskritimas> getApskritimai(){
		
		return apskritimai;
		
	}
	
	public void apskritimuIstrinimas() {
		
		File failas = new File("duomenu_issaugojimas/issaugomi_apskritimai.csv");
		failas.delete();
		apskritimai =  new ArrayList<Apskritimas>();
		
	}
	
	public void failoSukurimas() throws IOException{
		
		File failas = new File("duomenu_issaugojimas/issaugomi_apskritimai.csv");
		failas.createNewFile();
		
	}
	
	public boolean arPersidengia() {

		int i = 0;
		
		while (( i < apskritimai.size()) && !ar_persidengia) {
			
			ar_persidengia = apskritimai.get(i).arPersidengia(apskritimai.get(apskritimai.size()-1));
			
			 i++;
		}
		
		return ar_persidengia;
		
	}
	
	public void plotoSkaiciavimas() {
		
		for (int i = 0; i < apskritimai.size(); i++) {
			
			apskritimai.get(i).setPlotas();
		}
		
	}
	

	public int getTaskai() {
		return taskai;
	}

	public void setTaskai(int taskai) {
		this.taskai = taskai;
	}
	
	public void zaidejuPlotoSkaiciavimas(){
		
		for (int i = sugeneruotu_apskritimu_kiekis - 1; i < apskritimai.size(); i++) {
			
			taskai += apskritimai.get(i).setPlotas().getPlotas();
			//System.out.println(taskai);
		}

	}
	
}

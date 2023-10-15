package Model;

import java.util.ArrayList;
import java.util.List;

public class api {

	public static void main(String[] args) {
		List<Regiao> mapa_mundo = inicializa_mundo();
		
		
	}
	
	public static List<Regiao> inicializa_mundo(){
		List<Regiao> mundo = new ArrayList<Regiao>();
		mundo.add(new Asia());
		mundo.add(new Europa());
		mundo.add(new Oceania());
		mundo.add(new AmericadoSul());
		mundo.add(new AmericadoNorte());
		mundo.add(new Africa());
		return mundo;
	}
}



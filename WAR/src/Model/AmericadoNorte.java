package Model;

import java.util.ArrayList;
import java.util.Arrays;

class AmericadoNorte extends Regiao{
	public AmericadoNorte() {
		this.nome = "América do Norte";
		this.exercito_extra = 5;
		paises.add(new Territorio("México", "América do Norte", new ArrayList<>(Arrays.asList("Venezuela", "Califórnia", "Texas"))));
        paises.add(new Territorio("Califórnia", "América do Norte", new ArrayList<>(Arrays.asList("Vancouver", "Texas", "México"))));
        paises.add(new Territorio("Texas", "América do Norte", new ArrayList<>(Arrays.asList("México", "Califórnia", "Vancouver", "Nova York", "Quebec"))));
        paises.add(new Territorio("Vancouver", "América do Norte", new ArrayList<>(Arrays.asList("Califórnia", "Texas", "Quebec", "Alasca", "Calgary"))));
        paises.add(new Territorio("Nova York", "América do Norte", new ArrayList<>(Arrays.asList("Texas", "Quebec"))));
        paises.add(new Territorio("Quebec", "América do Norte", new ArrayList<>(Arrays.asList("Nova York", "Texas", "Vancouver", "Groenlândia"))));
        paises.add(new Territorio("Alasca", "América do Norte", new ArrayList<>(Arrays.asList("Vancouver", "Calgary", "Sibéria"))));
        paises.add(new Territorio("Calgary", "América do Norte", new ArrayList<>(Arrays.asList("Vancouver", "Alasca", "Groenlândia"))));
        paises.add(new Territorio("Groenlândia", "América do Norte", new ArrayList<>(Arrays.asList("Calgary", "Quebec", "Reino Unido"))));
	}
	
}

package Model;

import java.util.ArrayList;
import java.util.Arrays;

class Oceania extends Regiao {
	public Oceania() {
		this.nome = "Oceania";
		this.exercito_extra = 2;
		paises.add(new Territorio("Austrália", "Oceania", new ArrayList<>(Arrays.asList("Indonésia", "Nova Zelândia", "Perth"))));
        paises.add(new Territorio("Indonésia", "Oceania", new ArrayList<>(Arrays.asList("Austrália", "Nova Zelândia", "Bangladesh", "Índia"))));
        paises.add(new Territorio("Nova Zelândia", "Oceania", new ArrayList<>(Arrays.asList("Indonésia", "Austrália"))));
        paises.add(new Territorio("Perth", "Oceania", new ArrayList<>(Arrays.asList("Austrália"))));
	}
}

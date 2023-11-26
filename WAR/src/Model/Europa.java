package Model;

import java.util.ArrayList;
import java.util.Arrays;

class Europa extends Regiao{
		public Europa() {
			super();
			this.nome = "Europa";
			this.exercito_extra = 5;
			paises.add(new Territorio("Reino Unido", "Europa", new ArrayList<>(Arrays.asList("Groenlândia", "França"))));
	        paises.add(new Territorio("França", "Europa", new ArrayList<>(Arrays.asList("Espanha", "Itália", "Suécia", "Argélia","Reino Unido"))));
	        paises.add(new Territorio("Espanha", "Europa", new ArrayList<>(Arrays.asList("Argélia", "França"))));
	        paises.add(new Territorio("Itália", "Europa", new ArrayList<>(Arrays.asList("França", "Argélia", "Polônia", "Romênia", "Suécia"))));
	        paises.add(new Territorio("Suécia", "Europa", new ArrayList<>(Arrays.asList("França", "Itália", "Letônia", "Estônia"))));
	        paises.add(new Territorio("Polônia", "Europa", new ArrayList<>(Arrays.asList("Itália", "Letônia", "Romênia", "Ucrânia"))));
	        paises.add(new Territorio("Romênia", "Europa", new ArrayList<>(Arrays.asList("Egito", "Itália", "Polônia", "Ucrânia"))));
	        paises.add(new Territorio("Ucrânia", "Europa", new ArrayList<>(Arrays.asList("Polônia", "Romênia", "Letônia", "Turquia"))));
		}
}

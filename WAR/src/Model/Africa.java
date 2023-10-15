package Model;

import java.util.*;

class Africa extends Regiao{
	public Africa(){
		this.nome="África";
		this.exercito_extra = 3;
		paises.add(new Territorio("Argélia", "África", new ArrayList<>(Arrays.asList("Espanha", "Itália", "Nigéria", "Egito"))));
		paises.add(new Territorio("Nigéria", "África", new ArrayList<>(Arrays.asList("Brasil", "Argélia", "Egito", "Somália", "Angola"))));
		paises.add(new Territorio("Angola", "África", new ArrayList<>(Arrays.asList("África do Sul", "Somália", "Nigéria"))));
		paises.add(new Territorio("Egito", "África", new ArrayList<>(Arrays.asList("Romênia", "Argélia", "Nigéria", "Somália", "Jordânia"))));
	    paises.add(new Territorio("Somália", "África", new ArrayList<>(Arrays.asList("Egito", "Nigéria", "Angola", "África do Sul", "Arábia Saudita"))));
	    paises.add(new Territorio("África do Sul", "África", new ArrayList<>(Arrays.asList("Angola", "Somália"))));
	}

}

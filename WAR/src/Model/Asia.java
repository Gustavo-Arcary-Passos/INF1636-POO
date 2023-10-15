package Model;

import java.util.*;

class Asia extends Regiao{
	public Asia() {
		this.nome = "Ásia";
		this.exercito_extra = 7;
		paises.add(new Territorio("Letônia", "Ásia", new ArrayList<>(Arrays.asList("Polônia", "Ucrânia", "Suécia", "Estônia", "Turquia", "Cazaquistão", "Rússia"))));
        paises.add(new Territorio("Estônia", "Ásia", new ArrayList<>(Arrays.asList("Suécia", "Rússia", "Letônia"))));
        paises.add(new Territorio("Turquia", "Ásia", new ArrayList<>(Arrays.asList("Letônia", "Cazaquistão", "Ucrânia", "Paquistão", "Síria", "China"))));
        paises.add(new Territorio("Sibéria", "Ásia", new ArrayList<>(Arrays.asList("Rússia", "Cazaquistão", "Alasca"))));
        paises.add(new Territorio("Rússia", "Ásia", new ArrayList<>(Arrays.asList("Estônia", "Letônia", "Cazaquistão", "Sibéria"))));
        paises.add(new Territorio("Cazaquistão", "Ásia", new ArrayList<>(Arrays.asList("Letônia", "Turquia", "Rússia", "Sibéria", "Japão", "China", "Mongólia"))));
        paises.add(new Territorio("Arábia Saudita", "Ásia", new ArrayList<>(Arrays.asList("Jordânia", "Iraque", "Somália"))));
        paises.add(new Territorio("Bangladesh", "Ásia", new ArrayList<>(Arrays.asList("Coreia do Sul", "Índia", "Tailândia", "Indonésia"))));
        paises.add(new Territorio("China", "Ásia", new ArrayList<>(Arrays.asList("Turquia", "Cazaquistão", "Mongólia", "Coreia do Norte", "Coreia do Sul", "Paquistão", "Índia"))));
        paises.add(new Territorio("Coreia do Norte", "Ásia", new ArrayList<>(Arrays.asList("Japão", "China", "Coreia do Sul"))));
        paises.add(new Territorio("Coreia do Sul", "Ásia", new ArrayList<>(Arrays.asList("China", "Coreia do Norte", "Índia", "Bangladesh", "Tailândia"))));
        paises.add(new Territorio("Índia", "Ásia", new ArrayList<>(Arrays.asList("Paquistão", "China", "Coreia do Sul", "Bangladesh"))));
        paises.add(new Territorio("Irã", "Ásia", new ArrayList<>(Arrays.asList("Iraque", "Síria", "Paquistão"))));
        paises.add(new Territorio("Iraque", "Ásia", new ArrayList<>(Arrays.asList("Arábia Saudita", "Jordânia", "Síria", "Irã"))));
        paises.add(new Territorio("Japão", "Ásia", new ArrayList<>(Arrays.asList("Cazaquistão", "Mongólia", "Coreia do Norte"))));
        paises.add(new Territorio("Jordânia", "Ásia", new ArrayList<>(Arrays.asList("Arábia Saudita", "Síria", "Iraque", "Egito"))));
        paises.add(new Territorio("Mongólia", "Ásia", new ArrayList<>(Arrays.asList("China", "Japão", "Cazaquistão"))));
        paises.add(new Territorio("Tailândia", "Ásia", new ArrayList<>(Arrays.asList("Bangladesh", "Coreia do Sul"))));
        paises.add(new Territorio("Paquistão", "Ásia", new ArrayList<>(Arrays.asList("Irã", "China","Índia","Turquia","Síria"))));
        paises.add(new Territorio("Síria", "Ásia", new ArrayList<>(Arrays.asList("Paquistão","Turquia","Irã","Jordânia","Iraque"))));
	}
	
}

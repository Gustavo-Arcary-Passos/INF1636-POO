package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ConjuntoCartaConquista {
	protected List<CartaConquista> cartas = new ArrayList<CartaConquista>();
	protected int troca;
	protected int max_cartas;
	protected int qtd;
	
	public ConjuntoCartaConquista() {
		qtd = 4;
		max_cartas = 5;
		cartas.add(new CartaTriangulo("África do Sul"));
		cartas.add(new CartaTriangulo("Egito"));
		cartas.add(new CartaTriangulo("Alasca"));
		cartas.add(new CartaTriangulo("Texas"));
		cartas.add(new CartaTriangulo("Vancouver"));
		cartas.add(new CartaTriangulo("Coreia do Sul"));
		cartas.add(new CartaTriangulo("Índia"));
		cartas.add(new CartaTriangulo("Iraque"));
		cartas.add(new CartaTriangulo("Mongólia"));
		cartas.add(new CartaTriangulo("Rússia"));
		cartas.add(new CartaTriangulo("Tailândia"));
		cartas.add(new CartaTriangulo("Turquia"));
		cartas.add(new CartaTriangulo("Peru"));
		cartas.add(new CartaTriangulo("Venezuela"));
		cartas.add(new CartaTriangulo("França"));
		cartas.add(new CartaTriangulo("Polônia"));
		cartas.add(new CartaTriangulo("Romênia"));
		
		cartas.add(new CartaQuadrado("Angola"));
		cartas.add(new CartaQuadrado("Somália"));
		cartas.add(new CartaQuadrado("California"));
		cartas.add(new CartaQuadrado("México"));
		cartas.add(new CartaQuadrado("Nova York"));
		cartas.add(new CartaQuadrado("China"));
		cartas.add(new CartaQuadrado("Coreia do Norte"));
		cartas.add(new CartaQuadrado("Irã"));
		cartas.add(new CartaQuadrado("Jordânia"));
		cartas.add(new CartaQuadrado("Letônia"));
		cartas.add(new CartaQuadrado("Sibéria"));
		cartas.add(new CartaQuadrado("Síria"));
		cartas.add(new CartaQuadrado("Argentina"));
		cartas.add(new CartaQuadrado("Itália"));
		cartas.add(new CartaQuadrado("Suécia"));
		cartas.add(new CartaQuadrado("Nova Zelândia"));
		//cartas.add(new CartaQuadrado());
		
		cartas.add(new CartaCirculo("Argélia"));
		cartas.add(new CartaCirculo("Nigéria"));
		cartas.add(new CartaCirculo("Calgary"));
		cartas.add(new CartaCirculo("Groenlândia"));
		cartas.add(new CartaCirculo("Quebec"));
		cartas.add(new CartaCirculo("Arábia Saudita"));
		cartas.add(new CartaCirculo("Bangladesh"));
		cartas.add(new CartaCirculo("Cazaquistão"));
		cartas.add(new CartaCirculo("Estônia"));
		cartas.add(new CartaCirculo("Japão"));
		cartas.add(new CartaCirculo("Paquistão"));
		cartas.add(new CartaCirculo("Brasil"));
		cartas.add(new CartaCirculo("Espanha"));
		cartas.add(new CartaCirculo("Reino Unido"));
		cartas.add(new CartaCirculo("Ucrânia"));
		cartas.add(new CartaCirculo("Perth"));
		//cartas.add(new CartaCirculo());
		
		cartas.add(new CartaCuringa());
		cartas.add(new CartaCuringa());
    }
	
	public void tira_uma_carta(Jogador jogador){
		Random rand = new Random();
		CartaConquista carta = cartas.get(rand.nextInt(cartas.size()));
		if(jogador.add_carta(carta)) {
			
			cartas.remove(carta);
		}
	}
	
	public List<CartaConquista> get_cartas() {
		return this.cartas;
	}
	
	public int get_max_cartas() {
		return this.max_cartas;
	}
	
	public boolean verifica_troca(List<CartaConquista> descartadas) {
		if(descartadas.size() != 3) {
			return false;
		}
		CartaConquista cartaUm = descartadas.get(0);
		CartaConquista cartaDois = descartadas.get(1);
		CartaConquista cartaTres = descartadas.get(2);
		
		if(cartaUm.get_tipo() == cartaDois.get_tipo() && cartaUm.get_tipo() == cartaTres.get_tipo()) {
			return true;
		} else if (cartaUm.get_tipo() != cartaDois.get_tipo() && cartaUm.get_tipo() != cartaTres.get_tipo() && cartaDois.get_tipo() != cartaTres.get_tipo()) {
			return true;
		}
		// Casos de alguma carta ou mais serem curingas
		if(cartaUm.get_tipo() == "Curinga") {
			if(cartaDois.get_tipo() == cartaTres.get_tipo()) {
				return true;
			}
			if(cartaDois.get_tipo() == "Curinga" || cartaTres.get_tipo() == "Curinga") {
				return true;
			}
		} else if (cartaDois.get_tipo() == "Curinga") {
			if(cartaUm.get_tipo() == cartaTres.get_tipo()) {
				return true;
			}
			if(cartaUm.get_tipo() == "Curinga" || cartaTres.get_tipo() == "Curinga") {
				return true;
			}
		} else if (cartaTres.get_tipo() == "Curinga") {
			if(cartaDois.get_tipo() == cartaUm.get_tipo()) {
				return true;
			}
			if(cartaDois.get_tipo() == "Curinga" || cartaUm.get_tipo() == "Curinga") {
				return true;
			}
		}
		return false;
	}
	
	public int trocas(List<CartaConquista> descartadas) {
		for(CartaConquista carta : descartadas) {
			cartas.add(carta);
		}
		troca++;
		if(troca < 5 && troca > 1) {
			qtd += 2;
		} else if (troca == 6){
			qtd = 15;
		} else if (troca > 6){
			qtd += 5;
		}
		return qtd;
	}
}

abstract class CartaConquista {
	protected String tipo;
	protected String pais;
	
	public String get_pais() {
		return this.pais;
	}
	
	public String get_tipo() {
		return this.tipo;
	}
}

class CartaTriangulo extends CartaConquista {
	public CartaTriangulo(String pais) {
		this.tipo = "Triangulo";
		this.pais=pais;
	}
}

class CartaQuadrado extends CartaConquista {
	public CartaQuadrado(String pais){
		this.tipo = "Quadrado";
		this.pais=pais;
	}
}

class CartaCirculo extends CartaConquista {
	public CartaCirculo(String pais) {
		this.tipo = "Circulo";
		this.pais=pais;
	}
}

class CartaCuringa extends CartaConquista {
	public CartaCuringa() {
		this.tipo = "Curinga";
	}
}

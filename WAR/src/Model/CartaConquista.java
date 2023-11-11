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
		cartas.add(new CartaTriangulo("África do Sul"));// OK
		cartas.add(new CartaTriangulo("Egito"));//OK
		cartas.add(new CartaTriangulo("Alasca"));//OK
		cartas.add(new CartaTriangulo("Texas"));//OK
		cartas.add(new CartaTriangulo("Vancouver"));//OK
		cartas.add(new CartaTriangulo("Coreia do Sul"));//OK
		cartas.add(new CartaTriangulo("Índia"));//OK
		cartas.add(new CartaTriangulo("Iraque"));//OK
		cartas.add(new CartaTriangulo("Mongólia"));//OK
		cartas.add(new CartaTriangulo("Rússia"));//OK
		cartas.add(new CartaTriangulo("Tailândia"));//OK
		cartas.add(new CartaTriangulo("Turquia"));//OK
		cartas.add(new CartaTriangulo("Peru"));//OK
		cartas.add(new CartaTriangulo("Venezuela"));//OK
		cartas.add(new CartaTriangulo("França"));//OK
		cartas.add(new CartaTriangulo("Polônia"));//OK
		cartas.add(new CartaTriangulo("Romênia"));//OK
		cartas.add(new CartaTriangulo("Austrália"));//OK
		cartas.add(new CartaTriangulo("Indonésia"));//OK
		
		cartas.add(new CartaQuadrado("Angola"));//OK
		cartas.add(new CartaQuadrado("Somália"));//OK
		cartas.add(new CartaQuadrado("California"));//OK
		cartas.add(new CartaQuadrado("México"));//OK
		cartas.add(new CartaQuadrado("Nova York"));//OK
		cartas.add(new CartaQuadrado("China"));//OK
		cartas.add(new CartaQuadrado("Coreia do Norte"));//OK
		cartas.add(new CartaQuadrado("Irã"));//OK
		cartas.add(new CartaQuadrado("Jordânia"));//OK
		cartas.add(new CartaQuadrado("Letônia"));//OK
		cartas.add(new CartaQuadrado("Sibéria"));//OK
		cartas.add(new CartaQuadrado("Síria"));//OK
		cartas.add(new CartaQuadrado("Argentina"));//OK
		cartas.add(new CartaQuadrado("Itália"));//OK
		cartas.add(new CartaQuadrado("Suécia"));//OK
		cartas.add(new CartaQuadrado("Nova Zelândia"));//OK
		//cartas.add(new CartaQuadrado());
		
		cartas.add(new CartaCirculo("Argélia"));//OK
		cartas.add(new CartaCirculo("Nigéria"));//OK
		cartas.add(new CartaCirculo("Calgary"));//OK
		cartas.add(new CartaCirculo("Groenlândia"));//OK
		cartas.add(new CartaCirculo("Quebec"));//OK
		cartas.add(new CartaCirculo("Arábia Saudita"));//OK
		cartas.add(new CartaCirculo("Bangladesh"));//OK
		cartas.add(new CartaCirculo("Cazaquistão"));//OK
		cartas.add(new CartaCirculo("Estônia"));//OK
		cartas.add(new CartaCirculo("Japão"));//OK
		cartas.add(new CartaCirculo("Paquistão"));//OK
		cartas.add(new CartaCirculo("Brasil"));//OK
		cartas.add(new CartaCirculo("Espanha"));//OK
		cartas.add(new CartaCirculo("Reino Unido"));//OK
		cartas.add(new CartaCirculo("Ucrânia"));//OK
		cartas.add(new CartaCirculo("Perth"));//OK
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
	
	public void carta_retorna_deck(CartaConquista carta) {
		this.cartas.add(carta);
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
		this.pais = "Curinga";
	}
}

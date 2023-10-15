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
		cartas.add(new CartaTriangulo());
		cartas.add(new CartaTriangulo());
		cartas.add(new CartaTriangulo());
		cartas.add(new CartaTriangulo());
		cartas.add(new CartaTriangulo());
		cartas.add(new CartaTriangulo());
		cartas.add(new CartaTriangulo());
		cartas.add(new CartaTriangulo());
		cartas.add(new CartaTriangulo());
		cartas.add(new CartaTriangulo());
		cartas.add(new CartaTriangulo());
		cartas.add(new CartaTriangulo());
		cartas.add(new CartaTriangulo());
		cartas.add(new CartaTriangulo());
		cartas.add(new CartaTriangulo());
		cartas.add(new CartaTriangulo());
		cartas.add(new CartaTriangulo());
		
		cartas.add(new CartaQuadrado());
		cartas.add(new CartaQuadrado());
		cartas.add(new CartaQuadrado());
		cartas.add(new CartaQuadrado());
		cartas.add(new CartaQuadrado());
		cartas.add(new CartaQuadrado());
		cartas.add(new CartaQuadrado());
		cartas.add(new CartaQuadrado());
		cartas.add(new CartaQuadrado());
		cartas.add(new CartaQuadrado());
		cartas.add(new CartaQuadrado());
		cartas.add(new CartaQuadrado());
		cartas.add(new CartaQuadrado());
		cartas.add(new CartaQuadrado());
		cartas.add(new CartaQuadrado());
		cartas.add(new CartaQuadrado());
		cartas.add(new CartaQuadrado());
		
		cartas.add(new CartaCirculo());
		cartas.add(new CartaCirculo());
		cartas.add(new CartaCirculo());
		cartas.add(new CartaCirculo());
		cartas.add(new CartaCirculo());
		cartas.add(new CartaCirculo());
		cartas.add(new CartaCirculo());
		cartas.add(new CartaCirculo());
		cartas.add(new CartaCirculo());
		cartas.add(new CartaCirculo());
		cartas.add(new CartaCirculo());
		cartas.add(new CartaCirculo());
		cartas.add(new CartaCirculo());
		cartas.add(new CartaCirculo());
		cartas.add(new CartaCirculo());
		cartas.add(new CartaCirculo());
		cartas.add(new CartaCirculo());
		
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
	
	public String get_tipo() {
		return this.tipo;
	}
}

class CartaTriangulo extends CartaConquista {
	public CartaTriangulo() {
		this.tipo = "Triangulo";
	}
}

class CartaQuadrado extends CartaConquista {
	public CartaQuadrado(){
		this.tipo = "Quadrado";
	}
}

class CartaCirculo extends CartaConquista {
	public CartaCirculo() {
		this.tipo = "Circulo";
	}
}

class CartaCuringa extends CartaConquista {
	public CartaCuringa() {
		this.tipo = "Curinga";
	}
}

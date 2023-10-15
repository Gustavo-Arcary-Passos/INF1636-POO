package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ConjuntoCartaConquista {
	protected List<CartaConquista> cartas = new ArrayList<CartaConquista>();;
	protected int troca;// 4 6 8 10 12 15 20 20+5 20+10 ...
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
		jogador.add_carta(carta);
		cartas.remove(carta);
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
		} else {
			qtd += 5;
		}
		return qtd;
	}
}

abstract class CartaConquista {
	protected String tipo;
	public abstract void set_tipo();
	
	public String get_tipo() {
		return this.tipo;
	}
}

class CartaTriangulo extends CartaConquista {
	public void set_tipo() {
		this.tipo = "Triangulo";
	}
}

class CartaQuadrado extends CartaConquista {
	public void set_tipo() {
		this.tipo = "Triangulo";
	}
}

class CartaCirculo extends CartaConquista {
	public void set_tipo() {
		this.tipo = "Circulo";
	}
}

class CartaCuringa extends CartaConquista {
	public void set_tipo() {
		this.tipo = "Curinga";
	}
}

package Model;

import java.util.*;

class Jogador {
    private String nome;
    private String cor;
    protected List<Territorio> domina;
    protected List<CartaConquista> cartaTroca;
    protected boolean conquistou_territorio_rodada;
    private Jogador destruido_por;
    private Objetivo objetivo;
    protected int qtd_exercitos;
    
    public boolean verifica_territorio(Territorio pais) {
    	for (Territorio terr : this.domina) {
    		if(terr.equals(pais)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public int qtd_territorios() {
    	return domina.size();
    }

    public Jogador(String nome, String cor) {
        this.nome = nome;
        this.cor = cor;
        this.destruido_por=null;
    }

    public String get_nome() {
        return this.nome;
    }

    public String get_cor() {
        return this.cor;
    }
    
    public void perde_territorio(Territorio perdido) {
    	domina.remove(perdido);
    }
    public boolean verifica_destruido() {
    	if(destruido_por==null) {
    		return false;
    	}
    	return true;
    }
    public void jogador_destruido(Jogador destruidor) {
    	destruido_por = destruidor;
    }
    public Jogador get_destruido_por() {
    	return this.destruido_por;
    }
    public void recebe_objetivo(Objetivo obj) {
    	objetivo = obj;
    }
    public Objetivo get_objetivo() {
    	return objetivo;
    }
    public boolean add_carta(CartaConquista carta) {
    	if(this.conquistou_territorio_rodada) {
    		this.conquistou_territorio_rodada = false;
    		this.cartaTroca.add(carta);
    		return true;
    	}
    	return false;
    }
    public void conquistou_na_rodada() {
    	this.conquistou_territorio_rodada = true;
    }
    public void add_exercito(int qtd) {
    	this.qtd_exercitos += qtd;
    }
    public void add_exercito() { //add exercito de acordo com metade dos territórios
    	this.qtd_exercitos += this.domina.size()/2;
    }
    public void troca_cartas_exercitos(int um,int dois,int tres,ConjuntoCartaConquista cartas) {
    	List<CartaConquista> trocadas = new ArrayList<CartaConquista>();
    	trocadas.add(this.cartaTroca.get(um));
    	trocadas.add(this.cartaTroca.get(dois));
    	trocadas.add(this.cartaTroca.get(tres));
    	
    	if(cartas.verifica_troca(trocadas)) {
    		this.add_exercito(cartas.trocas(trocadas)) ;
    	}
    	//implementar a remoção das cartas
    	/* this.cartaTroca.remove(um);
    	 * this.cartaTroca.remove(dois);
    	 * this.cartaTroca.remoce(tres);
    	 */
    }
    public boolean posiciona_exercito(int qtd, Territorio destino) {
    	//tem que conferir se qtd é < qtd_exercito
    	if(qtd>this.qtd_exercitos) {
    		return false;
    	}
    	for(Territorio terr : this.domina) {
    		if(terr.equals(destino)) {
    			 destino.add_exercito(qtd);
    			 this.qtd_exercitos -=qtd;
    			 return true;
    		}
    	}
    	return false;
    }
    
}

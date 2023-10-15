package Model;

import java.util.*;

abstract class Objetivo {
	protected Jogador dono;
	protected Regiao asia, europa, americasul, americanorte, africa, oceania;
	protected List<Jogador> todos_jogadores;
    // construtor
    public Objetivo() {
       
    }
    public Objetivo(Regiao asia, Regiao oceania, Regiao africa, Regiao americasul, Regiao americanorte, Regiao europa) {
    	this.asia = asia;
    	this.oceania = oceania;
    	this.africa = africa;
    	this.americasul = americasul;
    	this.americanorte = americanorte;
    	this.europa = europa;
    }
    public Objetivo(List<Jogador> todos_jogadores) {
    	this.todos_jogadores = new ArrayList<Jogador>();
    	for(Jogador el : todos_jogadores) {
    		this.todos_jogadores.add(el);
    	}
    }
    	
    
    // roda programa para saber se um jogador ganhou
    // cada objetivo deve implementar sua própria versão
    public abstract boolean verifica_status();
    
    public void ganha_dono(Jogador dono) {
    	this.dono = dono;
    }
   

}

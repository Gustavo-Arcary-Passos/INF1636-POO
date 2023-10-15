package Model;

import java.util.*;

abstract class Objetivo {
	protected Jogador dono;
	protected Regiao asia, europa, americasul, americanorte, africa, oceania;
	protected List<Jogador> todos_jogadores;
    // construtor
    public Objetivo() {
       
    }
    public Objetivo(List<Jogador> todos_jogadores, List<Regiao> mapa) {
    	this.todos_jogadores = new ArrayList<Jogador>();
    	for(Jogador el : todos_jogadores) {
    		this.todos_jogadores.add(el);
    	}
    	for(Regiao reg : mapa) {
    		if(reg.get_nome().equals("África")) {
    			this.africa= reg; 
    		}
    		if(reg.get_nome().equals("Ásia")) {
    			this.asia = reg;
    		}
    		if(reg.get_nome().equals("América do Norte")) {
    			this.americanorte = reg;
    		}
    		if(reg.get_nome().equals("América do Sul")) {
    			this.americasul = reg;
    		}
    		if(reg.get_nome().equals("Europa")) {
    			this.europa = reg;
    		}
    		if(reg.get_nome().equals("Oceania")) {
    			this.oceania = reg;
    		}
    	}
    }
    	
    
    // roda programa para saber se um jogador ganhou
    // cada objetivo deve implementar sua própria versão
    public abstract boolean verifica_status();
    
    public void ganha_dono(Jogador dono) {
    	this.dono = dono;
    }
   

}

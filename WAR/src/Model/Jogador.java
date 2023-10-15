package Model;

import java.util.*;

class Jogador {
    private String nome;
    private String cor;
    protected List<Territorio> domina;
    private Jogador destruido_por;
    private Objetivo objetivo;
    
    
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
    public void recebe_objetivo(Objetivo obj) {
    	objetivo = obj;
    }
    public Objetivo get_objetivo() {
    	return objetivo;
    }
}

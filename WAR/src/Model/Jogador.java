package Model;

import java.util.*;

class Jogador {
    private String nome;
    private String cor;
    private List<Territorio> domina;
    
    public boolean verifica_territorio(Territorio pais) {
    	for (Territorio terr : this.domina) {
    		if(terr.equals(pais)) {
    			return true;
    		}
    	}
    	return false;
    }

    public Jogador(String nome, String cor) {
        this.nome = nome;
        this.cor = cor;
    }

    public String get_nome() {
        return this.nome;
    }

    public String get_cor() {
        return this.cor;
    }
}

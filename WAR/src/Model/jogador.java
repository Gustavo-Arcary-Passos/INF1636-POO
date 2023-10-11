package Model;

import java.util.*;

class jogador {
    private String nome;
    private String cor;
    private List<territorio> domina;
    
    public boolean verifica_territorio(territorio pais) {
    	for (territorio terr : this.domina) {
    		if(terr.equals(pais)) {
    			return true;
    		}
    	}
    	return false;
    }

    public jogador(String nome, String cor) {
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

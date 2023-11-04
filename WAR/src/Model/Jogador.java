package Model;

import java.util.*;

class Jogador {
    private String nome;
    private String cor;
    protected List<Territorio> domina;
    protected List<CartaConquista> cartaTroca;
    protected List<ExercitoRegiao> exercitos_regiao;
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
    public boolean verifica_territorio(String pais) {
    	for (Territorio terr : this.domina) {
    		if(terr.get_nome() == pais) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public int get_exercito() {
    	return this.qtd_exercitos;
    }
    public int qtd_territorios() {
    	return domina.size();
    }

    public Jogador(String nome, String cor) {
        this.nome = nome;
        this.cor = cor;
        this.destruido_por= null;
        this.domina = new ArrayList<Territorio>();
        this.cartaTroca = new ArrayList<CartaConquista>();
        this.exercitos_regiao = new ArrayList<ExercitoRegiao>();
        this.exercitos_regiao.add(new ExercitoRegiao("Ásia"));
        this.exercitos_regiao.add(new ExercitoRegiao("América do Norte"));
        this.exercitos_regiao.add(new ExercitoRegiao("América do Sul"));
        this.exercitos_regiao.add(new ExercitoRegiao("Europa"));
        this.exercitos_regiao.add(new ExercitoRegiao("Oceania"));
        this.exercitos_regiao.add(new ExercitoRegiao("África"));
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
    public void ganha_territorio(Territorio ganhado) {
    	ganhado.set_Jogador(this);
    	domina.add(ganhado);
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
    public List<CartaConquista> get_carta(){
    	return this.cartaTroca;
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
    public int get__exercito_regiao(String regiao) {
    	for(ExercitoRegiao exercito : this.exercitos_regiao) {
    		if(exercito.get_regiao() == regiao) {
    			return exercito.get_exercito();
    		}
    	}
    	return 0;
    }
    public void add_exercito_regiao(String regiao,int qtd) {
    	for(ExercitoRegiao exercito : this.exercitos_regiao) {
    		if(exercito.get_regiao() == regiao) {
    			exercito.add_exercito(qtd);
    		}
    	}
    }
    public boolean posiciona_exercito_regiao(String regiao,String territorio,int qtd) {
    	int exercitos_regiao = 0;
    	for(ExercitoRegiao exercito : this.exercitos_regiao) {
    		if(exercito.get_regiao() == regiao) {
    			
    			exercitos_regiao = exercito.get_exercito();
    		}
    	}
    	if(qtd > exercitos_regiao) {
    		return false;
    	}
    	for(Territorio terr : this.domina) {
    		if(terr.get_nome().equals(territorio) && terr.get_Regiao().equals(regiao)) {
    			terr.add_exercito(qtd);
    			this.add_exercito_regiao(regiao,-qtd);
    			return true;
    		}
    	}
    	return false;
    }
    public void troca_cartas_exercitos(int um,int dois,int tres,ConjuntoCartaConquista cartas) {
    	List<CartaConquista> trocadas = new ArrayList<CartaConquista>();
    	trocadas.add(this.cartaTroca.get(um));
    	trocadas.add(this.cartaTroca.get(dois));
    	trocadas.add(this.cartaTroca.get(tres));
    	
    	if(cartas.verifica_troca(trocadas)) {
    		this.add_exercito(cartas.trocas(trocadas)) ;
    		this.cartaTroca.remove(um);
        	this.cartaTroca.remove(dois);
        	this.cartaTroca.remove(tres);
    	}
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
    public boolean posiciona_exercito(int qtd, String destino) {
    	//tem que conferir se qtd é < qtd_exercito
    	if(qtd>this.qtd_exercitos) {
    		return false;
    	}
    	for(Territorio terr : this.domina) {
    		if(terr.get_nome() == destino) {
    			 terr.add_exercito(qtd);
    			 this.qtd_exercitos -=qtd;
    			 System.out.println(terr.get_exercitos());
    			 return true;
    		}
    	}
    	
    	return false;
    }
    
    public void show_all_terr() {
    	for(Territorio terr : this.domina) {
    		System.out.println(terr.get_nome());
    	}
    }
    
}

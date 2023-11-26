package Model;

import java.util.*;

/**
 * Uma lista com todos os objetivos do jogo.
 */
class DeckObjetivos {
    private List<Objetivo> objetivos;
    
    //Temos que passar uma referência aos continentes criados para verificar alguns objetivos
    public DeckObjetivos(List<Regiao> mapa, List<Jogador> todos_jogadores) {
    	objetivos = new ArrayList<Objetivo>();
    	objetivos.add(new Objetivo1(todos_jogadores, mapa,"Objetivo 1"));
    	objetivos.add(new Objetivo2(todos_jogadores, mapa,"Objetivo 2"));
    	objetivos.add(new Objetivo3(todos_jogadores, mapa,"Objetivo 3"));
    	objetivos.add(new Objetivo4(todos_jogadores, mapa,"Objetivo 4"));
    	objetivos.add(new Objetivo5(todos_jogadores, mapa,"Objetivo 5"));
    	objetivos.add(new Objetivo6(todos_jogadores,mapa,"Objetivo 6"));
    	objetivos.add(new Objetivo7(todos_jogadores, mapa,"Objetivo 7"));
    	objetivos.add(new Objetivo8(todos_jogadores, mapa,"Objetivo 8"));
    	objetivos.add(new Objetivo9(todos_jogadores, mapa,"Objetivo 9"));
    	objetivos.add(new Objetivo10(todos_jogadores, mapa,"Objetivo 10"));
    	objetivos.add(new Objetivo11(todos_jogadores, mapa,"Objetivo 11"));
    	objetivos.add(new Objetivo12(todos_jogadores, mapa,"Objetivo 12"));
    	objetivos.add(new Objetivo13("Objetivo 13"));
    	objetivos.add(new Objetivo14("Objetivo 14"));
    	//System.out.println("Objetivo foi criado");
//    	for(Jogador jg : todos_jogadores) {
//    		System.out.println(jg.get_cor());
//    	}
    }
    public void sorteia_objetivo(Jogador jogador){
    	Random rand = new Random();
    	jogador.recebe_objetivo(objetivos.get(rand.nextInt(objetivos.size())));
    	jogador.get_objetivo().ganha_dono(jogador);
    	objetivos.remove(jogador.get_objetivo());
    }
    public void devolve_objetivo_jogador(Jogador jogador, String objetivo){
    	Objetivo obj_certo = null;
    	for(Objetivo obj : objetivos) {
    		if(objetivo.equals(obj.get_nome())) {
    			obj_certo = obj;
    		}
    	}
    	jogador.recebe_objetivo(obj_certo);
    	jogador.get_objetivo().ganha_dono(jogador);
    	objetivos.remove(jogador.get_objetivo());
    }
    
    public void objetivo_retorna_deck(Objetivo objetivo) {
    	objetivos.add(objetivo);
    }
    
    public Objetivo get_objetivo(int index) {
    	return objetivos.get(index-1);
    }
}

class Objetivo1 extends Objetivo {
	public Objetivo1(List<Jogador> todos_jogadores, List<Regiao> mapa, String name) {
		super(todos_jogadores,mapa,name);
	}
	//exterminar o azul, se for o azul ou outro jogador tiver eliminado o azul, 24 territorios
	public boolean verifica_status() {
		for(Jogador el : this.todos_jogadores) {
			if(el.get_cor().equals("azul")) {
				if(el.get_destruido_por()==null) {
					return false;
				}
				if(el.get_destruido_por().equals(dono)) {
					return true;
				}
			}
		}
		//caso não exista o jogador ou ele tenha sido destruido por outro
		if(dono.domina.size()>=24) {
			return true;
		}
		else {
			return false;
		}
	}
}
class Objetivo2 extends Objetivo {
	public Objetivo2(List<Jogador> todos_jogadores, List<Regiao> mapa, String name) {
		super(todos_jogadores,mapa,name);
	}
	 //exterminar o amarelo, se for o amarelo ou outro jogador tiver eliminado o amarelo, 24 territorios
	public boolean verifica_status() {
		for(Jogador el : this.todos_jogadores) {
			if(el.get_cor().equals("amarelo")) {
				if(el.get_destruido_por()==null) {
					return false;
				}
				if(el.get_destruido_por().equals(dono)) {
					return true;
				}
			}
		}
		//caso não exista o jogador ou ele tenha sido destruido por outro
		if(dono.domina.size()>=24) {
			return true;
		}
		else {
			return false;
		}
	}
}
class Objetivo3 extends Objetivo {
	public Objetivo3(List<Jogador> todos_jogadores, List<Regiao> mapa, String name) {
		super(todos_jogadores,mapa,name);
	}
	//exterminar o branco, se for o branco ou outro jogador tiver eliminado o branco, 24 territorios
	public boolean verifica_status() {
		for(Jogador el : this.todos_jogadores) {
			if(el.get_cor().equals("branco")) {
				if(el.get_destruido_por()==null) {
					return false;
				}
				if(el.get_destruido_por().equals(dono)) {
					return true;
				}
			}
		}
		//caso não exista o jogador ou ele tenha sido destruido por outro
		if(dono.domina.size()>=24) {
			return true;
		}
		else {
			return false;
		}
	}
}
class Objetivo4 extends Objetivo {
	public Objetivo4(List<Jogador> todos_jogadores, List<Regiao> mapa, String name) {
		super(todos_jogadores,mapa,name);
	}
	//exterminar o verde, se for o verde ou outro jogador tiver eliminado o verde, 24 territorios 
	public boolean verifica_status() {
		for(Jogador el : this.todos_jogadores) {
			System.out.println(el.get_cor().equals("verde"));
			if(el.get_cor().equals("verde")) {
				
				if(el.get_destruido_por()==null) {
					return false;
				}
				if(el.get_destruido_por().equals(dono)) {
					return true;
				}
			}
		}
		//caso não exista o jogador ou ele tenha sido destruido por outro
		if(dono.domina.size()>=24) {
			return true;
		}
		else {
			return false;
		}
	}
}
class Objetivo5 extends Objetivo {
	public Objetivo5(List<Jogador> todos_jogadores, List<Regiao> mapa, String name) {
		super(todos_jogadores,mapa,name);
	}
	public boolean verifica_status() {
		for(Jogador el : this.todos_jogadores) {
			if(el.get_cor().equals("preto")) {
				if(el.get_destruido_por()==null) {
					return false;
				}
				if(el.get_destruido_por().equals(dono)) {
					return true;
				}
			}
		}
		//caso não exista o jogador ou ele tenha sido destruido por outro
		if(dono.domina.size()>=24) {
			return true;
		}
		else {
			return false;
		}
	}
	//exterminar o preto, se for o preto ou outro jogador tiver eliminado o preto, 24 territorios
}
class Objetivo6 extends Objetivo {
	public Objetivo6(List<Jogador> todos_jogadores, List<Regiao> mapa, String name) {
		super(todos_jogadores,mapa,name);
	}
	
	//exterminar o vermelho, se for o vermelho ou outro jogador tiver eliminado o vermelho, 24 territorios
	public boolean verifica_status() {
		for(Jogador el : this.todos_jogadores) {
			if(el.get_cor().equals("vermelho")) {
				if(el.get_destruido_por()==null) {
					return false;
				}
				if(el.get_destruido_por().equals(dono)) {
					return true;
				}
			}
		}
		//caso não exista o jogador ou ele tenha sido destruido por outro
		if(dono.domina.size()>=24) {
			return true;
		}
		else {
			return false;
		}
	}
}
class Objetivo7 extends Objetivo {
	public Objetivo7(List<Jogador> todos_jogadores, List<Regiao> mapa, String name) {
		super(todos_jogadores,mapa,name);
	}
	 //conquistar a américa do Norte e a África
	public boolean verifica_status() {
		if(americanorte.verifica_monopolio(dono)) {
			if(africa.verifica_monopolio(dono)) {
				return true;
			}
		}	
		return false;
	}
}
class Objetivo8 extends Objetivo {
	public Objetivo8(List<Jogador> todos_jogadores, List<Regiao> mapa, String name) {
		super(todos_jogadores,mapa,name);
	}
	 //conquistar ásia e africa
	public boolean verifica_status() {
		if(asia.verifica_monopolio(dono)) {
			if(africa.verifica_monopolio(dono)) {
				return true;
			}
		}	
		return false;
	}
}
class Objetivo9 extends Objetivo {
	public Objetivo9(List<Jogador> todos_jogadores, List<Regiao> mapa, String name) {
		super(todos_jogadores,mapa,name);
	}
	 //conquistar a américa do norte e a oceania
	public boolean verifica_status() {
		if(americanorte.verifica_monopolio(dono)) {
			if(oceania.verifica_monopolio(dono)) {
				return true;
			}
		}	
		return false;
	}
}
class Objetivo10 extends Objetivo {
	public Objetivo10(List<Jogador> todos_jogadores, List<Regiao> mapa, String name) {
		super(todos_jogadores,mapa,name);
	}
	 //Europa, américa do Sul e continente aleatorio
	public boolean verifica_status() {
		if(europa.verifica_monopolio(dono)) {
			if(americasul.verifica_monopolio(dono)) {
				if(asia.verifica_monopolio(dono)) {
					return true;
				}
				if(oceania.verifica_monopolio(dono)) {
					return true;
				}
				if(americanorte.verifica_monopolio(dono)) {
					return true;
				}
				if(africa.verifica_monopolio(dono)) {
					return true;
				}
			}
		}	
		return false;
	}
}
class Objetivo11 extends Objetivo {
	public Objetivo11(List<Jogador> todos_jogadores, List<Regiao> mapa, String name) {
		super(todos_jogadores,mapa,name);
	}
	 //Asia e America do Sul
	public boolean verifica_status() {
		if(asia.verifica_monopolio(dono)) {
			if(americasul.verifica_monopolio(dono)) {
				return true;
			}
		}	
		return false;
	}
}
class Objetivo12 extends Objetivo {
	public Objetivo12(List<Jogador> todos_jogadores, List<Regiao> mapa, String name) {
		super(todos_jogadores,mapa,name);
	}
	 //Europa Oceania e +1
	public boolean verifica_status() {
		if(europa.verifica_monopolio(dono)) {
			if(oceania.verifica_monopolio(dono)) {
				if(asia.verifica_monopolio(dono)) {
					return true;
				}
				if(americasul.verifica_monopolio(dono)) {
					return true;
				}
				if(americanorte.verifica_monopolio(dono)) {
					return true;
				}
				if(africa.verifica_monopolio(dono)) {
					return true;
				}
			}
		}	
		return false;
	}
	
}
class Objetivo13 extends Objetivo {
	 //18 territorios e 2 exercitos em cada
	public Objetivo13(String name) {
		super(name);
	}
	public boolean verifica_status() {
		if(dono.qtd_territorios()>=18) {
			for(Territorio terr : dono.domina) {
				if(terr.get_exercitos()<2) {
					return false;
				}
			}
			return true;
		}
		else {
			return false;
		}
		
	}
}
class Objetivo14 extends Objetivo {
	//24 territorios
	public Objetivo14(String name) {
		super(name);
	}
	public boolean verifica_status() {
		if(dono.qtd_territorios()>=24) {
			return true;
		}
		return false;
	}
}
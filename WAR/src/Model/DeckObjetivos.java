package Model;

import java.util.*;

/**
 * Uma lista com todos os objetivos do jogo.
 */
class DeckObjetivos {
    private List<Objetivo> objetivos;
    
    //Temos que passar uma referência aos continentes criados para verificar alguns objetivos
    public DeckObjetivos(Regiao asia, Regiao oceania, Regiao africa, Regiao americasul, Regiao americanorte, Regiao europa) {
    	objetivos.add(new Objetivo1());
    	objetivos.add(new Objetivo2());
    	objetivos.add(new Objetivo3());
    	objetivos.add(new Objetivo4());
    	objetivos.add(new Objetivo5());
    	objetivos.add(new Objetivo6());
    	objetivos.add(new Objetivo7(Regiao asia, Regiao oceania, Regiao africa, Regiao americasul, Regiao americanorte, Regiao europa));
    	objetivos.add(new Objetivo8(Regiao asia, Regiao oceania, Regiao africa, Regiao americasul, Regiao americanorte, Regiao europa));
    	objetivos.add(new Objetivo9(Regiao asia, Regiao oceania, Regiao africa, Regiao americasul, Regiao americanorte, Regiao europa));
    	objetivos.add(new Objetivo10(Regiao asia, Regiao oceania, Regiao africa, Regiao americasul, Regiao americanorte, Regiao europa));
    	objetivos.add(new Objetivo11(Regiao asia, Regiao oceania, Regiao africa, Regiao americasul, Regiao americanorte, Regiao europa));
    	objetivos.add(new Objetivo12(Regiao asia, Regiao oceania, Regiao africa, Regiao americasul, Regiao americanorte, Regiao europa));
    	objetivos.add(new Objetivo13());
    	objetivos.add(new Objetivo14());
    }
    public void sorteia_objetivo(Jogador jogador){
    	Random rand = new Random();
    	jogador.recebe_objetivo(objetivos.get(rand.nextInt(objetivos.size())));
    	jogador.get_objetivo().ganha_dono(jogador);
    	objetivos.remove(jogador.get_objetivo());
    }
    
}

class Objetivo1 extends Objetivo {
	//exterminar o azul, se for o azul ou outro jogador tiver eliminado o azul, 24 territorios
	 public boolean verifica_status() {
		 
	 }
}
class Objetivo2 extends Objetivo {
	 //exterminar o amarelo, se for o amarelo ou outro jogador tiver eliminado o amarelo, 24 territorios
}
class Objetivo3 extends Objetivo {
	//exterminar o branco, se for o branco ou outro jogador tiver eliminado o branco, 24 territorios
}
class Objetivo4 extends Objetivo {
	//exterminar o verde, se for o verde ou outro jogador tiver eliminado o verde, 24 territorios 
}
class Objetivo5 extends Objetivo {
	//exterminar o preto, se for o preto ou outro jogador tiver eliminado o preto, 24 territorios
}
class Objetivo6 extends Objetivo {
	//exterminar o vermelho, se for o vermelho ou outro jogador tiver eliminado o vermelho, 24 territorios
	public boolean verifica_status() {
		//nao sei como implementar
	}
}
class Objetivo7 extends Objetivo {
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
	public boolean verifica_status() {
		if(dono.qtd_territorios()>=24) {
			return true;
		}
		return false;
	}
}
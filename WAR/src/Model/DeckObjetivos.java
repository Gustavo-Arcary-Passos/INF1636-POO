package Model;

import java.util.*;

/**
 * Uma lista com todos os objetivos do jogo.
 */
class DeckObjetivos {
    private List<Objetivo> objetivos;
    
    
    public DeckObjetivos() {
    	objetivos.add(new Objetivo1());
    	objetivos.add(new Objetivo2());
    	objetivos.add(new Objetivo3());
    	objetivos.add(new Objetivo4());
    	objetivos.add(new Objetivo5());
    	objetivos.add(new Objetivo6());
    	objetivos.add(new Objetivo7());
    	objetivos.add(new Objetivo8());
    	objetivos.add(new Objetivo9());
    	objetivos.add(new Objetivo10());
    	objetivos.add(new Objetivo11());
    	objetivos.add(new Objetivo12());
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

protected class Objetivo1 extends Objetivo {
	//exterminar o azul, se for o azul ou outro jogador tiver eliminado o azul, 24 territorios
	 public boolean verifica_status() {
		 
	 }
}
protected class Objetivo2 extends Objetivo {
	 //exterminar o amarelo, se for o amarelo ou outro jogador tiver eliminado o amarelo, 24 territorios
}
protected class Objetivo3 extends Objetivo {
	//exterminar o branco, se for o branco ou outro jogador tiver eliminado o branco, 24 territorios
}
protected class Objetivo4 extends Objetivo {
	//exterminar o verde, se for o verde ou outro jogador tiver eliminado o verde, 24 territorios 
}
protected class Objetivo5 extends Objetivo {
	//exterminar o preto, se for o preto ou outro jogador tiver eliminado o preto, 24 territorios
}
protected class Objetivo6 extends Objetivo {
	//exterminar o vermelho, se for o vermelho ou outro jogador tiver eliminado o vermelho, 24 territorios
}
protected class Objetivo7 extends Objetivo {
	 //conquistar a américa do Norte e a África
}
protected class Objetivo8 extends Objetivo {
	 //conquistar ásia e africa
}
protected class Objetivo9 extends Objetivo {
	 //conquistar a américa do norte e a oceania
}
protected class Objetivo10 extends Objetivo {
	 //Europa, américa do Sul e continente aleatorio
}
protected class Objetivo11 extends Objetivo {
	 //Asia e America do Sul
}
protected class Objetivo12 extends Objetivo {
	 //Europa Oceania e +1
}
protected class Objetivo13 extends Objetivo {
	 //18 territorios e 2 exercitos em cada
}
protected class Objetivo14 extends Objetivo {
	 //24 territorios
}
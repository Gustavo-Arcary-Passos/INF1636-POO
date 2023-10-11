package Model;

import java.util.*;

abstract class Regiao { // também conhecido como continente
	private String nome; //nome do continente
	private List<Territorio> paises; // paises no continente
	private int exercito_extra; // exercitos extra que o dominio do continente inteiro dá
	public String get_nome(){
		return this.nome;
	}
	public int get_exercito_extra() {
		return this.exercito_extra;
	}
	public Regiao(String nome, List<Territorio> paises, int exercito_extra) {
		this.nome = nome;
		this.paises = paises;
		this.exercito_extra = exercito_extra;
	}
	public boolean verifica_monopolio(Jogador jogador) {
		for(Territorio terr : paises) {
			if(!jogador.equals(terr.get_Jogador())) { //verifica se o jogador dos paises é diferente do jogador que queremos conferir
				return false;
			}
		}
		return true;
	}
	
}

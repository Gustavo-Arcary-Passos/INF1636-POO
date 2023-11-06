package Model;

import java.util.*;

/**
 * Um teritorio do jogo
 * 
 * não publico, para View e Controller não terem acesso direto
 * 
 * @param nome
 * @param regiao
 * @param fronteiras
 */
class Territorio implements Observado {
	private String nome;
	private int exercitos;
	private Jogador jogador;
	private List<String> fronteiras;
	private String regiao;
	private List<Observador> observadores;

	public Territorio(String nome, String regiao, List<String> fronteiras) {
		observadores = new ArrayList<Observador>();
		this.fronteiras = fronteiras;
		this.nome = nome;
		this.regiao = regiao;
	}
	
	public void add(Observador o) {
		observadores.add(o);
	}
	
	public void remove(Observador o) {
		observadores.remove(o);
	}
	/**Se essa função recebe 'e' como parâmetro retorna a quantidade de exércitos, se 'n' o nome do territorio e de resto retorna a cor do jogador.
	 * 
	 */
	public Object get(char c) {
		if(c=='e') {
			return exercitos;
		}
		else if(c=='n') {
			return nome;
		}
		else {
			return jogador.get_cor();
		}
	}
	
	public void conquista(Jogador conquistador, int exercito) {
		conquistador.conquistou_na_rodada();
		this.jogador = conquistador;
		this.exercitos = exercito;
		for(Observador o : observadores) {
			o.notify(this);
		}
	}

	public boolean faz_fronteira(String terr) {
		for (String fronteira : this.fronteiras) {
			if (fronteira.equals(terr)) {
				return true;
			}
		}
		return false;
	}

	public void add_exercito(int qtd) {
		this.exercitos += qtd;
		for(Observador o : observadores) {
			o.notify(this);
		}
	}

	public String get_nome() {
		return this.nome;
	}

	public String get_Regiao() {
		return this.regiao;
	}

	public int get_exercitos() {
		return this.exercitos;
	}

	public Jogador get_Jogador() {
		return this.jogador;
	}

	// DEBUG: set_jogador
	public void set_Jogador(Jogador jgd) {
		this.jogador = jgd;
		for(Observador o: observadores) {
			o.notify(this);
		}
	}
}

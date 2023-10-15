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
class Territorio {
	private String nome;
	private int exercitos;
	private Jogador jogador;
	private List<String> fronteiras;
	private String regiao;

	public Territorio(String nome, String regiao, List<String> fronteiras) {
		this.fronteiras = fronteiras;
		this.nome = nome;
		this.regiao = regiao;
	}

	public void conquista(Jogador conquistador, int exercito) {
		conquistador.conquistou_na_rodada();
		this.jogador = conquistador;
		this.exercitos = exercito;
	}

	public boolean faz_fronteira(String terr) {
		for (String fronteira : this.fronteiras) {
			if (fronteira.equals(terr)) {
				return true;
			}
		}
		return false;
	}

	public boolean add_exercito(int qtd) {
		this.exercitos += qtd;
		return true;
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
	}
}

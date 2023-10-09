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
class territorio {
	private String nome;
	private int exercitos;
	private jogador jogador;
	private List<String> fronteiras;
	private String regiao;

	public territorio(String nome, String regiao, List<String> fronteiras) {
		this.fronteiras = fronteiras;
		this.nome = nome;
		this.regiao = regiao;
	}

	public void conquista(jogador conquistador, int exercito) {
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

	public void add_exercito(jogador jgd, int qtd) {
		if (jgd != this.jogador) {
			return;
		}
		this.exercitos += qtd;
	}

	public String get_nome() {
		return this.nome;
	}

	public String get_regiao() {
		return this.regiao;
	}

	public int get_exercitos() {
		return this.exercitos;
	}

	public jogador get_jogador() {
		return this.jogador;
	}

	// DEBUG: set_jogador
	public void set_jogador(jogador jgd) {
		this.jogador = jgd;
	}
}

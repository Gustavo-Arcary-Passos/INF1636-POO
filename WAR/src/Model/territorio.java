package Model;

import java.util.*;

class territorio {
	private String nome;
	private int exercitos;
	private int jogador;
	private List<String> fronteiras;
	private String regiao;
	
	public territorio(String n,String r,List<String> front) {
		this.fronteiras = front;
		this.nome = n;
		this.regiao = r;
	}
	
	public void conquista(int conquistador, int exercito){
		this.jogador = conquistador;
		this.exercitos = exercito;
	}
	
	public boolean faz_fronteira(String terr) {
		for(String fronteira : this.fronteiras) {
			if(fronteira.equals(terr)) {
				return true;
			}
		}
		return false;
	}
	
	public void add_exercito(int id,int qtd) {
		if(id != this.jogador) {
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
	
	public int get_jogador() {
		return this.jogador;
	}
}

package Model;

import java.util.*;

abstract class Regiao { // também conhecido como continente
	protected String nome; //nome do continente
	protected List<Territorio> paises; // paises no continente
	protected int exercito_extra; // exercitos extra que o dominio do continente inteiro dá
	
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
	public Regiao() {
		this.nome = ""; // Initialize with default values
	    this.paises = new ArrayList<Territorio>();
	    this.exercito_extra = 0;
	}
	public boolean verifica_monopolio(Jogador jogador) {
		for(Territorio terr : paises) {
			if(!jogador.equals(terr.get_Jogador())) { //verifica se o jogador dos paises é diferente do jogador que queremos conferir
				return false;
			}
		}
		return true;
	}
	public Territorio get_territorio(String nome) {
		for(Territorio terr : paises) {
			if(terr.get_nome().equals(nome)) { 
				return terr;
			}
		}
		return null;
	}
	
	public List<Territorio> get_paises(){
		return paises;
	}
}

/* 
// * AMERICA DO SUL
// * Brasil:Argentina,Peru,Venezuela,Nigeria
// * Argentina:Brasil,Peru
// * Peru:Brasil,Argentina,Venezuela
// * Venezuela:Mexico,Brasil,Peru
// * 
// * AMERICA DO NORTE
// * Mexico:Venezuela,California,Texas
// * California:Vancouver,Texas,Mexico
// * Texas:Mexico,California,Vancouver,Nova York,Quebec
// * Vancouver:California,Texas,Quebec,Alasca,Calgary
// * Nova York:Texas,Quebec
// * Quebec: Nova York,Texas,Vancouver,Groelandia
// * Alasca:Vancouver,Calgary,Siberia
// * Calgary:Vancouver,Alasca,Groelandia
// * Groelandia:Calgary,Quebec,Reino Unido
// * 
// * EUROPA
// * OK Reino Unido:Groelandia,Franca
// * OK Franca:Espanha,Italia,Suecia,Argelia
// * OK Espanha:Argelia,Franca
// * OK Italia:Franca,Argelia,Polonia,Romenia,Suecia
// * OK Suecia:Franca,Italia,Letonia,Estonia
// * OK Polonia:Italia,Letonia,Polonia,Ucrania
// * OK Romenia:Egito,Italia,Polonia,Ucrania
// * OK Ucrania:Polonia,Romenia,Letonia,Turquia
// * 
// * ASIA
// * OK Letonia:Polonia,Ucrania,Suecia,Estonia,Turquia,Cazaquistao,Russia
// * OK Estonia:Suecia,Russia,Letonia
// * OK Turquia:Letonia,Cazaquistao,Ucrania,Paquistao,Siria,China
// * OK Siberia:Russia,Cazaquistao,Alasca
// * OK Russia:Estonia,Letonia,Cazaquistao,Siberia
// * OK Cazaquistao:Letonia,Turquia,Russia,Siberia,Japao,China,Mongolia
// * OK Arabia Saudita:Jordania,Iraque,Somalia
// * OK Bangladesh:Coreia do Sul,India,Tailandia,Indonesia
// * OK China:Turquia,Cazaquistao,Mongolia,Coreia do Norte,Coreia do Sul,Paquistao,India
// * OK Coreia do Norte:Japao,China,Coreia do Sul
// * OK Coreia do Sul:China,Coreia do Norte,India,Bangladesh,Tailandia
// * OK India:Paquistao,China,Coreia do Sul,Bangladesh
// * OK Ira:Iraque,Siria,Paquistao
// * OK Iraque:Arabia Saudita,Jordania,Siria,Ira
// * OK Japao:Cazaquistao,Mongolia,Coreia do Norte
// * OK Jordania:Arabia Saudita,Siria,Iraque,Egito
// * OK Mongolia:China,Japao,Cazaquistao
// * OK Tailandia:Bangladesh,Coreia do Sul
// * 
// * FALTOU - Paquistao, Siria
// * AFRICA
// * Argelia:Espanha,Italia,Nigeria,Egito
// * Nigeria:Brasil,Argelia,Egito,Somalia,Angola
// * Angola:Africa do Sul,Somalia,Nigeria
// * Egito:Romenia,Argelia,Nigeria,Somalia,Jordania
// * Somalia:Egito,Nigeria,Angola,Africa do Sul,Arabia Saudita
// * Africa do Sul:Angola,Somalia
// * 
// * Oceania
// * Australia:Indonesia,Nova Zelandia,Perth
// * Indonesia:Australia,Nova Zelandia,Bangladesh,India
// * Nova Zelandia:Indonesia,Australia
// * Perth:Australia
// */

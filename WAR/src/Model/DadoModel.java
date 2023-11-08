package Model;

import java.util.*;

class DadoModel implements Observado {
	List<Observador> lst;
	List<Integer> valoresatk = new ArrayList<Integer>();
	List<Integer> valoresdef = new ArrayList<Integer>();
	Jogador jgd_atual;
	public DadoModel() {
		lst= new ArrayList<Observador>();
	}
	public void set_jogador(Jogador jgd_atual) {
		this.jgd_atual=jgd_atual;
	}
	/** se o parametro = d retorna valores de defesa, se parametro = a retorna valores de ataque e se parametro = c retorna cor do jogador
	 **/
	public Object get(char c) {
		if(c == 'd') {
			return valoresdef;
		}
		else if (c == 'a'){
			return valoresatk;
		}
		else {
			return jgd_atual.get_cor()
;		}
		
	}
	public void add(Observador o) {
		lst.add(o);
	}
	public void remove(Observador o) {
		lst.remove(o);
	}
	
	protected void lanca_dado(int qtd_dados_defesa, int qtd_dados_ataque){
		System.out.println(qtd_dados_defesa + " | "  + qtd_dados_ataque);
		valoresatk.clear();
		valoresdef.clear();
		Random rand = new Random();
		for (int i = 0; i < qtd_dados_ataque; i++) {
	        if (valoresatk.size() < qtd_dados_ataque) { // Verifique o tamanho antes de adicionar
	            valoresatk.add(rand.nextInt(6) + 1);
	        }
	    }

	    for (int i = 0; i < qtd_dados_defesa; i++) {
	        if (valoresdef.size() < qtd_dados_defesa) { // Verifique o tamanho antes de adicionar
	            valoresdef.add(rand.nextInt(6) + 1);
	        }
	    }
		//valoresdef=valores2;
		for(Observador el : lst ) {
			el.notify(this);
		}
		
	}
}

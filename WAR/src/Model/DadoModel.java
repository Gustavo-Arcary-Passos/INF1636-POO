package Model;

import java.util.*;

class DadoModel implements Observado {
	List<Observador> lst;
	List<Integer> valoresatk;
	List<Integer> valoresdef;
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
		List<Integer> valores = new ArrayList<Integer>();
		List<Integer> valores2 = new ArrayList<Integer>();
		Random rand = new Random();
		for(int i = 0; i<qtd_dados_ataque;i++) {
			valores.add(rand.nextInt(6)+1);
		}
		valoresatk=valores;
		for(int i = 0; i<qtd_dados_defesa;i++) {
			valores2.add(rand.nextInt(6)+1);
		}
		valoresdef=valores2;
		for(Observador el : lst ) {
			el.notify(this);
		}
	}
}

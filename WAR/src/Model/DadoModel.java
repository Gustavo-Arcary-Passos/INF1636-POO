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
			return (Object)valoresdef;
		}
		else if (c == 'a'){
			return (Object)valoresatk;
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
		Random random = new Random();
        List<Integer> resultados_defesa = new ArrayList<>();
        List<Integer> resultados_ataque = new ArrayList<>();

        for (int i = 0; i < qtd_dados_defesa; i++) {
            int sorteio = random.nextInt(6) + 1; // Gera um número aleatório entre 1 e 6
            resultados_defesa.add(sorteio);
        }

        for (int i = 0; i < qtd_dados_ataque; i++) {
            int sorteio = random.nextInt(6) + 1; // Gera um número aleatório entre 1 e 6
            resultados_ataque.add(sorteio);
        }
        
        valoresdef = resultados_defesa;
        valoresatk = resultados_ataque;
		
		for(Observador el : lst ) {
			el.notify(this);
		}
		
	}
	
	protected void lanca_dado(int qtd_dados_defesa, int qtd_dados_ataque,List<Integer> hack_dados){
        List<Integer> resultados_defesa = new ArrayList<>();
        List<Integer> resultados_ataque = new ArrayList<>();

        for (int i = 0; i < qtd_dados_defesa; i++) {
            resultados_defesa.add(hack_dados.get(i));
        }

        for (int i = 0; i < qtd_dados_ataque; i++) {
            resultados_ataque.add(hack_dados.get(i+3));
        }
        
        valoresdef = resultados_defesa;
        valoresatk = resultados_ataque;
		
		for(Observador el : lst ) {
			el.notify(this);
		}
		
	}
}

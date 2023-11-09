package Model;

import java.util.*;

public class Api_model {
	private static Api_model instance = null;
	public List<Regiao> mapa_mundo;
	public List<Jogador> jogadores_ativos;
	public DeckObjetivos deckobj;
	public DadoModel dado;
	public List<Integer> reposicionamento;
	public int vez;
	
	public static Api_model getInstance() {
        if (instance == null) {
            instance = new Api_model();
        }
        return instance;
    }
	
	public String get_obj_jgd_da_vez() {
		return jogadores_ativos.get(this.vez).get_objetivo_name();
	}
	
	public void add_jogador(String nome,String cor) {
		jogadores_ativos.add(new Jogador(nome, cor));
	}
	
	public Api_model() {
		//cria mapa
		dado= new DadoModel();
		mapa_mundo = this.inicializa_mundo();
		//cria jogadores
		jogadores_ativos = new ArrayList<>();
		
		deckobj = new DeckObjetivos(mapa_mundo,jogadores_ativos);
	}
	
	public void add_observadores_exercitos(Observador o) {
		for(Regiao reg: mapa_mundo) {
			for(Territorio terr: reg.get_paises()) {
				terr.add(o);
			}
		}
	}
	
	public void sorteia_todos_territorios(List<Regiao> mapa_mundo, List<Jogador> jogadores_ativos) {
		List<String> territorios = new ArrayList<String>(Arrays.asList("Argélia","Nigéria","Angola","Egito","Somália","África do Sul","Letônia","Estônia","Turquia","Sibéria","Rússia","Cazaquistão","Arábia Saudita","Bangladesh","China","Coreia do Norte","Coreia do Sul","Índia","Irã","Iraque","Japão","Jordânia","Mongólia","Tailândia","México","Califórnia","Texas","Vancouver","Nova York","Quebec","Alasca","Calgary","Groenlândia","Brasil","Argentina","Peru","Venezuela","Reino Unido","França","Espanha","Itália","Suécia","Polônia","Romênia","Ucrânia","Austrália","Indonésia","Nova Zelândia","Perth","Paquistão","Síria"));
		Territorio escolhido;
		String terr;
		Random rand = new Random();
		int valor = 0;
		int pos;
		Jogador atual;
		while(territorios.size() != 0) {
			terr = territorios.get(rand.nextInt(territorios.size()));
			territorios.remove(terr);
			for(Regiao reg : mapa_mundo) {
				escolhido = reg.get_territorio(terr);
				if(escolhido != null) {
					pos = valor%jogadores_ativos.size();
					atual = jogadores_ativos.get(pos);
					atual.ganha_territorio(escolhido);
					escolhido.set_Jogador(atual);
					escolhido.add_exercito(1);
					valor++;
					break;
				}
			}
			this.next_jogador();
		}
		for(Jogador jogadores : jogadores_ativos) {
			System.out.println(jogadores.domina.size());
		}
	}
	
	public void get_vez_jogador_territorios() {
		jogadores_ativos.get(this.vez).show_all_terr();
	}
	
	public boolean verifica_vez_jogador_objetivo() {
		return jogadores_ativos.get(this.vez).get_objetivo().verifica_status();
	}
	
	public void sorteia_obj_todos_jogadores(List<Jogador> jogadores_ativos,DeckObjetivos deckobj) {
		Collections.shuffle(jogadores_ativos);
		for(Jogador el : jogadores_ativos) {
			deckobj.sorteia_objetivo(el);
			System.out.printf("O objetivo do jogador %s é %s.\n",el.get_nome(),el.get_objetivo().getClass());
		}
	}
	
	protected List<Regiao> inicializa_mundo(){
		List<Regiao> mundo = new ArrayList<Regiao>();
		mundo.add(new Asia());
		mundo.add(new Europa());
		mundo.add(new Oceania());
		mundo.add(new AmericadoSul());
		mundo.add(new AmericadoNorte());
		mundo.add(new Africa());
		return mundo;
	}
	
	public String get_vez_jogador_color() {
		return jogadores_ativos.get(this.vez).get_cor();
	}
	
	public int get_vez_jogador_exercitos_reg() {
		Jogador jogador_da_vez = jogadores_ativos.get(this.vez);
		int qtd_total = 0;
		for(Regiao regiao : mapa_mundo) {
			qtd_total += jogador_da_vez.get__exercito_regiao(regiao.get_nome());
		}
		
		return qtd_total;
	}
	
	public int get_exercito_terr(String terra) {
		for(Regiao reg: mapa_mundo) {
			for(Territorio terr: reg.get_paises()) {
				if(terr.get_nome() == terra) {
					return terr.get_exercitos();
				}
			}
		}
		return -1;
	}
	
	public int get_vez_jogador_exercitos_distri() {
		Jogador jogador_da_vez = jogadores_ativos.get(this.vez);
		System.out.println("Qtd depois " + jogador_da_vez.get_exercito());
		return jogador_da_vez.get_exercito();
	}
	
	public int get_vez_jogador_exerc_reg(String pais) {
		Jogador jogador_da_vez = jogadores_ativos.get(this.vez);
		String regiao = jogador_da_vez.get_terr_reg(pais);
		return jogador_da_vez.get__exercito_regiao(regiao);
	}
	
	public boolean posiciona_exercitos_jogador_vez(int qtd,String terr) {
		return jogadores_ativos.get(this.vez).posiciona_exercito(qtd, terr);
	}
	
	public boolean posiciona_exercitos_reg_jogador_vez(int qtd,String terr) {
		Jogador jogador_da_vez = jogadores_ativos.get(this.vez);
		return jogador_da_vez.posiciona_exercito_regiao(jogador_da_vez.get_terr_reg(terr),terr,qtd);
	}
	
	public List<String> get_vez_jogador_cartas() {
		List<CartaConquista> cartas =  jogadores_ativos.get(this.vez).get_carta();
		List<String> cartas_jogador = new ArrayList<>();
		for(CartaConquista el : cartas) {
			cartas_jogador.add(el.get_pais());
		}
		return cartas_jogador;
	}
	
	public void get_vez_jogador_add_exercito() {
		Jogador jogador_da_vez = jogadores_ativos.get(this.vez);
		jogador_da_vez.set_exercito(0);
		jogador_da_vez.add_exercito();
		for(Regiao regiao : mapa_mundo) {
			if(regiao.verifica_monopolio(jogador_da_vez)) {
				jogador_da_vez.add_exercito_regiao(regiao.get_nome(),regiao.get_exercito_extra());
			}
		}
	}
	
	public boolean verifica_exercito_regiao_distribuir() {
		Jogador jogador_da_vez = jogadores_ativos.get(this.vez);
		for(Regiao regiao : mapa_mundo) {
			if(jogador_da_vez.get__exercito_regiao(regiao.get_nome())> 0) {
				return true;
			}
		}
		return false;
	}
	
	public void next_jogador() {
		this.vez++;
		if(this.vez >= this.jogadores_ativos.size())this.vez = 0;
		while(jogadores_ativos.get(this.vez).verifica_destruido()) {
			this.vez++;
			if(this.vez >= this.jogadores_ativos.size())this.vez = 0;
			
		}
		
		
	}
	
	public boolean verifica_next_rodada() {
		int value = (51%this.jogadores_ativos.size())-1;
		if(value < 0) {
			value = this.jogadores_ativos.size() -1;
		}
		if(this.vez == value) {
			return true;
		}
		return false;
	}
	
	public boolean verifica_territorio_jogador(String pais) {
		Jogador jogador_da_vez = jogadores_ativos.get(this.vez);
		return jogador_da_vez.verifica_territorio(pais);
	}
	public boolean verifica_territorio_jogador_reg(String pais) {
		return jogadores_ativos.get(this.vez).verifica_territorio_reg(pais);
	}
	public boolean verifica_territorio_jogador_fronteira(String terr, String fronteira) {
		Jogador jogador_da_vez = jogadores_ativos.get(this.vez);
		return jogador_da_vez.verifica_territorio_fronteira(terr, fronteira);
	}

	public int[] qtd_vence_derrota() {
		boolean[] arrayBoolean = this.confere_vencedor();
		int vet[] = new int[2];
		int vitorias = 0;
		int derrotas = 0;
        for (boolean valor : arrayBoolean) {
            if(valor) {
            	vitorias++;
            } else {
            	derrotas++;
            }
        }
        vet[0] = vitorias;
        vet[1] = derrotas;
        return vet;
	}
	public Territorio get_terr(String terra) {
		for(Regiao reg: mapa_mundo) {
			for(Territorio terr: reg.get_paises()) {
				if(terr.get_nome() == terra) {
					return terr;
				}
			}
		}
		return null;
	}
	
	public void baixas_da_defesa(String terra,int qtd) {
		Territorio atacado = this.get_terr(terra);
		atacado.add_exercito(qtd);
	}
	
	public void finaliza_conquista(String terra_conquistado,String terra_conquistador,int qtd) {
		Territorio conquistado = this.get_terr(terra_conquistado);
		Jogador jogador_da_vez = jogadores_ativos.get(this.vez);
		conquistado.conquista(jogador_da_vez, qtd);
		Territorio conquistador = this.get_terr(terra_conquistador);
		conquistador.add_exercito(-qtd);
	}
	
	public void conquistou_terr(String terra) {
		Territorio conquistado = this.get_terr(terra);
		Jogador perdeu_terra = conquistado.get_Jogador();
		Jogador jogador_da_vez = jogadores_ativos.get(this.vez);
		perdeu_terra.perde_territorio(conquistado);
		if( perdeu_terra.qtd_territorios() == 0) {
			perdeu_terra.jogador_destruido(jogador_da_vez);
		}
		jogador_da_vez.ganha_territorio(conquistado);
	}
	
	public boolean[] confere_vencedor() {
		List<Integer> ataque = new ArrayList<>((List<Integer>)dado.get('a'));
		List<Integer> defesa = new ArrayList<>((List<Integer>)dado.get('d'));
		boolean[] batalhas = new boolean [(defesa.size() > ataque.size()) ? ataque.size() : defesa.size()];
		int batalha=0;
		while(defesa.size()!=0 && ataque.size()!=0) {
			int maioratk=0;
			int maiordef=0;
			for(int i=0;i<ataque.size(); i++) {
				 if(ataque.get(maioratk)<ataque.get(i)) {
					 maioratk=i;
				 }
			}
			for(int i=0;i<defesa.size(); i++) {
				 if(defesa.get(maiordef)<defesa.get(i)) {
					 maiordef=i;
				 }
			}
			if(ataque.get(maioratk)>defesa.get(maiordef)) {
				batalhas[batalha]=true;
			}
			else{
				batalhas[batalha]=false;
			}
			batalha++;
			ataque.remove(maioratk);
			defesa.remove(maiordef);
		}
		return batalhas;
	}
	public int get_qtd_exercito_atq(String terra) {
		for(Regiao reg: mapa_mundo) {
			for(Territorio terr: reg.get_paises()) {
				if(terr.get_nome() == terra) {
					if(terr.get_exercitos() > 3) {
						return 3;
					} else {
						return terr.get_exercitos()-1;
					}
				}
			}
		}
		return -1;
	}
	public int get_qtd_exercito_def(String terra) {
		for(Regiao reg: mapa_mundo) {
			for(Territorio terr: reg.get_paises()) {
				if(terr.get_nome() == terra) {
					if(terr.get_exercitos() > 2) {
						return 3;
					} else {
						return terr.get_exercitos();
					}
				}
			}
		}
		return -1;
	}
	public void add_dado_view(Observador view_do_dado) {
		this.dado.add(view_do_dado);
	}
	public void ataque(int qtd_ataque,int qtd_defesa) {
		this.dado.set_jogador(jogadores_ativos.get(this.vez));
		this.dado.lanca_dado(qtd_defesa,qtd_ataque);
	}
	public void save_territorios() {
		List<Integer> qtd = new ArrayList<>();
		Jogador jogador_da_vez = jogadores_ativos.get(this.vez);
		List<Territorio> terras = jogador_da_vez.get_list_terr();
		for(Territorio terra : terras) {
			qtd.add(terra.get_exercitos());
		}
		System.out.println(terras.size() + " " + qtd.size());
		this.reposicionamento = qtd;
	}
	public int get_max_exerc(String pais) {
		Jogador jogador_da_vez = jogadores_ativos.get(this.vez);
		List<Territorio> terras = jogador_da_vez.get_list_terr();
		int i = 0;
		System.out.println(terras.size() + " " + reposicionamento.size());
		for(Territorio terra : terras) {
			if(terra.get_nome() == pais) {
				return this.reposicionamento.get(i);
			}
			i++;
		}
		return 0;
	}
	public void realocate_exerc(int qtd,String de,String para) {
		Jogador jogador_da_vez = jogadores_ativos.get(this.vez);
		List<Territorio> terras = jogador_da_vez.get_list_terr();
		int i = 0;
		for(Territorio terra : terras) {
			if(terra.get_nome() == de) {
				int rep= this.reposicionamento.get(i);
				rep = rep - qtd;
				terra.add_exercito(-qtd);
			}
			if(terra.get_nome() == para) {
				terra.add_exercito(qtd);
			}
			i++;
		}
	}
}



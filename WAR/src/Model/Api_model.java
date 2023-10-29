package Model;

import java.util.*;
import View.Api_view;

public class Api_model {

	public static void main(String[] args) {
		//cria mapa
		List<Regiao> mapa_mundo = Api_model.inicializa_mundo();
		//cria jogadores
		List<Jogador> jogadores_ativos = Api_model.inicializa_jogadores();
		
		DeckObjetivos deckobj = new DeckObjetivos(mapa_mundo,jogadores_ativos);
		//embaralha a ordem dos jogadores, que vai ser também a ordem de jogada
		Collections.shuffle(jogadores_ativos);
		//sorteia os objetivos para cada jogador
		sorteia_obj_todos_jogadores(jogadores_ativos,deckobj);
		for(Jogador jogadores : jogadores_ativos) {
			System.out.printf("O objetivo do jogador %s é %s.\n",jogadores.get_nome(),jogadores.get_objetivo().getClass());
		}
		//sorteio de todas os territorios para os jogadores
		sorteia_todos_territorios(mapa_mundo,jogadores_ativos);
		for(Jogador jogadores : jogadores_ativos) {
			System.out.println(jogadores.domina.size());
		}
		Api_model.confere_vencedor(new ArrayList<Integer>(Arrays.asList(2,2,3)), new ArrayList<>(Arrays.asList(2,3)));
	}
	
	protected static void sorteia_todos_territorios(List<Regiao> mapa_mundo, List<Jogador> jogadores_ativos) {
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
		}
	}
	
	protected static void sorteia_obj_todos_jogadores(List<Jogador> jogadores_ativos,DeckObjetivos deckobj) {
		for(Jogador el : jogadores_ativos) {
			deckobj.sorteia_objetivo(el);
		}
	}
	
	protected static List<Regiao> inicializa_mundo(){
		List<Regiao> mundo = new ArrayList<Regiao>();
		mundo.add(new Asia());
		mundo.add(new Europa());
		mundo.add(new Oceania());
		mundo.add(new AmericadoSul());
		mundo.add(new AmericadoNorte());
		mundo.add(new Africa());
		return mundo;
	}
	protected static List<Jogador> inicializa_jogadores(){
		List<Jogador> jogadores = new ArrayList<Jogador>();
		Scanner scan = new Scanner(System.in);
		System.out.println("Bem vindo ao War! Quantos jogadores vão jogar? (entre 3 e 6)");
		int num_jogadores = 0;
        num_jogadores = scan.nextInt();
        scan.nextLine();
        while (num_jogadores < 3 || num_jogadores > 6) {
        	System.out.println("Número inválido. Digite novamente.");
            num_jogadores = scan.nextInt();
            scan.nextLine();
        }
        String nome_jogador;
        List<String> cores = new ArrayList<>(Arrays.asList("azul", "vermelho", "verde", "amarelo", "preto", "branco"));
        String cor_input=null;
        for(int i=0; i<num_jogadores; i++) {
        	System.out.printf("Qual o nome do jogador %d?\n",i);
        	nome_jogador = scan.nextLine();
        	while(!Cor.existe_cor(cor_input,cores)) {
        		System.out.println("Qual a cor que você quer jogar?");
            	cor_input = scan.nextLine();
            	if(Cor.existe_cor(cor_input,cores)) {
            		jogadores.add(new Jogador(nome_jogador, cor_input));
            		break;
            	}
            	else {
            		System.out.println("Essa cor não pode ser usada, tente novamente");
            	}
        	}
        	
        }
        scan.close();
        return jogadores;
	}
	
	
	protected static boolean[] confere_vencedor(List<Integer> ataque, List<Integer> defesa) {
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
			System.out.println(batalhas[batalha]);
			batalha++;
			ataque.remove(maioratk);
			defesa.remove(maiordef);
		}
		return batalhas;
	}
	public static void ataque() {
		//mock
		Jogador jgd_atual = new Jogador("roberto","vermelho");
		Observador view_do_dado = Api_view.Instancia_Observador("DadoView");
		DadoModel dado= new DadoModel();
		dado.add(view_do_dado);
		dado.set_jogador(jgd_atual);
		dado.lanca_dado(2,3);
	}
}



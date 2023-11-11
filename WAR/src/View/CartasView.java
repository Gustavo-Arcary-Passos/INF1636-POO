package View;

import java.awt.Graphics;
import java.util.List;

class CartasView {
	public static CartaInfo[] images;
	private static int count_cartas;

	public static CartaInfo[] cartas_na_tela;
	private static int count_cartas_na_tela;
	static {
		images = new CartaInfo[80];
		cartas_na_tela = new CartaInfo[5];
		//Africa
		add_cartaconquista(new CartaInfo("war_carta_af_africadosul.png", 132, 218,"África do Sul"));
		add_cartaconquista(new CartaInfo("war_carta_af_angola.png",132,218,"Angola"));
		add_cartaconquista(new CartaInfo("war_carta_af_argelia.png",132,218,"Argélia"));
		add_cartaconquista(new CartaInfo("war_carta_af_egito.png",132,218,"Egito"));
		add_cartaconquista(new CartaInfo("war_carta_af_nigeria.png",132,218,"Nigéria"));
		add_cartaconquista(new CartaInfo("war_carta_af_somalia.png",132,218,"Somália"));
		//America do norte
		add_cartaconquista(new CartaInfo("war_carta_an_alasca.png",132,218,"Alasca"));
		add_cartaconquista(new CartaInfo("war_carta_an_calgary.png",132,218,"Calgary"));
		add_cartaconquista(new CartaInfo("war_carta_an_california.png",132,218,"Califórnia"));
		add_cartaconquista(new CartaInfo("war_carta_an_groelandia.png",132,218,"Groenlândia"));
		add_cartaconquista(new CartaInfo("war_carta_an_mexico.png",132,218,"México"));
		add_cartaconquista(new CartaInfo("war_carta_an_novayork.png",132,218,"Nova York"));
		add_cartaconquista(new CartaInfo("war_carta_an_quebec.png",132,218,"Quebec"));
		add_cartaconquista(new CartaInfo("war_carta_an_texas.png",132,218,"Texas"));
		add_cartaconquista(new CartaInfo("war_carta_an_vancouver.png",132,218,"Vancouver"));
		//Asia
		add_cartaconquista(new CartaInfo("war_carta_as_arabiasaudita.png",132,218,"Arábia Saudita"));
		add_cartaconquista(new CartaInfo("war_carta_as_bangladesh.png",132,218,"Bangladesh"));
		add_cartaconquista(new CartaInfo("war_carta_as_cazaquistao.png",132,218,"Cazaquistão"));
		add_cartaconquista(new CartaInfo("war_carta_as_china.png",132,218,"China"));
		add_cartaconquista(new CartaInfo("war_carta_as_coreiadonorte.png",132,218,"Coreia do Norte"));
		add_cartaconquista(new CartaInfo("war_carta_as_coreiadosul.png",132,218,"Coreia do Sul"));
		add_cartaconquista(new CartaInfo("war_carta_as_estonia.png",132,218,"Estônia"));
		add_cartaconquista(new CartaInfo("war_carta_as_india.png",132,218,"Índia"));
		add_cartaconquista(new CartaInfo("war_carta_as_ira.png",132,218,"Irã"));
		add_cartaconquista(new CartaInfo("war_carta_as_iraque.png",132,218,"Iraque"));
		add_cartaconquista(new CartaInfo("war_carta_as_japao.png",132,218,"Japão"));
		add_cartaconquista(new CartaInfo("war_carta_as_jordania.png",132,218,"Jordânia"));
		add_cartaconquista(new CartaInfo("war_carta_as_letonia.png",132,218,"Letônia"));
		add_cartaconquista(new CartaInfo("war_carta_as_mongolia.png",132,218,"Mongólia"));
		add_cartaconquista(new CartaInfo("war_carta_as_paquistao.png",132,218,"Paquistão"));
		add_cartaconquista(new CartaInfo("war_carta_as_russia.png",132,218,"Rússia"));
		add_cartaconquista(new CartaInfo("war_carta_as_siberia.png",132,218,"Sibéria"));
		add_cartaconquista(new CartaInfo("war_carta_as_siria.png",132,218,"Síria"));
		add_cartaconquista(new CartaInfo("war_carta_as_tailandia.png",132,218,"Tailândia"));
		add_cartaconquista(new CartaInfo("war_carta_as_turquia.png",132,218,"Turquia"));
		//america do sul
		add_cartaconquista(new CartaInfo("war_carta_asl_argentina.png",132,218,"Argentina"));
		add_cartaconquista(new CartaInfo("war_carta_asl_brasil.png",132,218,"Brasil"));
		add_cartaconquista(new CartaInfo("war_carta_asl_peru.png",132,218,"Peru"));
		add_cartaconquista(new CartaInfo("war_carta_asl_venezuela.png",132,218,"Venezuela"));
		//curingas
		add_cartaconquista(new CartaInfo("war_carta_coringa.png",132,218,"Curinga"));
		add_cartaconquista(new CartaInfo("war_carta_coringa.png",132,218,"Curinga"));
		//Europa
		add_cartaconquista(new CartaInfo("war_carta_eu_espanha.png",132,218,"Espanha"));
		add_cartaconquista(new CartaInfo("war_carta_eu_franca.png",132,218,"França"));
		add_cartaconquista(new CartaInfo("war_carta_eu_italia.png",132,218,"Itália"));
		add_cartaconquista(new CartaInfo("war_carta_eu_polonia.png",132,218,"Polônia"));
		add_cartaconquista(new CartaInfo("war_carta_eu_reinounido.png",132,218,"Reino Unido"));
		add_cartaconquista(new CartaInfo("war_carta_eu_suecia.png",132,218,"Suécia"));
		add_cartaconquista(new CartaInfo("war_carta_eu_ucrania.png",132,218,"Ucrânia"));
		add_cartaconquista(new CartaInfo("war_carta_eu_romenia.png",132,218,"Romênia"));
		//Oceania
		add_cartaconquista(new CartaInfo("war_carta_oc_australia.png",132,218,"Austrália"));
		add_cartaconquista(new CartaInfo("war_carta_oc_indonesia.png",132,218,"Indonésia"));
		add_cartaconquista(new CartaInfo("war_carta_oc_novazelandia.png",132,218,"Nova Zelândia"));
		add_cartaconquista(new CartaInfo("war_carta_oc_perth.png",132,218,"Perth"));
		//Costas
		add_cartaconquista(new CartaInfo("war_carta_verso.png", 132, 218,"Verso"));
		//Curinga
		add_cartaconquista(new CartaInfo("war_carta_verso.png", 132, 218,"Curinga"));
		//Objetivos
		add_cartaconquista(new CartaInfo("obj_01.jpg",147,226,"Objetivo 1"));
		add_cartaconquista(new CartaInfo("obj_02.jpg",147,226,"Objetivo 2"));
		add_cartaconquista(new CartaInfo("obj_03.jpg",147,226,"Objetivo 3"));
		add_cartaconquista(new CartaInfo("obj_04.jpg",147,226,"Objetivo 4"));
		add_cartaconquista(new CartaInfo("obj_05.jpg",147,226,"Objetivo 5"));
		add_cartaconquista(new CartaInfo("obj_06.jpg",147,226,"Objetivo 6"));
		add_cartaconquista(new CartaInfo("obj_07.jpg",147,226,"Objetivo 7"));
		add_cartaconquista(new CartaInfo("obj_08.jpg",147,226,"Objetivo 8"));
		add_cartaconquista(new CartaInfo("obj_09.jpg",147,226,"Objetivo 9"));
		add_cartaconquista(new CartaInfo("obj_10.jpg",147,226,"Objetivo 10"));
		add_cartaconquista(new CartaInfo("obj_11.jpg",147,226,"Objetivo 11"));
		add_cartaconquista(new CartaInfo("obj_12.jpg",147,226,"Objetivo 12"));
		add_cartaconquista(new CartaInfo("obj_13.jpg",147,226,"Objetivo 13"));
		add_cartaconquista(new CartaInfo("obj_14.jpg",147,226,"Objetivo 14"));
	}
	
	public static CartaInfo get_carta(String carta) {
		for(int i = 0; i < count_cartas; i++) {
			if(carta == images[i].get_name()) {
				return images[i];
			}
		}
		return null;
	}
	
	private static void add_cartaconquista(CartaInfo img) {
		count_cartas++;
		images[count_cartas-1]=img;
	}


	/**
	 * Registra que uma carta esta na tela em exibicao
	 * @param img
	 */
	public static void add_carta_na_tela(CartaInfo img) {
		count_cartas_na_tela++;
		cartas_na_tela[count_cartas_na_tela-1]=img;
	}


	/**
	 * Remove uma carta da lista da tela
	 * - vamos usar para remover as cartas que foram trocadas, talvez
	 * @param img
	 */
	public static void remove_carta_na_tela(CartaInfo img) {
		for(int i = 0; i < count_cartas_na_tela; i++) {
			if(img == cartas_na_tela[i]) {
				cartas_na_tela[i] = null;
				count_cartas_na_tela--;
				break;
			}
		}
	}

	public static void remove_carta_na_tela(int i) {
		cartas_na_tela[i] = null;
		count_cartas_na_tela--;
	}

	public static void remove_carta_na_tela(String carta) {
		for(int i = 0; i < count_cartas_na_tela; i++) {
			if(carta == cartas_na_tela[i].get_name()) {
				cartas_na_tela[i] = null;
				count_cartas_na_tela--;
				break;
			}
		}
	}

	// Limpa a lista de cartas na tela, para nao misturar entre jogadores
	public static void clear_cartas_na_tela() {
		for(int i = 0; i < count_cartas_na_tela; i++) {
			cartas_na_tela[i] = null;
		}
		count_cartas_na_tela = 0;
	}

	// Retorna a carta clicada, ou -1 se nenhuma carta foi clicada
	public static int get_carta_clicada(int x, int y) {
		for(int i = 0; i < count_cartas_na_tela; i++) {
			if(cartas_na_tela[i].coord_inbounds(x, y)) {
				return i;
			}
		}
		return -1;
	}


}

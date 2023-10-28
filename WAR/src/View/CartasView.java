package View;

import java.awt.Graphics;

class CartasView {
	public CartaInfo[] images;
	private int count_cartas;
	public CartasView() {
		images = new CartaInfo[60];
		//Africa
		add_cartaconquista(new CartaInfo("war_carta_af_africadosul.png", 132, 218));
		add_cartaconquista(new CartaInfo("war_carta_af_angola.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_af_argelia.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_af_egito.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_af_nigeria.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_af_somalia.png",132,218));
		//America do norte
		add_cartaconquista(new CartaInfo("war_carta_an_alasca.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_an_calgary.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_an_california.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_an_groelandia.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_an_mexico.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_an_novayork.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_an_quebec.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_an_texas.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_an_vancouver.png",132,218));
		//Asia
		add_cartaconquista(new CartaInfo("war_carta_as_arabiasaudita.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_as_bangladesh.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_as_cazaquistao.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_as_china.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_as_coreiadonorte.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_as_coreiadosul.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_as_estonia.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_as_india.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_as_ira.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_as_iraque.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_as_japao.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_as_jordania.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_as_letonia.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_as_mongolia.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_as_paquistao.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_as_russia.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_as_siberia.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_as_siria.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_as_tailandia.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_as_turquia.png",132,218));
		//america do sul
		add_cartaconquista(new CartaInfo("war_carta_asl_argentina.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_asl_brasil.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_asl_peru.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_asl_venezuela.png",132,218));
		//curingas
		add_cartaconquista(new CartaInfo("war_carta_coringa.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_coringa.png",132,218));
		//Europa
		add_cartaconquista(new CartaInfo("war_carta_eu_espanha.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_eu_franca.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_eu_italia.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_eu_polonia.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_eu_reinounido.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_eu_suecia.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_eu_ucrania.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_eu_romenia.png",132,218));
		//Oceania
		add_cartaconquista(new CartaInfo("war_carta_oc_australia.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_oc_indonesia.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_oc_novazelandia.png",132,218));
		add_cartaconquista(new CartaInfo("war_carta_oc_perth.png",132,218));
		
	}
	
	private void add_cartaconquista(CartaInfo img) {
		count_cartas++;
		images[count_cartas-1]=img;
	}


	public void desenha_objetivo(Graphics g, Objetivo obj) {
		switch(obj) {
			case DESTRUIR_VERMELHOS:
				images[0].desenha(g);
				break;
			case DESTRUIR_AMARELOS:
				images[1].desenha(g);
				break;
			case DESTRUIR_VERDES:
				images[2].desenha(g);
				break;
			case DESTRUIR_AZUIS:
				images[3].desenha(g);
				break;
			case DESTRUIR_PRETOS:
				images[4].desenha(g);
				break;
			case DESTRUIR_BRANCOS:
				images[5].desenha(g);
				break;
		}
	}

	public void some(Graphics g) 
	{
		
		images[0].apaga(g);
	}
}

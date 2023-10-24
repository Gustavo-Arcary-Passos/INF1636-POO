package View;

class CartasView {
	public ImagemInfo[] images;
	private int count_cartas;
	public CartasView() {
		images = new ImagemInfo[60];
		//Africa
		add_cartaconquista(new ImagemInfo("war_carta_af_africadosul.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_af_angola.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_af_argelia.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_af_egito.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_af_nigeria.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_af_somalia.png",0,0,132,218));
		//America do norte
		add_cartaconquista(new ImagemInfo("war_carta_an_alasca.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_an_calgary.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_an_california.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_an_groelandia.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_an_mexico.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_an_novayork.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_an_quebec.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_an_texas.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_an_vancouver.png",0,0,132,218));
		//Asia
		add_cartaconquista(new ImagemInfo("war_carta_as_arabiasaudita.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_as_bangladesh.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_as_cazaquistao.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_as_china.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_as_coreiadonorte.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_as_coreiadosul.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_as_estonia.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_as_india.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_as_ira.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_as_iraque.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_as_japao.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_as_jordania.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_as_letonia.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_as_mongolia.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_as_paquistao.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_as_russia.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_as_siberia.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_as_siria.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_as_tailandia.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_as_turquia.png",0,0,132,218));
		//america do sul
		add_cartaconquista(new ImagemInfo("war_carta_asl_argentina.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_asl_brasil.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_asl_peru.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_asl_venezuela.png",0,0,132,218));
		//curingas
		add_cartaconquista(new ImagemInfo("war_carta_coringa.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_coringa.png",0,0,132,218));
		//Europa
		add_cartaconquista(new ImagemInfo("war_carta_eu_espanha.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_eu_franca.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_eu_italia.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_eu_polonia.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_eu_reinounido.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_eu_suecia.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_eu_ucrania.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_eu_romenia.png",0,0,132,218));
		//Oceania
		add_cartaconquista(new ImagemInfo("war_carta_oc_australia.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_oc_indonesia.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_oc_novazelandia.png",0,0,132,218));
		add_cartaconquista(new ImagemInfo("war_carta_oc_perth.png",0,0,132,218));
		
	}
	
	private void add_cartaconquista(ImagemInfo img) {
		count_cartas++;
		images[count_cartas-1]=img;
	}
}

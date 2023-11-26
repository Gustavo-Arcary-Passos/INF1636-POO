package Model;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.*;

public class TesteDeckObjetivos {
	
	@Test
	public void teste_objetivo_1_6()
	{
		List<Jogador> jogadores = new ArrayList<Jogador>();
		jogadores.add(new Jogador("Jogador", "azul"));
		jogadores.add(new Jogador("Jogador1","verde")) ;
		Api_model model = new Api_model();
		List<Regiao> mapa = model.inicializa_mundo();
		DeckObjetivos obj = new DeckObjetivos(mapa,jogadores);
		jogadores.get(0).recebe_objetivo(obj.get_objetivo(4));
		jogadores.get(1).jogador_destruido(jogadores.get(0));
		assertTrue(jogadores.get(0).get_objetivo().verifica_status());
		
	}
	
	@Test
	public void teste_objetivo_7_12()
	{
		List<Jogador> jogadores = new ArrayList<Jogador>();
		jogadores.add(new Jogador("Jogador", "azul"));
		Api_model model = new Api_model();
		jogadores.get(0).recebe_objetivo(model.get_deck_obj().get_objetivo(7));
		assertFalse(jogadores.get(0).get_objetivo().verifica_status());
		for(Regiao reg : model.get_mapa_mundo()) {
			if(reg.get_nome().equals("América do Norte") || reg.get_nome().equals("África")) {
				for(Territorio terr : reg.get_paises()) {
					terr.set_Jogador(jogadores.get(0));
				}
			}
		}
		assertTrue(jogadores.get(0).get_objetivo().verifica_status());
		
	}
	
	@Test
	public void teste_objetivo_13()
	{
		List<Jogador> jogadores = new ArrayList<Jogador>();
		jogadores.add(new Jogador("Jogador", "azul"));
		Api_model model = new Api_model();
		jogadores.get(0).recebe_objetivo(model.get_deck_obj().get_objetivo(13));
		assertFalse(jogadores.get(0).get_objetivo().verifica_status());
		for(Regiao reg : model.get_mapa_mundo()) {
			if(reg.get_nome().equals("Ásia")) {
				for(Territorio terr : reg.get_paises()) {
					jogadores.get(0).ganha_territorio(terr);
					terr.add_exercito(2);
				}
			}
		}
		assertTrue(jogadores.get(0).get_objetivo().verifica_status());
		
	}
	
	@Test
	public void teste_objetivo_14()
	{
		List<Jogador> jogadores = new ArrayList<Jogador>();
		jogadores.add(new Jogador("Jogador", "azul"));
		Api_model model = new Api_model();
		jogadores.get(0).recebe_objetivo(model.get_deck_obj().get_objetivo(13));
		assertFalse(jogadores.get(0).get_objetivo().verifica_status());
		for(Regiao reg : model.get_mapa_mundo()) {
			if(reg.get_nome().equals("Ásia") || reg.get_nome().equals("África")) {
				for(Territorio terr : reg.get_paises()) {
					jogadores.get(0).ganha_territorio(terr);
					terr.add_exercito(2);
				}
			}
		}
		assertTrue(jogadores.get(0).get_objetivo().verifica_status());
		
	}
}

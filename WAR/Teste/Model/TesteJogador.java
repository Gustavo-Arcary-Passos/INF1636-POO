package Model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class TesteJogador {

	@Test
	public void teste_construtor()
	{
		Jogador jogador = new Jogador("Jogador", "Azul");
		assertEquals("Jogador", jogador.get_nome());
		assertEquals("Azul", jogador.get_cor());
	}

	@Test
	public void teste_conquista_territorio()
	{
		Jogador jogador = new Jogador("Jogador", "Azul");
		Jogador jogador2 = new Jogador("Joel Lambretinha", "Preto");
		Territorio BrasilTeste = new Territorio("Brasil", "América do Sul", new ArrayList<>(Arrays.asList("Argentina", "Peru", "Venezuela", "Nigéria")));
		BrasilTeste.set_Jogador(jogador);
		jogador.ganha_territorio(BrasilTeste);
		assertEquals(jogador.qtd_territorios(),1);
		assertEquals(jogador2.qtd_territorios(),0);
		jogador.perde_territorio(BrasilTeste);
		BrasilTeste.set_Jogador(jogador2);
		jogador2.ganha_territorio(BrasilTeste);
		assertEquals(jogador.qtd_territorios(),0);
		assertEquals(jogador2.qtd_territorios(),1);
	}
	
	@Test
	public void teste_troca_cartas_exercito()
	{
		ConjuntoCartaConquista deck = new ConjuntoCartaConquista();
		Jogador jogador = new Jogador("Jogador", "Azul");
		jogador.conquistou_na_rodada();
		deck.tira_uma_carta(jogador);
		jogador.conquistou_na_rodada();
		deck.tira_uma_carta(jogador);
		jogador.conquistou_na_rodada();
		deck.tira_uma_carta(jogador);
		jogador.conquistou_na_rodada();
		deck.tira_uma_carta(jogador);
		jogador.conquistou_na_rodada();
		deck.tira_uma_carta(jogador);
		List<CartaConquista> cartas = new ArrayList<CartaConquista>();
		cartas.add(jogador.cartaTroca.get(0));
		cartas.add(jogador.cartaTroca.get(1));
		cartas.add(jogador.cartaTroca.get(2));
		if(deck.verifica_troca(cartas)) {
			jogador.troca_cartas_exercitos(0,1,2,deck);
			assertEquals(jogador.get_exercito(),4);
		}else {
			assertEquals(jogador.get_exercito(),0);
		}
	}
	
	@Test
	public void teste_ganha_exercito_inicio_rodada()
	{
		Jogador jogador = new Jogador("Jogador", "Azul");
		Territorio Mexico = new Territorio("México", "América do Norte", new ArrayList<>(Arrays.asList("Venezuela", "Califórnia", "Texas")));
		Territorio California = new Territorio("Califórnia", "América do Norte", new ArrayList<>(Arrays.asList("Vancouver", "Texas", "México")));
		Territorio Texas = new Territorio("Texas", "América do Norte", new ArrayList<>(Arrays.asList("México", "Califórnia", "Vancouver", "Nova York", "Quebec")));
		Territorio Quebec = new Territorio("Quebec", "América do Norte", new ArrayList<>(Arrays.asList("Nova York", "Texas", "Vancouver", "Groenlândia")));
		jogador.ganha_territorio(Quebec);
		jogador.ganha_territorio(Texas);
		jogador.ganha_territorio(California);
		jogador.ganha_territorio(Mexico);
		jogador.add_exercito();
		assertEquals(jogador.get_exercito(),2);
		Territorio Nova_York = new Territorio("Nova York", "América do Norte", new ArrayList<>(Arrays.asList("Texas", "Quebec")));
		jogador.ganha_territorio(Nova_York);
		jogador.add_exercito();
		assertEquals(jogador.get_exercito(),4);
	}
	
	@Test
	public void teste_posiciona_exercito()
	{
		Jogador jogador = new Jogador("Jogador", "Azul");
		Territorio Mexico = new Territorio("México", "América do Norte", new ArrayList<>(Arrays.asList("Venezuela", "Califórnia", "Texas")));
		Territorio California = new Territorio("Califórnia", "América do Norte", new ArrayList<>(Arrays.asList("Vancouver", "Texas", "México")));
		Territorio Texas = new Territorio("Texas", "América do Norte", new ArrayList<>(Arrays.asList("México", "Califórnia", "Vancouver", "Nova York", "Quebec")));
		Territorio Quebec = new Territorio("Quebec", "América do Norte", new ArrayList<>(Arrays.asList("Nova York", "Texas", "Vancouver", "Groenlândia")));
		jogador.ganha_territorio(Quebec);
		jogador.ganha_territorio(Texas);
		jogador.ganha_territorio(California);
		jogador.ganha_territorio(Mexico);
		jogador.add_exercito();
		assertTrue(jogador.posiciona_exercito(2, Mexico));
		assertEquals(Mexico.get_exercitos(),2);
	}
	
	@Test
	public void teste_monopolio()
	{
		Jogador jogador = new Jogador("Jogador","Azul");
		Jogador jogador2 = new Jogador("Joel Lambretinha", "Preto");
		AmericadoSul amesul = new AmericadoSul();
		jogador.ganha_territorio(amesul.get_territorio("Brasil"));
		jogador.ganha_territorio(amesul.get_territorio("Argentina"));
		jogador.ganha_territorio(amesul.get_territorio("Peru"));
		jogador.ganha_territorio(amesul.get_territorio("Venezuela"));
		assertTrue(amesul.verifica_monopolio(jogador));
		assertFalse(amesul.verifica_monopolio(jogador2));
		jogador.add_exercito_regiao("América do Sul",amesul.get_exercito_extra());
		assertEquals(jogador.get__exercito_regiao("América do Sul"),3);
		assertTrue(jogador.posiciona_exercito_regiao("América do Sul","Brasil",2));
		assertTrue(jogador.posiciona_exercito_regiao("América do Sul","Argentina",1));
		assertEquals(jogador.get__exercito_regiao("América do Sul"),0);
	}
}

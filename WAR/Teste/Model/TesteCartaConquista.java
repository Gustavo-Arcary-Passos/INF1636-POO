package Model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TesteCartaConquista {
	@Test
	public void teste_verifica_troca_cartas()
	{
		ConjuntoCartaConquista deck = new ConjuntoCartaConquista();
		List<CartaConquista> cartas = new ArrayList<CartaConquista>();
		cartas.add(new CartaTriangulo("Brasil"));
		cartas.add(new CartaTriangulo("Argentina"));
		cartas.add(new CartaTriangulo("Peru"));
		assertTrue(deck.verifica_troca(cartas));
		cartas.remove(cartas.get(0));
		cartas.remove(cartas.get(0));
		cartas.remove(cartas.get(0));
		cartas.add(new CartaCirculo("Venezuela"));
		cartas.add(new CartaTriangulo("Peru"));
		cartas.add(new CartaQuadrado("Texas"));
		assertTrue(deck.verifica_troca(cartas));
		cartas.remove(cartas.get(0));
		cartas.remove(cartas.get(0));
		cartas.remove(cartas.get(0));
		cartas.add(new CartaCuringa());
		cartas.add(new CartaCuringa());
		cartas.add(new CartaQuadrado("Texas"));
		assertTrue(deck.verifica_troca(cartas));
		cartas.remove(cartas.get(0));
		cartas.remove(cartas.get(0));
		cartas.remove(cartas.get(0));
		cartas.add(new CartaCuringa());
		cartas.add(new CartaTriangulo("Peru"));
		cartas.add(new CartaQuadrado("Texas"));
		assertTrue(deck.verifica_troca(cartas));
		cartas.remove(cartas.get(0));
		cartas.remove(cartas.get(0));
		cartas.remove(cartas.get(0));
		cartas.add(new CartaCuringa());
		cartas.add(new CartaQuadrado("Texas"));
		cartas.add(new CartaQuadrado("Alasca"));
		assertTrue(deck.verifica_troca(cartas));
		cartas.remove(cartas.get(0));
		cartas.remove(cartas.get(0));
		cartas.remove(cartas.get(0));
		cartas.add(new CartaTriangulo("Peru"));
		cartas.add(new CartaTriangulo("Brasil"));
		cartas.add(new CartaQuadrado("Texas"));
		assertFalse(deck.verifica_troca(cartas));
	}
	
	@Test
	public void teste_tira_uma_carta()
	{
		Jogador jogador = new Jogador("Jogador", "Azul");
		ConjuntoCartaConquista deck = new ConjuntoCartaConquista();
		jogador.conquistou_na_rodada();
		deck.tira_uma_carta(jogador);
		assertEquals(deck.get_cartas().size(),52);
	}
	
	@Test
	public void teste_max_cartas()
	{
		Jogador jogador = new Jogador("Jogador", "Azul");
		ConjuntoCartaConquista deck = new ConjuntoCartaConquista();
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
		jogador.conquistou_na_rodada();
		deck.tira_uma_carta(jogador);
		assertEquals(jogador.get_carta().size(),deck.get_max_cartas()+1);
		// Obrigar a forcar a troca de cartas por exercitos
		
	}
}

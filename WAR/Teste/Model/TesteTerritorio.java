package Model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class TesteTerritorio {
	
	@Test
	public void testa_fronteiras_territorio(){
		Territorio BrasilTeste = new Territorio("Brasil", "América do Sul", new ArrayList<>(Arrays.asList("Argentina", "Peru", "Venezuela", "Nigéria")));
		assertTrue(BrasilTeste.faz_fronteira("Argentina"));
		assertFalse(BrasilTeste.faz_fronteira("Reino Unido"));
	}
	
	@Test
	public void testa_add_exercito(){
		Jogador jogador = new Jogador("Jogador", "Azul");
		Jogador jogador2 = new Jogador("Jogador2", "Preto");
		Territorio BrasilTeste = new Territorio("Brasil", "América do Sul", new ArrayList<>(Arrays.asList("Argentina", "Peru", "Venezuela", "Nigéria")));
		BrasilTeste.set_Jogador(jogador);
		assertTrue(BrasilTeste.add_exercito(jogador, 10));
		assertFalse(BrasilTeste.add_exercito(jogador2, 10));
	}
	
	@Test
	public void testa_conquista(){
		Jogador jogador = new Jogador("Jogador", "Azul");
		Jogador jogador2 = new Jogador("Jogador2", "Preto");
		Territorio BrasilTeste = new Territorio("Brasil", "América do Sul", new ArrayList<>(Arrays.asList("Argentina", "Peru", "Venezuela", "Nigéria")));
		BrasilTeste.set_Jogador(jogador);
		assertEquals(BrasilTeste.get_Jogador(),jogador);
		BrasilTeste.conquista(jogador2, 3);
		assertEquals(BrasilTeste.get_Jogador(),jogador2);
		assertEquals(BrasilTeste.get_exercitos(),3);
	}
	
	@Test
	public void testa_criacao(){
		Jogador jogador = new Jogador("Jogador", "Azul");
		Territorio BrasilTeste = new Territorio("Brasil", "América do Sul", new ArrayList<>(Arrays.asList("Argentina", "Peru", "Venezuela", "Nigéria")));
		BrasilTeste.set_Jogador(jogador);
		BrasilTeste.add_exercito(jogador,2);
		assertEquals(BrasilTeste.get_Jogador(),jogador);
		assertEquals(BrasilTeste.get_nome(),"Brasil");
		assertEquals(BrasilTeste.get_exercitos(),2);
		assertEquals(BrasilTeste.get_Regiao(),"América do Sul");
	}
	
}

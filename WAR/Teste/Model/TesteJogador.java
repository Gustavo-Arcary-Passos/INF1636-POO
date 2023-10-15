package Model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

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
		
	}
	
	@Test
	public void teste_ganha_exercito_inicio_rodada()
	{
		
	}

}

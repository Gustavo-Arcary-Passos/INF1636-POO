package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesteJogador {

	@Test
	public void teste_construtor()
	{
		Jogador jogador = new Jogador("Jogador", "Azul");
		assertEquals("Jogador", jogador.get_nome());
		assertEquals("Azul", jogador.get_cor());
	}

	//TODO: teste territórios, com o novo sistema

}

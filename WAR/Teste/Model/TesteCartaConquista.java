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
		cartas.add(new CartaTriangulo());
		cartas.add(new CartaTriangulo());
		cartas.add(new CartaTriangulo());
		assertTrue(deck.verifica_troca(cartas));
		cartas.remove(cartas.get(0));
		cartas.remove(cartas.get(0));
		cartas.remove(cartas.get(0));
		cartas.add(new CartaCirculo());
		cartas.add(new CartaTriangulo());
		cartas.add(new CartaQuadrado());
		assertTrue(deck.verifica_troca(cartas));
		cartas.remove(cartas.get(0));
		cartas.remove(cartas.get(0));
		cartas.remove(cartas.get(0));
		cartas.add(new CartaCuringa());
		cartas.add(new CartaCuringa());
		cartas.add(new CartaQuadrado());
		assertTrue(deck.verifica_troca(cartas));
		cartas.remove(cartas.get(0));
		cartas.remove(cartas.get(0));
		cartas.remove(cartas.get(0));
		cartas.add(new CartaCuringa());
		cartas.add(new CartaTriangulo());
		cartas.add(new CartaQuadrado());
		assertTrue(deck.verifica_troca(cartas));
		cartas.remove(cartas.get(0));
		cartas.remove(cartas.get(0));
		cartas.remove(cartas.get(0));
		cartas.add(new CartaCuringa());
		cartas.add(new CartaQuadrado());
		cartas.add(new CartaQuadrado());
		assertTrue(deck.verifica_troca(cartas));
		cartas.remove(cartas.get(0));
		cartas.remove(cartas.get(0));
		cartas.remove(cartas.get(0));
		cartas.add(new CartaTriangulo());
		cartas.add(new CartaTriangulo());
		cartas.add(new CartaQuadrado());
		assertFalse(deck.verifica_troca(cartas));
	}
}

package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class TesteRegiao {
	
	@Test
	public void testa_regiao_criada(){
		Europa EuropaReg = new Europa();
		assertEquals(EuropaReg.get_exercito_extra(),5);
		assertEquals(EuropaReg.get_nome(),"Europa");
	}
	
}

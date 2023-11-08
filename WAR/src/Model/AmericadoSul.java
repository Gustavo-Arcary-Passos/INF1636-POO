package Model;

import java.util.ArrayList;
import java.util.Arrays;

class AmericadoSul extends Regiao {
	public AmericadoSul() {
		this.nome = "América do Sul";
		this.exercito_extra = 2;
		paises.add(new Territorio("Brasil", "América do Sul", new ArrayList<>(Arrays.asList("Argentina", "Peru", "Venezuela", "Nigéria"))));
        paises.add(new Territorio("Argentina", "América do Sul", new ArrayList<>(Arrays.asList("Brasil", "Peru"))));
        paises.add(new Territorio("Peru", "América do Sul", new ArrayList<>(Arrays.asList("Brasil", "Argentina", "Venezuela"))));
        paises.add(new Territorio("Venezuela", "América do Sul", new ArrayList<>(Arrays.asList("México", "Brasil", "Peru"))));
	}
}

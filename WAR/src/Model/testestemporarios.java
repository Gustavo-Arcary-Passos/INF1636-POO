package Model;

import java.util.*;

public class testestemporarios {

    // fiz esse arquvo para poder testar coisinhas

    public static void main(String[] args) {
        List<String> fronteiras = new ArrayList<String>();
        fronteiras.add("Brasil");
        fronteiras.add("Peru");
        fronteiras.add("Colombia");
        territorio venezuela = new territorio("Venezuela", "America do sul", fronteiras);
        jogador j1 = new jogador("j1", "azul");

        venezuela.set_jogador(j1);

        System.out.println("Território: " + venezuela.get_nome());
        System.out.println("Região: " + venezuela.get_regiao());
        System.out.println("Exércitos: " + venezuela.get_exercitos());

        System.out.println("Jogador que domina:");
        System.out.println(venezuela.get_jogador().get_cor());

    }
}

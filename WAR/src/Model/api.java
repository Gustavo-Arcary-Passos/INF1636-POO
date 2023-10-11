package Model;

import java.util.ArrayList;
import java.util.List;

public class api {

	public static void main(String[] args) {
		List<String> front = new ArrayList<>();
        // Adicionar elementos à lista
        front.add("Argentina");
        front.add("Peru");
        front.add("Venezuela");
        front.add("Nigeria");
		Territorio Brasil = new Territorio("Brasil","America do Sul", front);
		System.out.println(Brasil.get_nome());
		System.out.println(Brasil.get_Regiao());
		System.out.println(Brasil.get_exercitos());
		System.out.println(Brasil.get_Jogador());
		
		
	}
}

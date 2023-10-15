package Model;

import java.util.*;

public class api {

	public static void main(String[] args) {
		List<Regiao> mapa_mundo = api.inicializa_mundo();
		List<Jogador> jogadores_ativos = api.inicializa_jogadores();
		
	}
	
	protected static List<Regiao> inicializa_mundo(){
		List<Regiao> mundo = new ArrayList<Regiao>();
		mundo.add(new Asia());
		mundo.add(new Europa());
		mundo.add(new Oceania());
		mundo.add(new AmericadoSul());
		mundo.add(new AmericadoNorte());
		mundo.add(new Africa());
		return mundo;
	}
	protected static List<Jogador> inicializa_jogadores(){
		List<Jogador> jogadores = new ArrayList<Jogador>();
		Scanner scan = new Scanner(System.in);
		System.out.println("Bem vindo ao War! Quantos jogadores vão jogar? (entre 3 e 6)");
		int num_jogadores = 0;
        num_jogadores = scan.nextInt();
        scan.nextLine();
        while (num_jogadores < 3 || num_jogadores > 6) {
        	System.out.println("Número inválido. Digite novamente.");
            num_jogadores = scan.nextInt();
            scan.nextLine();
        }
        String nome_jogador;
        List<String> cores = new ArrayList<>(Arrays.asList("azul", "vermelho", "verde", "amarelo", "preto", "branco"));
        String cor_input=null;
        for(int i=0; i<num_jogadores; i++) {
        	System.out.printf("Qual o nome do jogador %d?\n",i);
        	nome_jogador = scan.nextLine();
        	while(!Cor.existe_cor(cor_input,cores)) {
        		System.out.println("Qual a cor que você quer jogar?");
            	cor_input = scan.nextLine();
            	if(Cor.existe_cor(cor_input,cores)) {
            		jogadores.add(new Jogador(nome_jogador, cor_input));
            		break;
            	}
            	else {
            		System.out.println("Essa cor não pode ser usada, tente novamente");
            	}
        	}
        	
        }
        scan.close();
        return jogadores;
	}
	
}



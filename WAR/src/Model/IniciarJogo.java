package Model;

public class IniciarJogo {

    // pergunta ao usuario quantos jogadores vão jogar, entre 4 e 6
    // cria os jogadores
    // cria os territorios
    // sorteia os objetivos
    // sorteia os territorios (posiciona um exercito em cada)

    // PRIMEIRA RODADA:
    // Recebimento e posicionamento dos exércitos correspondentes à metade do
    // número de territórios que o jogador da vez possui;
    // Recebimento e posicionamento dos exércitos correspondentes à posse de um
    // continente inteiro;
    // Recebimento e posicionamento dos exércitos correspondentes à troca de
    // cartas de territórios;

    public static void main(String[] args) {
        System.out.println("Bem vindo ao War! Quantos jogadores vão jogar? (entre 4 e 6)");
        int num_jogadores = 0;

        while (num_jogadores < 4 || num_jogadores > 6) {
            num_jogadores = Integer.parseInt(System.console().readLine());
            if (num_jogadores < 4 || num_jogadores > 6) {
                System.out.println("Número inválido. Digite novamente.");
            }
        }

        // para cada jogador, pede o nome e define a cor
        String[] cores = { "azul", "vermelho", "verde", "amarelo", "preto", "branco" };
        String[] nomes = new String[num_jogadores];

        for (int i = 0; i < num_jogadores; i++) {
            System.out.println("Digite o nome do jogador " + (i + 1) + ":");
            nomes[i] = System.console().readLine();
        }

        // cria os jogadores
        Jogador[] jogadores = new Jogador[num_jogadores];
        for (int i = 0; i < num_jogadores; i++) {
            jogadores[i] = new Jogador(nomes[i], cores[i]);
        }

        // imprime os nomes e cores dos jogadores
        System.out.println("Jogadores:");
        for (int i = 0; i < num_jogadores; i++) {
            System.out.println(jogadores[i].get_nome() + " - " + jogadores[i].get_cor());
        }

        System.out.println("ENTER para continuar");
        System.console().readLine();

        // apaga o texto do enter
        System.out.print("\033[H\033[2J");

        System.console().readLine();

    }

}

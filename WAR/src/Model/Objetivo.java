package Model;

public abstract class Objetivo {

    Jogador jogador;

    // construtor
    public Objetivo(Jogador jogador) {
        this.jogador = jogador;
    }

    public Objetivo() {
        this.jogador = null;
    }
    
    // roda programa para saber se um jogador ganhou
    // cada objetivo deve implementar sua própria versão
    public abstract boolean verifica_status();

    // retorna uma descrição do objetivo
    public abstract String get_descricao();

    // retorna o nome do objetivo
    public abstract String get_nome();

    // retorna o nome do jogador que deve cumprir o objetivo
    public String get_nome_jogador() {
        return this.jogador.get_nome();
    }

    // retorna o objeto jogador que deve cumprir o objetivo
    public Jogador get_jogador() {
        return this.jogador;
    }

    public void set_jogador(Jogador jogador) {
        this.jogador = jogador;
    }

}

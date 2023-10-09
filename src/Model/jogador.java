package Model;

class jogador {
    private String nome;
    private String cor;

    public jogador(String nome, String cor) {
        this.nome = nome;
        this.cor = cor;
    }

    public String get_nome() {
        return this.nome;
    }

    public String get_cor() {
        return this.cor;
    }
}

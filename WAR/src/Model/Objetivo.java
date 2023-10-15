package Model;

abstract class Objetivo {
	protected Jogador dono;
    // construtor
    public Objetivo() {
       
    }
    
    // roda programa para saber se um jogador ganhou
    // cada objetivo deve implementar sua própria versão
    public abstract boolean verifica_status();
    
    public void ganha_dono(Jogador dono) {
    	this.dono = dono;
    }
   

}

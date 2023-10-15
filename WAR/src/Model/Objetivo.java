package Model;

abstract class Objetivo {
	protected Jogador dono;
	protected Regiao asia, europa, americasul, americanorte, africa, oceania;
    // construtor
    public Objetivo() {
       
    }
    public Objetivo(Regiao asia, Regiao oceania, Regiao africa, Regiao americasul, Regiao americanorte, Regiao europa) {
    	this.asia = asia;
    	this.oceania = oceania;
    	this.africa = africa;
    	this.americasul = americasul;
    	this.americanorte = americanorte;
    	this.europa = europa;
    }
    
    // roda programa para saber se um jogador ganhou
    // cada objetivo deve implementar sua própria versão
    public abstract boolean verifica_status();
    
    public void ganha_dono(Jogador dono) {
    	this.dono = dono;
    }
   

}

package Model;

public class ExercitoRegiao {
	protected int exercito;
	protected String regiao;
	
	public ExercitoRegiao(String regiao) {
		this.regiao = regiao;
	}
	public String get_regiao() {
		return this.regiao;
	}
	public int get_exercito() {
		return this.exercito;
	}
	public void add_exercito(int qtd) {
		this.exercito += qtd;
	}
}

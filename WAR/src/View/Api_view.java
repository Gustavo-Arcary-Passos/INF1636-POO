package View;
import Model.Observador;

public class Api_view {
	
	/** Função que instancia um observador da view para ser usada na model, o parametro o se escreve igual ao nome da classe que você deseja instanciar
	 **/
	public static Observador Instancia_Observador(String o) {
		if(o == "DadoView") {
			return new DadoView();
		}
		else {
			//temos que mudar isso
			return new DadoView();
		}
		
	}
}

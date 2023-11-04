package View;
import java.awt.event.ActionEvent;
//import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import Model.Observador;

public class Api_view {
	Tela jogo;
	RotinaJogadores rotina_atual = RotinaJogadores.getInstance();
	JLabel qtd_exercito;
	JLabel name_terr;
	protected Timer timer;
	
	public Api_view() {
		jogo = new Tela();
		jogo.setTitle("War");
		jogo.setVisible(true);
	}
	
	public void next_rodada() {
		jogo.rodada_increment();
	}
	
	public void create_numero_exercitos_text(String name,String min) {
		qtd_exercito = jogo.create_text_field_qtd_exerc(min);
		name_terr = jogo.create_text_field_name_terr(name);
	}
	
	public void delete_numero_exercitos_text() {
		jogo.delete_text_field();
	}
	
	public String get_terr_sel() {
		return name_terr.getText();
	}
	
	public void set_rotina_layout(String layout) {
		this.delete_numero_exercitos_text();
		this.set_rotina_atual(layout);
		this.repinta_tela();
	}
	
	public int get_qtd_exerc_sel() {
		return Integer.parseInt(qtd_exercito.getText());
	}
	
	public void change_name_terr_text(String name) {
		if(name_terr.getText() != name) {
			name_terr.setText(name);
			qtd_exercito.setText(Integer.toString(0));
		}
	}
	
	public void change_numero_exercitos_text(int qtd,int limit, int min) {
		int value = Integer.parseInt(qtd_exercito.getText());
		value += qtd;
		//System.out.println(value);
		if(value >= min && value <= limit)
		qtd_exercito.setText(Integer.toString(value));
	}
	
	public void repinta_tela() {
		jogo.repaint();
	}
	
	public String get_fase_atual() {
		return jogo.get_rotina();
	}
	
	public void set_next_rotina() {
		jogo.next_rotina();
		if(get_fase_atual() != "PASS") {
			this.repinta_tela();
		}
	}
	
	public void set_rotina_atual(String nome) {
		rotina_atual.set_layout(nome);
	}
	
	public String get_rotina_atual() {
		return rotina_atual.get_layout();
	}
	
	public void Dado_verifica_ligado() {
		if (DadoView.get_flag() == true) {
        	DadoView.set_exibe(!DadoView.get_flag());
        	jogo.repaint();
        }
	}
	
	public void encerrar_partida() {
		
	}
	
	public boolean verifica_ok_clicado(int x,int y) {
		int x1 = 630;
		int y1 = 657;
		double r = 30;
		if((double)Math.sqrt(Math.pow((double)x - (double)x1, 2) + Math.pow((double)y - (double)y1, 2)) < r) {
			return true;
		}
		return false;
	}
	
	public String verifica_territorio_clicado(int x,int y) {
		DesenhaTerritorioPoligono clicado = jogo.formas_geometricas_clicada(x,y);
        if(clicado!=null) {
        	//System.out.println(clicado.get_nome());
        	return clicado.get_nome();
        	//clicado.set_color(Color.WHITE);
        } else {
//        	if(x > 925 && x < 982 && y > 715 && y < 752) {
//        		System.out.println("Aqui!");
//        		Api_model.ataque();
//	            DadoView.set_exibe(!DadoView.get_flag());
//	            tela.repaint();
//        	}
        }
        return null;
	}
	
	public void set_tela_mouseListener(MouseAdapter rotine) {
		jogo.addMouseListener(rotine);
	}
	
	public void remove_tela_mouseListener(MouseAdapter rotine) {
		jogo.removeMouseListener(rotine);
	}
	
	public JButton get_button(int cenario, int pos) {
		return jogo.get_button(cenario,pos); 
	}
	
	public ActionListener salva_jogador () {
		return JanelaInicial.salva_jogadores(jogo);
	}
	
	public void set_jogador_vez(String cor) {
		JanelaJogo.set_jogador_color(cor); 
	}
	
	public int get_num_jogador() {
		return jogo.get_num_jogador(); 
	}
	
	public List<String> get_jogadores() {
		return jogo.get_jogadores(0); 
	}
	
	public List<String> get_cores() {
		return jogo.get_cores(0); 
	}
	
	public void set_cartas(List<String> paises) {
		JanelaJogo.set_jogadores_cartas(paises);
	}
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

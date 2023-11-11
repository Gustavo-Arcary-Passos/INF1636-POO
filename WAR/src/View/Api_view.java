package View;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import Model.Observador;

public class Api_view {
	Tela jogo;
	RotinaJogadores rotina_atual = RotinaJogadores.getInstance();
	boolean curinga_slc;
	public Api_view() {
		jogo = new Tela();
		jogo.setTitle("War");
		jogo.setVisible(true);
	}
	
	public void set_look_objetivo(boolean status) {
		rotina_atual.set_objetivo_status(status);
	}
	
	public boolean get_look_objetivo() {
		return rotina_atual.get_objetivo_status();
	}
	
	public Observador get_janelajogo() {
		return jogo.get_janelajogo();
	}
	
	public void next_rodada() {
		jogo.rodada_increment();
	}
	
	public void create_ataque_compose_text(String atacante, String atacado) {
		rotina_atual.set_terr(atacante,1);
		rotina_atual.set_terr(atacado,2);
		this.repinta_tela();
	}
	
	public void change_name_terr_text(String name, int v) {
		rotina_atual.set_terr(name,v);
		this.repinta_tela();
		
	}
	
	public void create_numero_exercitos_text(String name,int min) { 
		rotina_atual.set_terr(name,0);
		rotina_atual.set_qtd_exerc(0,min);
		rotina_atual.set_qtd_exerc(1,min);
	}
	
	public String get_terr_sel(int v) {
		return rotina_atual.get_terr(v);
	}
	
	public void set_rotina_layout(String layout) { 
		this.set_rotina_atual(layout);
		this.repinta_tela();
	}
	
	public int get_qtd_exerc_sel() {
		return rotina_atual.get_qtd_exerc(0); 
	}
	
	public void change_name_terr_text(String name) { 
		if(this.get_terr_sel(0) != name) {
			this.change_name_terr_text(name,0);
			rotina_atual.set_qtd_exerc(0,0);
		}
		this.repinta_tela();
	}
	
	public void change_numero_exercitos_text(int qtd,int limit, int min) { 
		int value = rotina_atual.get_qtd_exerc(0);
		value += qtd;
		rotina_atual.set_qtd_exerc(2,limit);
		rotina_atual.set_qtd_exerc(1,min);
		if(value >= min && value <= limit) {
			rotina_atual.set_qtd_exerc(0,value);
			this.repinta_tela();
		}
		
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
	
	public JOptionPane jogador_ganhou(String nome) {
		return new ReiniciarJogo (nome);
	}
	
	public void reset_all() {
		// Talvez nao precisa disso
		jogo.reset();
	}
	
	public void encerrar_partida() {
		jogo.dispose();
	}
	
	public void set_objetivo_jogador_da_vez(String name) {
		rotina_atual.set_objetivo(name);
	}
	
	public boolean verifica_objetivo_clicado(int x , int y) {
		int x1 = 955;
		int y1 = 715;
		double r = 40;
		if((double)Math.sqrt(Math.pow((double)x - (double)x1, 2) + Math.pow((double)y - (double)y1, 2)) < r) {
			return true;
		}
		return false;
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
	public boolean verifica_trocar_carta_clicado(int x,int y) {
		int x1 = 608;
		int y1 = 654;
		double r = 20;
		if((double)Math.sqrt(Math.pow((double)x - (double)x1, 2) + Math.pow((double)y - (double)y1, 2)) < r) {
			return true;
		}
		return false;
	}
	
	public boolean verifica_passar_ataque_clicado(int x,int y) {
		int x1 = 514;
		int y1 = 718;
		double r = 45;
		if((double)Math.sqrt(Math.pow((double)x - (double)x1, 2) + Math.pow((double)y - (double)y1, 2)) < r) {
			return true;
		}
		return false;
	}
	
	public String verifica_territorio_clicado(int x,int y) {
		DesenhaTerritorioPoligono clicado = jogo.formas_geometricas_clicada(x,y);
        if(clicado!=null) {
        	return clicado.get_nome();
        } 
        return null;
	}
	
	public void realiza_ataque() {
		//System.out.println("Aqui!");
        DadoView.set_exibe(!DadoView.get_flag());
        jogo.repaint();
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
		// System.out.println("Chamando");
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
		rotina_atual.set_lista_carta(paises);
	}
	
	public List<String> get_cartas(){
		return rotina_atual.get_lista_carta();
	}

	public void reposicionamento_selected_lose(String pais) {
		DesenhaTerritorioPoligono[] terras = jogo.get_terr();
		for(DesenhaTerritorioPoligono terra : terras) {
			if(!terra.get_slctd() && terra.get_nome() == pais) {
				terra.set_slctd(true);
			}
		}
	}
	
	public void reposicionamento_selected_win(String pais) {
		DesenhaTerritorioPoligono[] terras = jogo.get_terr();
		for(DesenhaTerritorioPoligono terra : terras) {
			if(!terra.get_slctd() && terra.get_nome() == pais) {
				terra.set_slctd(true);
			}
		}
	}
	
	public void reset_all_selected() {
		if(curinga_slc) {
			curinga_slc = false;
		}
		DesenhaTerritorioPoligono[] terras = jogo.get_terr();
		for(DesenhaTerritorioPoligono terra : terras) {
			if(terra.get_slctd()) {
				terra.set_slctd(false);
			}
		}
		CartasView.reset_carta_tela_selected();
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
	
	public void set_selected_terr(String pais) {
		if(pais == "Curinga") {
			curinga_slc = !curinga_slc;
		}
		
		DesenhaTerritorioPoligono[] terras = jogo.get_terr();
		for(DesenhaTerritorioPoligono terra : terras) {
			if(terra.get_nome() == pais) {
				terra.set_slctd(!terra.get_slctd());
			}
		}
	}
	
	public boolean get_selected_terr(String pais) {
		if(pais == "Curinga") {
			return curinga_slc;
		}
		
		DesenhaTerritorioPoligono[] terras = jogo.get_terr();
		for(DesenhaTerritorioPoligono terra : terras) {
			if(terra.get_nome() == pais) {
				return terra.get_slctd();
			}
		}
		return false;
	}
	
	public int qtd_selected() {
		int qtd = 0;
		if(curinga_slc) {
			qtd++;
		}
		DesenhaTerritorioPoligono[] terras = jogo.get_terr();
		for(DesenhaTerritorioPoligono terra : terras) {
			if(terra.get_slctd()) {
				qtd++;
			}
			if(terra.get_nome() == "Reino Unido" && qtd == 4 && terra.get_slctd()) {
				qtd--;
			}
		}
		return qtd;
	}
	public List<String> show_selected() {
		List<String> selected = new ArrayList<>();
		if(curinga_slc) {
			selected.add("Curinga");
		}
		DesenhaTerritorioPoligono[] terras = jogo.get_terr();
		for(DesenhaTerritorioPoligono terra : terras) {
			if(terra.get_slctd()) {
				selected.add(terra.get_nome());
			}
		}
		return selected;
	}

    public String verifica_carta_clicada(int x, int y) {
    	String carta = CartasView.get_carta_clicada(x, y);
    	if(this.get_selected_terr(carta) || this.qtd_selected() < 3) {
    		this.set_selected_terr(carta);
    		this.repinta_tela();
    	}
    	this.show_selected();
        return carta;
    }
}

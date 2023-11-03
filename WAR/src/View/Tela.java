package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//import Model.Api_model;
class Tela extends JFrame {
	int value;
	protected final int LARG_DEFAULT=1200;
	protected final int ALT_DEFAULT=800;
	private LoadScene[] cenarios;
	private static int cenario;
	protected int rodada;
	protected List<String> rotina = new ArrayList<>(Arrays.asList("PER", "PE", "ATQ", "REP", "PASS"));
	protected int rotina_ind;
//	protected List<String> jogadores_nomes;
//	protected List<String> jogadores_cores;
	public Tela() {
		setSize(LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		cenarios = new LoadScene[2];
		cenarios[0] = new JanelaInicial(this);
		addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	        	
	        }
	    });
	}
	public String get_rotina() {
		return rotina.get(rotina_ind);
	}
	public void next_rotina() {
		rotina_ind++;
		if(rotina_ind > 4) {
			rotina_ind = 0;
		}
		this.repaint();
	}
	public JButton get_button(int cenario,int pos) {
		return cenarios[cenario].get_button(pos);
	}
	public List<String> get_jogadores(int cenario) {
		return cenarios[cenario].get_jogares_name();
	}
	public List<String> get_cores(int cenario) {
		return cenarios[cenario].get_jogares_color();
	}

	public int get_num_jogador() {
		return JanelaInicial.get_num_jogadores();
	}
	
//	public static void next_cenario() {
//		cenario++;
//	}
	protected void trocarParaJanelaJogo() {
        // Remova todos os componentes da tela atual, se necessário
//		for(int i = 0; i < jogadores_nomes.size(); i++) {
//			String nome = jogadores_nomes.get(i);
//	        String cor = jogadores_cores.get(i);
//			System.out.println("Jogador " + (i + 1) + ": Nome = " + nome + ", Cor = " + cor);
//		}
		
        getContentPane().removeAll();
        cenarios[1] = new JanelaJogo(this);
        // Crie uma instância da JanelaJogo
        cenario = 1;
        this.rodada = 0;
        //cenarios[1] = new JanelaJogo(this);

        // Adicione um novo MouseListener, se necessário
        // Redesenha a tela
        repaint();
    }
	public void rodada_increment() {
		this.rodada++;
	}
	public int get_rodada() {
		return this.rodada;
	}
	
	@Override
	public void paint(Graphics g) {
	    super.paint(g);
	    cenarios[cenario].desenha(g);
	}
}


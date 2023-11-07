package View;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import Model.Observador;

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
	protected RotinaJogadores rotina_atual = RotinaJogadores.getInstance();
//	protected List<String> jogadores_nomes;
//	protected List<String> jogadores_cores;
	public Tela() {
		setSize(LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		cenarios = new LoadScene[2];
		cenarios[0] = new JanelaInicial(this);
		cenarios[1] = new JanelaJogo(this);
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
		
		if(rodada == 0 && rotina_ind == 1) {
			//System.out.println("Caiu aqui");
			rotina_ind = 4;
		}else {
			rotina_ind++;
			if(rotina_ind > 4) {
				rotina_ind = 0;
			}
			this.repaint();
		}
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
	
	public Observador get_janelajogo() {
		return (Observador)cenarios[1];
	}

	public int get_num_jogador() {
		return JanelaInicial.get_num_jogadores();
	}
	
	public DesenhaTerritorioPoligono formas_geometricas_clicada(int x, int y) {
		return cenarios[cenario].formas_geometricas_clicada(x,y);
	}
	
	public JLabel create_text_field_qtd_exerc(String value) {
		JLabel ln = new JLabel(value);
		ln.setBounds(457, 665, 69, 69);
		ln.setHorizontalAlignment(SwingConstants.CENTER);
		Font font = ln.getFont();
		ln.setFont(new Font(font.getFontName(), Font.PLAIN, 24));
		this.getContentPane().add(ln);
		return null;
	}
	
	public JLabel create_text_field_name_terr(String name,int x,int y,int w,int h) {
		JLabel territorio = new JLabel(name);
		territorio.setBounds(x, y, w, h);
		territorio.setHorizontalAlignment(SwingConstants.CENTER);
		Font font = territorio.getFont();
		territorio.setFont(new Font(font.getFontName(), Font.PLAIN, 13));
		this.getContentPane().add(territorio);
		return territorio;
	}
	
	public void delete_text_field() {
		getContentPane().removeAll();
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
	public void repinta_todos_componentes() {
		Component[] components = this.getContentPane().getComponents();
        for (Component component : components) {
            component.repaint();
        }
	}
	
	@Override
	public void paint(Graphics g) {
	    super.paint(g);
	    cenarios[cenario].desenha(g);
	    repinta_todos_componentes();
	    if(cenario == 1) {
	    	rotina_atual.show_layout(g);
	    }
	}
}


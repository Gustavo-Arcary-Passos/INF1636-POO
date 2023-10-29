package View;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Model.Api_model;
class Tela extends JFrame {
	int value;
	protected final int LARG_DEFAULT=1200;
	protected final int ALT_DEFAULT=800;
	private LoadScene[] cenarios;
	private static int cenario;
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
//	public static void next_cenario() {
//		cenario++;
//	}
	protected void trocarParaJanelaJogo() {
        // Remova todos os componentes da tela atual, se necessário
        getContentPane().removeAll();

        // Crie uma instância da JanelaJogo
        cenario = 1;
        //cenarios[1] = new JanelaJogo(this);

        // Adicione um novo MouseListener, se necessário
        // Redesenha a tela
        repaint();
    }
	@Override
	public void paint(Graphics g) {
	    super.paint(g);
	    cenarios[cenario].desenha(g);
	}
}


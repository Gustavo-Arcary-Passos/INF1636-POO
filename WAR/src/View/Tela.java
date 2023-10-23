package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

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
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	int x = e.getX();
	            int y = e.getY();
	            System.out.println(x+", "+y);
	            //cenario++;
	            DesenhaTerritorioPoligono clicado = cenarios[cenario].formas_geometricas_clicada(x,y);
	            if(clicado!=null) {
	            	System.out.println(clicado.get_nome());
	            	//clicado.set_color(Color.WHITE);
	            }
	            Dado.set_exibe(!Dado.get_flag());
	            repaint();
            }
        });

        // Redesenha a tela
        repaint();
    }
	@Override
	public void paint(Graphics g) {
	    super.paint(g);
	    cenarios[cenario].desenha(g);
	}
}


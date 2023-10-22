package View;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.Color;

class Tela extends JFrame {
	int value;
	protected final int LARG_DEFAULT=1200;
	protected final int ALT_DEFAULT=800;
	private LoadScene[] cenarios;
	private int cenario;
	public Tela() {
		setSize(LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		cenarios = new LoadScene[1];
		cenarios[cenario] = new JanelaJogo();
		addMouseListener(new MouseAdapter() {
	        @Override
	        public void mouseClicked(MouseEvent e) {
	        	int x = e.getX();
	            int y = e.getY();
	            System.out.println(x+", "+y);
	            //cenario++;
//	            DesenhaTerritorioPoligono clicado = cenarios[cenario].formas_geometricas_clicada(x,y);
//	            if(clicado!=null) {
//	            	System.out.println(clicado.get_nome());
//	            }
	            Dado.set_exibe(!Dado.get_flag());
	            repaint();
	        }
	    });
	}
	
	@Override
	public void paint(Graphics g) {
	    super.paint(g);
	    cenarios[cenario].desenha(g);
	}
}


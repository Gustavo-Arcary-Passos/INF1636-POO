package View;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.Color;

class Tela extends JFrame {
	protected final int LARG_DEFAULT=1200;
	protected final int ALT_DEFAULT=800;
	private ImagemInfo[] images;
	private DesenhaTerritorioPoligono[] terras;
	private int count_images,count_terras;
	public Tela() {
		setSize(LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		images = new ImagemInfo[100];
		count_images_loaded(new ImagemInfo ("war_tabuleiro_fundo.png",0,0,1024,768));
		count_images_loaded(new ImagemInfo ("war_tabuleiro_mapa copy.png",0,0,1024,768));
		
		terras = new DesenhaTerritorioPoligono[51];
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{274,332,326,343,336,315,306,291,285,254,234},new int[]{500,500,487,457,441,441,421,418,402,394,430}, Color.RED, "Brasil"));
		
	}
	
	@Override
	public void paint(Graphics g) {
	    super.paint(g);
	    for(int i = 0; i <= this.count_images; i++) {
		    if (images[i] != null) {
		        g.drawImage(images[i].get_image(), images[i].get_x(), images[i].get_y(),images[i].get_w(),images[i].get_h(), this);
		    }
	    }
	    Graphics2D g2d = (Graphics2D) g;
	    for(int i = 0; i <= this.count_terras; i++) {
		    if (terras[i] != null) {
		    	g2d.setColor(terras[i].get_cor());
		    	g2d.fill(terras[i].get_polygon());
		    	g2d.setColor(Color.BLACK);
		    	g2d.draw(terras[i].get_polygon());
		    }
	    }
	}
	
	public void count_images_loaded(ImagemInfo imagem) {
		count_images++;
		this.images[count_images-1] = imagem;
	}
	
	public void count_terras_loaded(DesenhaTerritorioPoligono terra) {
		count_terras++;
		this.terras[count_terras-1] = terra;
	}
}


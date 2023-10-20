package View;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.Color;

public class Tela extends JFrame {
	public final int LARG_DEFAULT=1200;
	public final int ALT_DEFAULT=800;
	private ImagemInfo[] images;
	private int count;
	public Tela() {
		setSize(LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setBackground(Color.BLUE);
		
		images = new ImagemInfo[100];
		count_images_loaded(new ImagemInfo ("war_tabuleiro_fundo.png",0,0,1024,768));
		count_images_loaded(new ImagemInfo ("war_tabuleiro_mapa copy.png",0,0,1024,768));
	}
	
	@Override
	public void paint(Graphics g) {
	    super.paint(g);
	    for(int i = 0; i <= this.count; i++) {
		    if (images[i] != null) {
		        g.drawImage(images[i].get_image(), images[i].get_x(), images[i].get_y(), this);
		    }
	    }
	}
	
	public void count_images_loaded(ImagemInfo imagem) {
		count++;
		this.images[count-1] = imagem;
	}
}


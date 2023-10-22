package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;

class LoadScene {
	protected ImagemInfo[] images;
	protected DesenhaTerritorioPoligono[] formas_geometricas;
	protected int count_images,count_formas_geometricas;
	//abstract public void cenario();
	
	public void count_images_loaded(ImagemInfo imagem) {
		count_images++;
		this.images[count_images-1] = imagem;
	}
	
	public void count_terras_loaded(DesenhaTerritorioPoligono formas_geometricas) {
		count_formas_geometricas++;
		this.formas_geometricas[count_formas_geometricas-1] = formas_geometricas;
	}
	
	public void desenha_images(Graphics g) {
		for(int i = 0; i <= this.count_images; i++) {
		    if (images[i] != null) {
		    	g.drawImage(images[i].get_image(), images[i].get_x(), images[i].get_y(), images[i].get_w(), images[i].get_h(), null);
		    }
	    }
	}
	
	public void desenha_formas_geometricas(Graphics2D g2d) {
		for(int i = 0; i < this.count_formas_geometricas; i++) {
		    if (formas_geometricas[i] != null) {
		    	g2d.setColor(formas_geometricas[i].get_cor());
		    	g2d.fill(formas_geometricas[i].get_polygon());
		    	g2d.setColor(Color.BLACK);
		    	g2d.draw(formas_geometricas[i].get_polygon());
		    }
	    }
	}
	
	public DesenhaTerritorioPoligono formas_geometricas_clicada(int x, int y) {
		for(int i = 0; i < this.count_formas_geometricas; i++) {
			if (formas_geometricas[i].clicou(x,y)) {
		    	return formas_geometricas[i];
		    }
		}
		return null;
	}
}

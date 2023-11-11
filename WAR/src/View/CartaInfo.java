package View;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.ImageObserver;

class CartaInfo extends ImagemInfo {
	protected String name;
    private Rectangle bounds; // se torna algo quando a carta é desenhada com draw_store
    protected boolean click;
    
    public boolean get_clicked() {
    	return this.click;
    }
    
    public void set_clicked(boolean status) {
    	this.click = status;
    }
    
    public CartaInfo(String caminho, int w, int h)
    {
        super(caminho, 512, 384, w, h);
    }
    
    public CartaInfo(String caminho, int w, int h, String nome)
    {
        super(caminho, 512, 384, w, h,nome);
    }

    /**
     * Desenha a imagem na tela, a partir do ponto central dela
     * @param g
     */
    public void desenha(Graphics g)
    {
        g.drawImage(imagem, x - (w / 2), y - (h / 2), w, h, null);
    }

    public void draw_store(Graphics g, int x, int y, int w, int h, ImageObserver observer)
    {	
    	if(this.click) {
    		y -= 10;
    		//System.out.println("TRUE");
    		g.drawImage(imagem, x, y, w, h, observer);
            bounds = new Rectangle(x, y, w, h);
    	} else {
    		//System.out.println("FALSE");
    		g.drawImage(imagem, x, y, w, h, observer);
            bounds = new Rectangle(x, y, w, h);
    	}
        
    }

    /**
     * Serve para checar clics.
     * @return true se o ponto (x,y) está dentro da imagem, false caso contrário
     */
    public boolean coord_inbounds(int x, int y)
    {
        if (bounds == null)
            return false;
        return bounds.contains(x, y);
    }
}

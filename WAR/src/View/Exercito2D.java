package View;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 * Classe que desenha a bola com o numero de exercitos
 * faz a média entre os pontos do poligono e desenha a bola
 * 
 * 
 */
class Exercito2D extends Ellipse2D.Double {
    private int num_exercitos;
    Ellipse2D borda;
    
    public Exercito2D(double x, double y, double size, int num_exercitos) {
        super(x, y, size, size);
        this.num_exercitos = num_exercitos;
        borda = new Ellipse2D.Double(x - 1, y - 1, size + 2, size + 2);

    }
    
    public void muda_exercito(int qtd) {
    	num_exercitos=qtd;
    }
    
    public void draw(Graphics2D g2d, Color cor)
    {
        int ax = -4;
        int ay = 5;
        g2d.setColor((cor != new Color(25,25,25))  ? Color.BLACK: Color.WHITE);
        g2d.setStroke(new BasicStroke(2));
        g2d.fill(this.borda);
        g2d.setColor(cor);
        g2d.fill(this);
        g2d.setColor((cor != new Color(25,25,25))  ? Color.BLACK: Color.WHITE);
        g2d.drawString(Integer.toString(this.num_exercitos), (int)this.getCenterX() + ax, (int)this.getCenterY() + ay);
    }
}
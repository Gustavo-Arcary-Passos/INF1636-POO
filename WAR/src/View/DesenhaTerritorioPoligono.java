package View;

import java.awt.Color;
import java.awt.geom.Path2D;

public class DesenhaTerritorioPoligono {
	protected String nome;
	protected Color cor;
	protected Path2D terra;
	
	public DesenhaTerritorioPoligono (int[] xs, int[] ys,Color color,String name) {
		this.cor = color;
		this.nome = name;
		this.terra = new Path2D.Double();
		for(int i = 0; i < xs.length ; i++) {
			if(i == 0) {
				this.terra.moveTo(xs[i], ys[i]);
			} else {
				this.terra.lineTo(xs[i], ys[i]);
			}
		}
		this.terra.closePath();
	}
	
	public String get_nome() {
		return this.nome;
	}
	
	public Color get_cor() {
		return this.cor;
	}
	
	public Path2D get_polygon() {
		return this.terra;
	}
	
	public void set_color(Color cor_atual) {
		this.cor = cor_atual;
	}
	
	public boolean clicou(int x, int y) {
		if(this.terra.contains(x, y) == true) {
			return true;
		}
		return false;
	}
}

//Graphics2D g2d = (Graphics2D) g;
//
//// Criar um polígono usando Path2D
//Path2D polygon = new Path2D.Double();
//polygon.moveTo(274, 500); 
//polygon.lineTo(332, 500); 
//polygon.lineTo(326, 487); 
//polygon.lineTo(343, 457);
//polygon.lineTo(336, 441);
//polygon.lineTo(315, 441);
//polygon.lineTo(306, 421);
//polygon.lineTo(291, 418);
//polygon.lineTo(285, 402);
//polygon.lineTo(254, 394);
//polygon.lineTo(234, 430);
//polygon.closePath(); // Feche o polígono
//
//boolean pontoDentro = polygon.contains(301, 426);
//
//if (pontoDentro) {
//    System.out.println("O ponto está dentro do polígono.");
//} else {
//    System.out.println("O ponto está fora do polígono.");
//}
//
//// Defina a cor de preenchimento e preencha o polígono
//Color minhaCor = new Color(255, 0, 255);
//g2d.setColor(minhaCor);
//g2d.fill(polygon);
//
//// Defina a cor da linha e desenhe o contorno do polígono
//g2d.setColor(Color.BLACK);
//g2d.draw(polygon);

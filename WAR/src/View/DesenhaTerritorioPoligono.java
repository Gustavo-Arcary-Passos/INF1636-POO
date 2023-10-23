package View;

import java.awt.Color;
import java.awt.Point;
import java.awt.geom.Path2D;

class DesenhaTerritorioPoligono {
	protected String nome;
	protected Color cor;
	protected boolean redesenha;
	protected Path2D terra;
	protected Exercito2D exercito;

	public DesenhaTerritorioPoligono(int[] xs, int[] ys, Color color, String name) {
		this.cor = color;
		this.nome = name;
		this.terra = new Path2D.Double();
		for (int i = 0; i < xs.length; i++) {
			if (i == 0) {
				this.terra.moveTo(xs[i], ys[i]);
			} else {
				this.terra.lineTo(xs[i], ys[i]);
			}
		}
		this.terra.closePath();

		// ********* EXERCITO 2D *******
		Point coord = this.get_centroDeMassa(this.terra, xs, ys);

		this.exercito = new Exercito2D(coord.x, coord.y, 22, 3); // Tamanho configurável aqui
	}

	// OVERLOAD, para ajustar a posicao dos exercitos
	public DesenhaTerritorioPoligono(int[] xs, int[] ys, Color color, String name, int ajx, int ajy) {
		this.cor = color;
		this.nome = name;
		this.terra = new Path2D.Double();
		for (int i = 0; i < xs.length; i++) {
			if (i == 0) {
				this.terra.moveTo(xs[i], ys[i]);
			} else {
				this.terra.lineTo(xs[i], ys[i]);
			}
		}
		this.terra.closePath();

		// ********* EXERCITO 2D *******
		Point coord = this.get_centroDeMassa(this.terra, xs, ys);

		this.exercito = new Exercito2D(coord.x + ajx, coord.y + ajy, 22, 3); // Tamanho configurável aqui
	}

	public String get_nome() {
		return this.nome;
	}

	public Color get_cor() {
		return this.cor;
	}

	public Exercito2D get_exercito_2d() {
		return this.exercito;
	}

	public Path2D get_polygon() {
		return this.terra;
	}

	public void set_color(Color cor_atual) {
		this.cor = cor_atual;
	}

	public boolean clicou(int x, int y) {
		if (this.terra.contains(x, y) == true) {
			return true;
		}
		return false;
	}

	/**
	 * @brief retorna o centro do polígono
	 * @return Point
	 */
	private Point get_centro() {
		return new Point((int) this.terra.getBounds().getCenterX(), (int) this.terra.getBounds().getCenterY());
	}

	/**
	 * @brief retorna o centro de massa do polígono
	 *        Para ser utilizado com o Exercito2D
	 * @param path
	 * @param xs
	 * @param ys
	 * @return
	 */
	public Point get_centroDeMassa(Path2D path, int[] xs, int[] ys) {

		double area = 0;
		double cx = 0;
		double cy = 0;

		for (int i = 0; i < xs.length; i++) {
			double xi = xs[i];
			double yi = ys[i];
			double xi1 = xs[(i + 1) % xs.length];
			double yi1 = ys[(i + 1) % ys.length];

			double a = xi * yi1 - xi1 * yi;
			area += a;
			cx += (xi + xi1) * a;
			cy += (yi + yi1) * a;
		}

		area /= 2.0;
		cx /= (6.0 * area);
		cy /= (6.0 * area);

		// pequeno ajuste manual

		cx -= 8;
		cy -= 8;

		return new Point((int) cx, (int) cy);
	}
}

// Graphics2D g2d = (Graphics2D) g;
//
//// Criar um polígono usando Path2D
// Path2D polygon = new Path2D.Double();
// polygon.moveTo(274, 500);
// polygon.lineTo(332, 500);
// polygon.lineTo(326, 487);
// polygon.lineTo(343, 457);
// polygon.lineTo(336, 441);
// polygon.lineTo(315, 441);
// polygon.lineTo(306, 421);
// polygon.lineTo(291, 418);
// polygon.lineTo(285, 402);
// polygon.lineTo(254, 394);
// polygon.lineTo(234, 430);
// polygon.closePath(); // Feche o polígono
//
// boolean pontoDentro = polygon.contains(301, 426);
//
// if (pontoDentro) {
// System.out.println("O ponto está dentro do polígono.");
// } else {
// System.out.println("O ponto está fora do polígono.");
// }
//
//// Defina a cor de preenchimento e preencha o polígono
// Color minhaCor = new Color(255, 0, 255);
// g2d.setColor(minhaCor);
// g2d.fill(polygon);
//
//// Defina a cor da linha e desenhe o contorno do polígono
// g2d.setColor(Color.BLACK);
// g2d.draw(polygon);

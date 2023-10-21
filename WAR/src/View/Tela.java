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
		count_images_loaded(new ImagemInfo ("war_tabuleiro_linhas.png",0,0,1024,768));
		
		terras = new DesenhaTerritorioPoligono[51];
		// America do Sul
		Color padrao = new Color(65,65,65);
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{274,332,326,343,336,315,306,291,285,254,234},new int[]{500,500,487,457,441,441,421,418,402,394,430}, padrao, "Brasil"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{275,235,278,294,281,311,303,334},new int[]{500,569,645,645,619,567,554,500}, padrao, "Argentina"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{197,202,218,232,227,240,274,234},new int[]{494,503,503,532,540,558,499,431}, padrao, "Peru"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{253,194,162,176,189,197},new int[]{394,394,450,477,477,490}, padrao, "Venezuela"));
		// America do Norte
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{90,83,104,110,102,105,135,146,161,171,180,189,183,178,171,174,166,171,164,162,152,126},new int[]{305,318,353,341,326,318,371,372,401,403,415,402,394,392,385,378,365,356,344,349,350,305}, padrao, "México"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{107,84,90,78,90,124,176},new int[]{215,255,263,284,305,306,216}, padrao, "Califórnia"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{178,126,145,201,230,244},new int[]{215,305,337,243,242,216}, padrao, "Texas"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{125,111,119,103,108,213,230,222,146},new int[]{134,161,177,206,214,214,186,172,171}, padrao, "Vancouver"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{202,165,181,202,210,200,206,213,230,237,244,259,278,290,295,246,230,202},new int[]{242,303,304,342,332,313,301,301,273,273,258,258,226,225,216,216,241,243}, padrao, "Nova York"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{232,215,294,302,316,314,323,328,322,331,337,344,340,321,318,289,283,273,262},new int[]{185,214,214,202,202,208,208,198,186,173,178,165,158,159,155,156,166,166,185}, padrao, "Quebec"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{87,78,70,59,111,133},new int[]{118,137,138,161,161,119}, padrao, "Alasca"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{135,127,146,221,230,244,258,282,271,243,231,213,208,153,149},new int[]{119,134,170,173,158,157,134,133,112,112,134,134,127,127,120}, padrao, "Calgary"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{286,272,282,330,334,350,363,370,380,370},new int[]{90,111,133,134,144,144,116,116,102,90}, padrao, "Groenlândia"));
		// Africa
		
		// Europa
		
		// Asia
		
		// Oceania
		
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


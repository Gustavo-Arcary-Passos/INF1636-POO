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
		//count_images_loaded(new ImagemInfo ("war_tabuleiro_linhas.png",0,0,1024,768));
		count_images_loaded(new ImagemInfo ("war_tabuleiro_mapa copy.png",0,0,1024,768));
		
		terras = new DesenhaTerritorioPoligono[51];
		// America do Sul
		Color padrao = new Color(65,65,65);
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{274,332,326,343,336,315,306,291,285,254,234},new int[]{500,500,487,457,441,441,421,418,402,394,430}, padrao, "Brasil"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{275,235,278,294,281,311,303,334},new int[]{500,569,645,645,619,567,554,500}, padrao, "Argentina"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{196,201,218,232,227,240,274,234},new int[]{494,503,503,532,540,558,499,431}, padrao, "Peru"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{253,194,162,176,189,197},new int[]{394,394,450,477,477,490}, padrao, "Venezuela"));
		// America do Norte
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{90,83,104,110,102,105,135,146,162,171,180,189,183,178,171,174,166,171,164,162,152,126},new int[]{305,318,353,341,326,318,371,372,404,404,415,402,394,392,385,378,365,356,344,349,350,305}, padrao, "México"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{107,84,90,78,90,124,176},new int[]{215,255,263,284,305,306,216}, padrao, "Califórnia"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{178,126,146,201,230,244},new int[]{215,305,338,243,242,216}, padrao, "Texas"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{125,111,119,103,108,213,230,222,146},new int[]{134,161,177,206,216,216,186,172,172}, padrao, "Vancouver"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{202,165,181,203,211,200,207,215,232,237,244,261,280,292,297,246,230,202},new int[]{242,304,304,344,334,313,301,301,274,274,260,260,227,227,217,217,242,242}, padrao, "Nova York"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{230,213,295,303,316,314,325,329,322,331,337,344,340,321,318,289,283,273,262},new int[]{185,216,216,202,202,210,210,198,186,173,178,165,158,159,155,156,166,166,185}, padrao, "Quebec"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{87,78,70,59,111,133},new int[]{119,137,138,163,163,119}, padrao, "Alasca"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{133,125,146,222,231,245,258,282,271,243,231,213,208,153,149},new int[]{118,134,172,172,158,158,134,134,112,112,134,134,127,127,118}, padrao, "Calgary"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{286,272,282,330,334,350,365,372,380,370},new int[]{90,111,134,134,144,144,116,116,102,90}, padrao, "Groenlândia"));
		// Africa
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{529,557,596,606,614,626,617},new int[]{542,594,594,579,579,555,542}, padrao, "África do Sul"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{520,514,535,530,574,598,587},new int[]{478,488,523,540,540,498,478}, padrao, "Angola"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{426,447,503,520,586,547},new int[]{405,447,447,477,477,406}, padrao, "Nigéria"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{437,410,426,514,538,498,493,481,474},new int[]{333,378,405,405,360,360,346,346,333}, padrao, "Argélia"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{542,515,547,562,622,594,597,589},new int[]{355,405,405,432,432,380,373,355}, padrao, "Egito"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{563,600,575,618,642,652,671,638,623},new int[]{433,498,540,540,497,497,460,460,433}, padrao, "Somália"));
		// Europa
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{441,438,428,423,440,448,450,452,447},new int[]{172,178,178,192,192,185,185,180,172}, padrao, "Reino Unido"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{460,450,459,453,463,459,450,445,483,490,483,470,482,474,482},new int[]{141,158,158,170,182,190,190,205,205,192,192,170,150,150,141}, padrao, "Reino Unido"));
//		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{},new int[]{}, padrao, "França"));
//		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{},new int[]{}, padrao, "Espanha"));
//		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{},new int[]{}, padrao, "Itália"));
//		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{},new int[]{}, padrao, "Suécia"));
//		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{},new int[]{}, padrao, "Polônia"));
//		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{},new int[]{}, padrao, "Romênia"));
//		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{},new int[]{}, padrao, "Ucrânia"));
		// Oceania
		
		// Asia
		
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


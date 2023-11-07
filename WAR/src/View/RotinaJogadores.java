package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.geom.Rectangle2D;

// import javax.swing.JButton;


class RotinaJogadores {
	private static RotinaJogadores instance = null;
	protected List<ImagemInfo> layout_jogador = new ArrayList<>();
	protected List<String> rotina = new ArrayList<>(Arrays.asList("PER", "PE", "ATQ", "REP", "PASS"));
	protected String layout_selected;
	protected String atacante;
	protected String atacado;
	protected String terr;
	protected int qtd_exerc,qtd_exerc_min,qtd_exerc_max;
	
	public static RotinaJogadores getInstance() {
        if (instance == null) {
            instance = new RotinaJogadores();
        }
        return instance;
    }
	
	public RotinaJogadores () {
		layout_jogador.add(new ImagemInfo ("layout_default_jogador.png",322,620,364,200,"Layout Default"));
		layout_jogador.add(new ImagemInfo ("layout_distribui_exercitos_jogador.png",322,620,364,200,"Distribui Exercitos"));
		layout_jogador.add(new ImagemInfo ("layout_nver_cartas_jogador.png",322,620,364,200,"Layout nao ver cartas"));
		layout_jogador.add(new ImagemInfo ("layout_ver_cartas_jogador.png",322,620,364,200,"Layout ver cartas"));
		layout_jogador.add(new ImagemInfo ("layout_ataque_pass_jogador.png",322,620,364,200,"Layout ataque pass"));
		layout_jogador.add(new ImagemInfo ("layout_ataque_jogador.png",322,620,364,200,"Layout ataque"));
		layout_jogador.add(new ImagemInfo ("layout_reposiciona_pass_jogador.png",322,620,364,200,"Layout reposiciona pass"));
		this.set_layout("Layout nao ver cartas");
	}
	
	public void set_layout(String tipo) {
		layout_selected = tipo;
	}
	
	public String get_layout() {
		return layout_selected;
	}
	
	public void set_qtd_exerc(int pos,int qtd) {
		if(pos == 0) {
			qtd_exerc = qtd;
		}else if(pos == 1) {
			qtd_exerc_min = qtd;
		}else if(pos == 2) {
			qtd_exerc_max = qtd;
		}
	}
	
	public int get_qtd_exerc(int pos) {
		if(pos == 0) {
			return qtd_exerc;
		}else if(pos == 1) {
			return qtd_exerc_min;
		}else if(pos == 2) {
			return qtd_exerc_max;
		}
		return -1;
	}
	
	public String get_terr(int pos) {
		if(pos == 0) {
			return terr;
		}else if(pos == 1) {
			return atacante;
		}else if(pos == 2) {
			return atacado;
		}
		return null;
	}
	
	public void set_terr(String value,int pos) {
		if(pos == 0) {
			terr = value;
		}else if(pos == 1) {
			atacante = value;
		}else if(pos == 2) {
			atacado = value;
		}
	}
	
	public void show_layout(Graphics g) {
		for(ImagemInfo layout : layout_jogador) {
			if(layout.get_name() == layout_selected) {
				if(layout_selected == "Distribui Exercitos") {
					// 436, 654
					// 562, 672
					Graphics2D g2d = (Graphics2D) g;
					g2d.setColor(Color.WHITE);
					Rectangle2D rect = new Rectangle2D.Double(436, 654, 128, 18);
					g2d.fill(rect);
					g2d.setColor(Color.BLACK);
					Font minhaFonte = new Font("Dialog", Font.BOLD, 13);
					drawStringCentralized(minhaFonte,128,18,654-2,436,g,this.terr);
					g2d.setColor(Color.WHITE);
					rect = new Rectangle2D.Double(458, 688, 84, 84);
					g2d.fill(rect);
					g2d.setColor(Color.BLACK);
					Font fonteExerc = new Font("Dialog", Font.BOLD, 24);
					drawStringCentralized(fonteExerc,84,84,688-4,458,g,Integer.toString(qtd_exerc));
				}
		    	g.drawImage(layout.get_image(), layout.get_x(), layout.get_y(), layout.get_w(), layout.get_h(), null);
			}
		}
	}
	public void drawStringCentralized(Font fonte,int retanguloLargura,int retanguloAltura,int retanguloY,int retanguloX,Graphics g,String texto) {
		FontMetrics fontMetrics = g.getFontMetrics(fonte);
		g.setFont(fonte);
        int larguraTexto = fontMetrics.stringWidth(texto);
        int alturaTexto = fontMetrics.getAscent();
        int x = retanguloX + (retanguloLargura - larguraTexto) / 2;
        int y = retanguloY + (retanguloAltura + alturaTexto) / 2;
        g.drawString(texto, x, y);
	}
}

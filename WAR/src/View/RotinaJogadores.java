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


class RotinaJogadores {
	private static RotinaJogadores instance = null;
	protected List<ImagemInfo> layout_jogador = new ArrayList<>();
	protected List<String> rotina = new ArrayList<>(Arrays.asList("PER", "PE", "ATQ", "REP", "PASS"));
	protected List<String> lista_carta; // alterei 
	protected String layout_selected;
	protected String atacante;
	protected String atacado;
	protected String terr;
	protected int qtd_exerc,qtd_exerc_min,qtd_exerc_max;
	protected boolean objetivo;
	protected String objetivo_jog;
	
	public void set_objetivo(String name) {
		objetivo_jog = name;
	}
	
	public void set_objetivo_status(boolean status) {
		objetivo = status;
	}
	
	public boolean get_objetivo_status() {
		return objetivo;
	}
	
	public List<String> get_lista_carta (){
		return this.lista_carta;
	}
	
	public void set_lista_carta (List<String> jogador_cartas){
		this.lista_carta = jogador_cartas;
	}
	
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
		Graphics2D g2d = (Graphics2D) g;
		for(ImagemInfo layout : layout_jogador) {
			if(layout.get_name() == layout_selected) {
				if(layout_selected == "Distribui Exercitos") {
					// 436, 654
					// 562, 672
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
				} else if(layout_selected == "Layout ataque") {
					// 362,697,479,781
					g2d.setColor(Color.WHITE);
					Rectangle2D atacando_rect = new Rectangle2D.Double(362,697, 118, 84);
					g2d.fill(atacando_rect);
					g2d.setColor(Color.BLACK);
					Font minhaFonte = new Font("Dialog", Font.BOLD, 13);
					drawStringCentralized(minhaFonte,118,84,697,362,g,this.atacante);
					// 532,697,649,781
					g2d.setColor(Color.WHITE);
					Rectangle2D atacado_rect = new Rectangle2D.Double(532,697, 118, 84);
					g2d.fill(atacado_rect);
					g2d.setColor(Color.BLACK);
					drawStringCentralized(minhaFonte,118,84,697,532,g,this.atacado);
				}
		    	g.drawImage(layout.get_image(), layout.get_x(), layout.get_y(), layout.get_w(), layout.get_h(), null);
				if(layout_selected == "Layout nao ver cartas") {
					// PODE COLOCAR AS IMAGENS AQUI E USAR UM AS CARTAS DE COSTAS 
//					lista_carta.clear();
//					lista_carta.add("Egito");
//					lista_carta.add(null);
//					lista_carta.add("Perth");
//					System.out.println("Lista de cartas: " + lista_carta.toString());


					int desloc_x = 0; // usada para desenhar cada carta no lugar certo
					for (String carta : lista_carta)
					{
						
						if (carta != null) {
							System.out.println(carta);
							carta = "Verso";
						}  // se ela existe "vira do avesso"

						CartaInfo cartaInfo = CartasView.get_carta(carta); // a unica diferença é que mostra todas as cartas de costas
						if (cartaInfo != null)
						{
							g.drawImage(cartaInfo.get_image(), 342 + desloc_x, 693, 50, 80, null); // coordenada inicial
							// System.out.println(cartaInfo.get_name());
						}

						desloc_x += 70; // calculado na mão
					}
				} else if(layout_selected == "Layout ver cartas") {
					// PODE COLOCAR AS IMAGENS AQUI E USAR UMA List<String> para saber quais cartas carregar
					// lista_carta.clear();
					// lista_carta.add("Egito");
					// lista_carta.add("Perth");
					//System.out.println("Lista de cartas: " + lista_carta.toString());


					int desloc_x = 0; // usada para desenhar cada carta no lugar certo
					CartasView.clear_cartas_na_tela(); // limpa as cartas na tela
					for (String carta : lista_carta)
					{
						CartaInfo cartaInfo = CartasView.get_carta(carta); // <-- aqui pegamos a carta de frente
						if (cartaInfo != null)
						{
							CartasView.add_carta_na_tela(cartaInfo); // diz ao cartas view q tem uma nova carta na tela
							cartaInfo.draw_store(g, 342 + desloc_x, 693, 50, 80, null); // coord inicial + desloc
							// desenha e guarda as coordenadas para fazer a detecao do clique
						}

						desloc_x += 70; // calculado na mão
					}
				}
			}
		}
		if(objetivo) {
			g2d.setColor(new Color(0,0,0,225));
			Rectangle2D atacado_rect = new Rectangle2D.Double(0,0,1024,800);
			g2d.fill(atacado_rect);
			CartaInfo objetivo_card = CartasView.get_carta(objetivo_jog);
			int factor_mult = 6;
			int factor_div = 4;
			g.drawImage(objetivo_card.get_image(), 1024/2-objetivo_card.get_w()/2*factor_mult/factor_div, 800/2-objetivo_card.get_h()/2*factor_mult/factor_div, objetivo_card.get_w()*factor_mult/factor_div, objetivo_card.get_h()*factor_mult/factor_div, null);
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

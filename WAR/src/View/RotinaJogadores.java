package View;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;


class RotinaJogadores {
	private static RotinaJogadores instance = null;
	protected List<ImagemInfo> layout_jogador = new ArrayList<>();
	protected List<String> rotina = new ArrayList<>(Arrays.asList("PER", "PE", "ATQ", "REP", "PASS"));
	protected String layout_selected;
	
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
	}
	
	public void set_layout(String tipo) {
		layout_selected = tipo;
	}
	
	public void show_layout(Graphics g) {
		for(ImagemInfo layout : layout_jogador) {
			if(layout.get_name() == layout_selected) {
		    	g.drawImage(layout.get_image(), layout.get_x(), layout.get_y(), layout.get_w(), layout.get_h(), null);
			}
		}
	}
}

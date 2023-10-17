package View;

import javax.swing.*;
import java.awt.*;

public class Tela extends JFrame {
	public final int LARG_DEFAULT=1200;
	public final int ALT_DEFAULT=700;
	public Tela() {
		setSize(LARG_DEFAULT,ALT_DEFAULT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(new Color(0, 0, 0));
		ImageIcon imagemIcon = new ImageIcon("WAR-Imagens/images/war_tabuleiro_fundo.png");
        Image imagem = imagemIcon.getImage();
        int larguraNova = 768; // Largura desejada
        int alturaNova = 576;
        ImageIcon mapa_mundo = new ImageIcon("WAR-Imagens/images/war_tabuleiro_mapacopy.png");
        Image mapa = mapa_mundo.getImage();
        

        // Criando um JLabel para exibir a imagem
        JLabel imagemLabel = new JLabel(new ImageIcon(imagem));
        JLabel mapaLabel = new JLabel(new ImageIcon(mapa));
        add(imagemLabel); // Adiciona o JLabel ao JFrame
        add(mapaLabel);
	}
}
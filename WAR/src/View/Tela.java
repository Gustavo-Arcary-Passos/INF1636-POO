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
		ImageIcon imagemIcon = new ImageIcon(""); // Substitua pelo caminho da sua imagem
        Image imagem = imagemIcon.getImage();

        // Criando um JLabel para exibir a imagem
        JLabel imagemLabel = new JLabel(new ImageIcon(imagem));
        add(imagemLabel); // Adiciona o JLabel ao JFrame

	}
}
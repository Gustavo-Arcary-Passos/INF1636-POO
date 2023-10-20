package View;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.awt.Graphics;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Tela frame = buildFrame();

        final BufferedImage plano_de_fundo = ImageIO.read(new File("WAR/src/View/imagens/war_tabuleiro_fundo.png"));
		final BufferedImage war_mapa = ImageIO.read(new File("WAR/src/View/imagens/war_tabuleiro_mapacopy.png"));

        JPanel pane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(plano_de_fundo, 0, 0, null);
				g.drawImage(war_mapa, 0, 0, null);
            }
        };


        frame.add(pane);
    }


    private static Tela buildFrame() {
        Tela frame = new Tela();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(1024, 768);
        frame.setVisible(true);
		frame.addComponentListener(new ResizeListener());
        return frame;
    }
}

class ResizeListener extends ComponentAdapter {
        public void componentResized(ComponentEvent e) {
            System.out.println("mudou o tamanho da janela");
        }
}
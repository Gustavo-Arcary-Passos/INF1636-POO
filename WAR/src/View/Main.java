package View;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    public static void main(String[] args) {
    	Tela f = new Tela();
        f.setTitle("Minha Primeira GUI");
        f.setVisible(true);
        f.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                System.out.printf(x + ",");
            }
        });
    }
}

package View;

import javax.swing.*;
import java.util.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class Main {
    public static void main(String[] args) {
    	Tela f = new Tela();
        f.setTitle("Minha Primeira GUI");
        f.setVisible(true);
        Dado.interpreta_lancamento(new ArrayList<Integer>(Arrays.asList(1,2,3)), new ArrayList<>(Arrays.asList(1,2,3)), "vermelho");
    }
}

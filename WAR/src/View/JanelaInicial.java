package View;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.*;
import java.util.List;

class JanelaInicial extends LoadScene{
	protected static boolean select_number;
	protected static List<String> colorido = new ArrayList<>(Arrays.asList("azul", "verde", "vermelho", "branco", "preto", "amarelo"));
	
	//protected static List<Color> colorido_resp = new ArrayList<>(Arrays.asList(Color.BLUE,Color.GREEN,Color.RED,Color.WHITE,Color.BLACK,Color.YELLOW));
	protected static int num_jogadores;
	protected static boolean escolhendo_cores;
	public JanelaInicial(Tela tela) {
		Container c = tela.getContentPane();
		c.setLayout(null);
        JButton b1 = new JButton("Novo Jogo");

        b1.setBounds(50, 50, 100, 30);
        b1.setToolTipText("Novo Jogo");
        b1.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeComponents(tela);
                escolhe_qtd_jogadores(tela);
            }
        });
        c.add(b1); 
	}
	private static void removeComponents(Tela tela) {
		tela.getContentPane().removeAll(); 
    }
	private static void escolhe_qtd_jogadores(Tela tela) {
		Container c = tela.getContentPane();
		JButton b1 = new JButton("3"); 
		b1.setBounds(50, 50, 100, 30);

        b1.addActionListener(new ActionListener() {
            int valor = 3; 

            @Override
            public void actionPerformed(ActionEvent e) {
                valor++; 
                if (valor > 6) {
                    valor = 3; 
                }
                b1.setText(Integer.toString(valor)); 
            }
        });
        JButton b2 = new JButton("Confirmar");
        b2.setBounds(50, 100, 100, 30);
        b2.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JanelaInicial.set_num_jogadores(b1.getText());
                removeComponents(tela);
                JanelaInicial.set_escolhendo_cores(true);
                escolhe_nome_jogadores_cor(tela);
                tela.repaint();
                //System.out.println(JanelaInicial.get_num_jogadores());
            }
        });
        c.add(b1);
        c.add(b2);
        c.repaint(); 
	}
	private static void escolhe_nome_jogadores_cor(Tela tela) {
		Container c = tela.getContentPane();
	    JLabel ln = new JLabel("Nome");
	    JTextField nm = new JTextField();
	    JButton inc = new JButton("Confirmar");
	    ln.setBounds(40, 83, 65, 25);
	    nm.setBounds(110, 80, 250, 25);
	    inc.setBounds(295, 270, 65, 25);

	    JRadioButton[] op_cores = new JRadioButton[colorido.size()];
	    ButtonGroup bg = new ButtonGroup();

	    for (int i = 0; i < colorido.size(); i++) {
	        op_cores[i] = new JRadioButton(colorido.get(i));
	        op_cores[i].setBounds(50, 120 + 30 * i, 100, 30);
	        bg.add(op_cores[i]);
	        c.add(op_cores[i]);
	    }

	    inc.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	boolean algumSelecionado = false;

	        	for (JRadioButton radioButton : op_cores) {
	        	    if (radioButton.isSelected()) {
	        	        algumSelecionado = true;
	        	        break; // Se um está selecionado, não é necessário continuar verificando
	        	    }
	        	}
	        	if(algumSelecionado && !nm.getText().isEmpty()) {
		            removeComponents(tela);
		            if (JanelaInicial.get_num_jogadores() > 1) {
		                for (int i = 0; i < colorido.size(); i++) {
		                    if (op_cores[i].isSelected()) {
		                        colorido.remove(colorido.get(i));
		                    }
		                }
		                JanelaInicial.set_num_jogadores(JanelaInicial.get_num_jogadores() - 1);
		                escolhe_nome_jogadores_cor(tela);
		            } else {
		            	tela.trocarParaJanelaJogo();
		            }
		            c.repaint();
	        	}
	        }
	    });
	    c.add(ln);
	    c.add(nm);
	    c.add(inc);
	    c.repaint();
	}

	public static int get_num_jogadores() {
		return num_jogadores;
	}
	public static void set_num_jogadores(String number) {
		num_jogadores = Integer.parseInt(number);
	}
	public static void set_num_jogadores(int number) {
		num_jogadores = number;
	}
	public static void set_escolhendo_cores(boolean status) {
		escolhendo_cores = status;
	}
	
	public void desenha(Graphics g) {
		
	}
}

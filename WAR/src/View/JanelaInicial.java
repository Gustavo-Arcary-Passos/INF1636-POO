package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

class JanelaInicial extends LoadScene{
	protected static boolean select_number;
	protected static String[] cores = {"azul","verde","vermelho","branco","preto","amarelo"};
	protected static Color[] cores_rep = {Color.BLUE,Color.GREEN,Color.RED,Color.WHITE,Color.BLACK,Color.YELLOW};
	protected static int num_jogadores;
	protected static boolean escolhendo_cores;
	public JanelaInicial(Container c) {
		c.setLayout(null);
        JButton b1 = new JButton("Novo Jogo");

        b1.setBounds(50, 50, 100, 30);
        b1.setToolTipText("Novo Jogo");
        b1.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeComponents(c);
                escolhe_qtd_jogadores(c);
            }
        });
        c.add(b1); 
	}
	private static void removeComponents(Container c) {
        Component[] components = c.getComponents();
        for (Component component : components) {
            if (component instanceof Container) {
                removeComponents((Container) component); 
            }
            c.remove(component);
        }
        c.revalidate(); 
    }
	private static void escolhe_qtd_jogadores(Container c) {
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
                removeComponents(c);
                JanelaInicial.set_escolhendo_cores(true);
                escolhe_nome_jogadores_cor(c);
                c.repaint();
                //System.out.println(JanelaInicial.get_num_jogadores());
            }
        });
        c.add(b1);
        c.add(b2);
        c.repaint(); 
	}
	private static void escolhe_nome_jogadores_cor(Container c) {
		c.setLayout(null);
		JLabel ln=new JLabel("Nome");
		JTextField nm=new JTextField();
		JButton inc=new JButton("Confirmar");
		ln.setBounds(40,83,65,25);
		nm.setBounds(110,80,250,25);
		inc.setBounds(295,270,65,25);
		inc.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	removeComponents(c);
            	if(JanelaInicial.get_num_jogadores() > 1) {
            		JanelaInicial.set_num_jogadores(JanelaInicial.get_num_jogadores()-1);
	                escolhe_nome_jogadores_cor(c);
            	}
            	 c.repaint();
                //System.out.println(JanelaInicial.get_num_jogadores());
            }
        });
		JRadioButton[] op_cores= new JRadioButton[cores.length];
		ButtonGroup bg = new ButtonGroup();
		for(int i = 0;i<cores.length;i++) {
			op_cores[i] = new JRadioButton(cores[i]);
			op_cores[i].setBounds(50,120+30*i,100,30);
			bg.add(op_cores[i]);
			c.add(op_cores[i]);
		}
		
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
		if(JanelaInicial.escolhendo_cores == true) {
			Graphics2D g2d = (Graphics2D) g;
			for(int i = 0;i<cores.length;i++) {
				Rectangle2D rt=new Rectangle2D.Double(150,120+30*i,30,30);
				g2d.setPaint(cores_rep[i]);
				g2d.fill(rt);
				g2d.setPaint(Color.BLACK);
				g2d.draw(rt);
			}
		}
	}
}

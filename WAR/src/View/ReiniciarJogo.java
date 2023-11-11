package View;

import javax.swing.JOptionPane;

class ReiniciarJogo extends JOptionPane {
	public ReiniciarJogo (String nome) {
		JOptionPane.showMessageDialog(null, "Parabens " + nome + "!!!", "Vencedor", JOptionPane.INFORMATION_MESSAGE);
	}
}

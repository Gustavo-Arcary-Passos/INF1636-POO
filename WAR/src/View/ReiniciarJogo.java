package View;

import javax.swing.JOptionPane;

class ReiniciarJogo {
	
	public ReiniciarJogo (String nome) {
		JOptionPane.showMessageDialog(null, "Parabens " + nome + "!!!", "Vencedor", JOptionPane.INFORMATION_MESSAGE);
		int resposta = JOptionPane.showConfirmDialog(null, "Clique em OK para continuar a jogar.", "Reiniciar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if (resposta == JOptionPane.OK_OPTION) {
            // O usuário clicou em "OK"
            System.out.println("Reiniciar.");
        } else {
            System.out.println("Encerrar.");
        }
	}
}

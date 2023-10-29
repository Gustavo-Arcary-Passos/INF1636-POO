package View;

import javax.swing.JOptionPane;

class ReiniciarJogo {
	
	public ReiniciarJogo (String nome) {
		JOptionPane.showMessageDialog(null, "Parabens " + nome + "!!!", "Vencedor", JOptionPane.INFORMATION_MESSAGE);
		int resposta = JOptionPane.showConfirmDialog(null, "Clique em OK para continuar a jogar.", "Reiniciar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if (resposta == JOptionPane.OK_OPTION) {
            // O usuário clicou em "OK"
            System.out.println("Reiniciar.");
            // Coloque aqui o código que você deseja executar após o clique em "OK".
        } else {
            // O usuário clicou em "Cancelar" ou fechou a janela
            System.out.println("Encerrar.");
            // Coloque aqui o código para ação alternativa ou saída.
        }
	}
}

package Controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import Model.Api_model;
import View.Api_view;

public class Controlador {
	Api_model jogo;
	Api_view tela;
	
	public Controlador() {
		jogo = Api_model.getInstance();
    	tela = new Api_view();
    	listener_JanelaJogo(); // Inicializa jogadores, sorteia objetivo
	}
	
	public void listener_JanelaJogo() {
		ActionListener actionListenerClasseControle = new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	if(tela.get_num_jogador() == 0) {
			    	List<String> jogadores = tela.get_jogadores();
			    	List<String> cores = tela.get_cores();
			    	
			    	for(int i = 0; i < jogadores.size(); i++) {
						String nome = jogadores.get(i);
				        String cor = cores.get(i);
						System.out.println("Jogador " + (i + 1) + ": Nome = " + nome + ", Cor = " + cor);
						jogo.add_jogador(nome,cor);
					}
			    	
			    	jogo.sorteia_obj_todos_jogadores(jogo.jogadores_ativos,jogo.deckobj);
			    	tela.set_jogador_vez(jogo.get_vez_jogador_color());
			    	jogo.sorteia_todos_territorios(jogo.mapa_mundo, jogo.jogadores_ativos);
			    }
		    }
		};
		
		tela.get_button(0, 4).addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	tela.salva_jogador().actionPerformed(e);
		    	actionListenerClasseControle.actionPerformed(e);
		    }
		});
	}
}

package Controller;

//import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import Model.Api_model;
import View.Api_view;

public class Controlador {
	Api_model jogo;
	Api_view tela;
	
	public Controlador() {
		jogo = Api_model.getInstance();
    	tela = new Api_view();
    	listener_JanelaInicial(); // Inicializa jogadores, sorteia objetivo
	}
	
	public void listener_JanelaInicial() {
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
			    	jogo.sorteia_todos_territorios(jogo.mapa_mundo, jogo.jogadores_ativos);
			    	tela.set_jogador_vez(jogo.get_vez_jogador_color());
			    	tela.set_cartas(jogo.get_vez_jogador_cartas());
			    	jogo.get_vez_jogador_add_exercito();
			    	listener_JanelaJogo();
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
	
	public void listener_JanelaJogo() {
		tela.set_tela_mouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	int x = e.getX();
	            int y = e.getY();
	            System.out.println(x+", "+y);
	            //cenario++;
	            tela.Dado_verifica_ligado();
	            if (e.getButton() == MouseEvent.BUTTON1 && tela.get_fase_atual() == "PER") {
	            	if(jogo.verifica_territorio_jogador(tela.verifica_territorio_clicado(x,y)) && tela.get_rotina_atual() != "Distribui Exercitos"){
	            		tela.set_rotina_atual("Distribui Exercitos");
	            		tela.repinta_tela();
	            		tela.create_numero_exercitos_text(tela.verifica_territorio_clicado(x,y));
	            	} else if (x > 322 && y > 620 && x < 686 && y < 800) {
	            		if(x > 575 && y > 709 && x < 619 && y < 750) {
	            			tela.change_numero_exercitos_text(1,jogo.get_vez_jogador_exercitos_distri());
	            		} else if(x > 380 && y > 718 && x < 424 && y < 741) {
	            			tela.change_numero_exercitos_text(-1,jogo.get_vez_jogador_exercitos_distri());
	            		}
	            	} else if (tela.get_rotina_atual() != "Layout Default" && !jogo.verifica_territorio_jogador(tela.verifica_territorio_clicado(x,y))) {
	            		tela.delete_numero_exercitos_text();
	            		tela.set_rotina_atual("Layout Default");
	            		tela.repinta_tela();
	            	} else if (jogo.verifica_territorio_jogador(tela.verifica_territorio_clicado(x,y))) {
	            		tela.change_name_terr_text(tela.verifica_territorio_clicado(x,y));
	            	}
	            	//	            	
//            		tela.change_name_terr_text(tela.verifica_territorio_clicado(x,y));
		            //tela.repaint();
	            } else if (e.getButton() == MouseEvent.BUTTON3) {
	            	// ReiniciarJogo ganhador = new ReiniciarJogo("Jorge");
	            }
            }
        });
		// Fornecer exercitos para o jogador da vez
		// Criar layout de distribuicoes de tropas
		// Criar layout de exibicao de cartas
		// Criar mecanismo para verificar se o pais clicado pertence ao jogador
		// Se pertencer abrir layout de distribuicao de exercitos
		// Se nao pertencer nao fazer nada
		// Quando nao estiver com um pais selecionado exibir layout de cartas
		// Verificar se todas as tropas foram distribuidas e mudar para layout de ataque
		// Se for primeira rodada trocar para proximo jogador
		// Criar layout de ataque (selecionar pais que atacara, e selecionar pais que sera atacado)
		// Criar botao para confirmar ataque e rolar os dados
		// Criar botao para passar para fase de reposicionamento de exercitos
		// Criar layout de reposicionamento de exercitos
		// Primeiro clique em pais define qual pais ira passar as tropas (Verificar se pertence ao jogador)
		// Segundo pais define para qual as tropas irao (Verificar se pertence ao jogador)
		// Se estiver correto abrir layout de reposicionar tropas
		// Se estiver incorreto resetar selecao
		// Criar button para passar a vez para proximo jogador
		// Ao clicar nesse button,antes verificar se o jogador em questao conclui seu objetivo, 
		// depois mudar a vez para proximo jogador verificar se deve mudar a rodada (feito no model) 
	}
}

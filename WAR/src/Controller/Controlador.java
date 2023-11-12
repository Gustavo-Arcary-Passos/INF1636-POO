package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JOptionPane;

import Model.Api_model;
import Model.Observador;
import View.Api_view;

public class Controlador {
	Api_model jogo;
	Api_view tela;
	
	/**
	 * Instancia o controlador e inicializa a tela (api view) e o jogo (api model)
	 * Adiciona o observador do dado na lista de observadores do dado
	 * Adiciona os observadores de exercitos na lista de observadores de exercitos
	 * 
	 * roda a rotina de inicializacao da janela inicial (inciar jogo, sortear objetivo)
	 */
	public Controlador() {
    	tela = new Api_view();
    	jogo = Api_model.getInstance();
    	Observador view_do_dado = Api_view.Instancia_Observador("DadoView");
    	jogo.add_dado_view(view_do_dado);
    	jogo.add_observadores_exercitos(tela.get_janelajogo());
    	listener_JanelaInicial(); // Inicializa jogadores, sorteia objetivo
	}
	

	/**
	 * Listener da janela inicial
	 * 
	 * Cria um action listener para o botao de iniciar jogo
	 * Sorteia tudo e depois chama o listener da janela de jogo
	 */
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
			    	// Rotina de inicio da vez do jogador
			    	tela.set_jogador_vez(jogo.get_vez_jogador_color());
			    	tela.set_cartas(jogo.get_vez_jogador_cartas());
			    	jogo.get_vez_jogador_add_exercito();
			    	tela.set_objetivo_jogador_da_vez(jogo.get_obj_jgd_da_vez());
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
	            //System.out.println(x+", "+y);
	            //cenario++;
	            tela.Dado_verifica_ligado();
	            if(tela.get_look_objetivo()) {
	            	tela.set_look_objetivo(!tela.get_look_objetivo());
	            	tela.repinta_tela();
	            } else {
	            	if(tela.verifica_objetivo_clicado(x,y)) {
	            		tela.set_look_objetivo(!tela.get_look_objetivo());
		            	tela.repinta_tela();
	            		return;
	            	}
		            if (e.getButton() == MouseEvent.BUTTON1 && (tela.get_fase_atual() == "PER" || tela.get_fase_atual() == "PE")) {
		            	if(tela.get_fase_atual() == "PER") {
		            		if(jogo.get_vez_jogador_exercitos_reg() == 0) {
	            				tela.set_next_rotina();
	            				if(jogo.get_vez_jogador_exercitos_distri() == 0) {
		            				tela.set_next_rotina();
		            				if(tela.get_fase_atual() == "ATQ")
		            				tela.set_rotina_layout("Layout ataque pass");
		            			}
	            				//System.out.println("PER -> PE");
	            			} else {
	            				if(jogo.verifica_territorio_jogador_reg(tela.verifica_territorio_clicado(x,y)) && tela.get_rotina_atual() != "Distribui Exercitos" && jogo.get_vez_jogador_num_cartas() != 5) {
	            					tela.set_rotina_atual("Distribui Exercitos");
	    		            		tela.repinta_tela();
	    		            		tela.create_numero_exercitos_text(tela.verifica_territorio_clicado(x,y),0);
	            				} else if (x > 322 && y > 620 && x < 686 && y < 800) {
	            					// verificar daqui pra baixo
	    		            		if(tela.get_rotina_atual() == "Distribui Exercitos") {
	    		            			if(x > 575 && y > 709 && x < 619 && y < 750) {
	    			            			tela.change_numero_exercitos_text(1,jogo.get_vez_jogador_exerc_reg(tela.get_terr_sel(0)),0);
	    			            		} else if(x > 380 && y > 718 && x < 424 && y < 741) {
	    			            			tela.change_numero_exercitos_text(-1,jogo.get_vez_jogador_exerc_reg(tela.get_terr_sel(0)),0);
	    			            		}
	    			            		if(tela.verifica_ok_clicado(x,y)) {
	    			            			int qtd = tela.get_qtd_exerc_sel();
	    			            			//System.out.println("OK");
	    			            			if(qtd > 0) {
	    				            			jogo.posiciona_exercitos_reg_jogador_vez(qtd,tela.get_terr_sel(0));
	    				            			tela.set_rotina_layout("Layout nao ver cartas");
	    				            			if(jogo.get_vez_jogador_exercitos_reg() == 0) {
	    				            				tela.set_next_rotina();
	    				            			}
	    			            			}
	    			            		}
	    		            		} else if (tela.get_rotina_atual() == "Layout nao ver cartas") {
	    		            			if(x > 412 && y > 637 && x < 458 && y < 666)
	    		            				tela.set_rotina_layout("Layout ver cartas");
	    		            		} else if (tela.get_rotina_atual() == "Layout ver cartas") {
	    		            			if(x > 412 && y > 637 && x < 458 && y < 666) {
	    		            				tela.reset_all_selected();
	    		            				tela.set_rotina_layout("Layout nao ver cartas");
	    		            			} else if(tela.verifica_trocar_carta_clicado(x,y)) {
	    		            				List<String> cartas = tela.show_selected();
	    		            				System.out.println(cartas);
		    		            			if(tela.qtd_selected() == 3) {
		    		            				jogo.jogador_vez_troca_cartas_exerc(cartas);
		    		            				tela.set_cartas(jogo.get_vez_jogador_cartas());
		    		            			}
		    		            			tela.reset_all_selected();
	    		            				tela.repinta_tela();
	    		            			} else {
	    		            				tela.verifica_carta_clicada(x,y);
	    		            				//System.out.println("CARTA CLICADA: " + tela.verifica_carta_clicada(x,y));
	    		            			}
	    		            		}
	    		            		
	    		            	} else if (tela.get_rotina_atual() == "Distribui Exercitos" && !jogo.verifica_territorio_jogador_reg(tela.verifica_territorio_clicado(x,y))) {
	    		            		tela.set_rotina_layout("Layout nao ver cartas");
	    		            	} else if (jogo.verifica_territorio_jogador_reg(tela.verifica_territorio_clicado(x,y))) {
	    		            		tela.change_name_terr_text(tela.verifica_territorio_clicado(x,y),0);
	    		            	}
	            			}
		            	}
		            	if(tela.get_fase_atual() == "PE") {
		            		if(jogo.verifica_territorio_jogador(tela.verifica_territorio_clicado(x,y)) && tela.get_rotina_atual() != "Distribui Exercitos" && jogo.get_vez_jogador_num_cartas() != 5){
		            			tela.set_rotina_atual("Distribui Exercitos");
			            		tela.repinta_tela();
			            		tela.create_numero_exercitos_text(tela.verifica_territorio_clicado(x,y),0);
			            	} else if (x > 322 && y > 620 && x < 686 && y < 800) {
			            		if(tela.get_rotina_atual() == "Distribui Exercitos") {
			            			if(x > 575 && y > 709 && x < 619 && y < 750) {
				            			tela.change_numero_exercitos_text(1,jogo.get_vez_jogador_exercitos_distri(),0);
				            		} else if(x > 380 && y > 718 && x < 424 && y < 741) {
				            			tela.change_numero_exercitos_text(-1,jogo.get_vez_jogador_exercitos_distri(),0);
				            		}
				            		if(tela.verifica_ok_clicado(x,y)) {
				            			// pega territorio selecionado 
				            			int qtd = tela.get_qtd_exerc_sel();
				            			//System.out.println("OK");
				            			if(qtd > 0) {
					            			jogo.posiciona_exercitos_jogador_vez(qtd,tela.get_terr_sel(0));
					            			//System.out.println(tela.get_terr_sel(0));
					            			tela.set_rotina_layout("Layout nao ver cartas");
					            			if(jogo.get_vez_jogador_exercitos_distri() == 0) {
					            				tela.set_next_rotina();
					            				if(tela.get_fase_atual() == "ATQ")
					            				tela.set_rotina_layout("Layout ataque pass");
					            			}
				            			}
				            		}
			            		} else if (tela.get_rotina_atual() == "Layout nao ver cartas") {
			            			if(x > 412 && y > 637 && x < 458 && y < 666)
			            				tela.set_rotina_layout("Layout ver cartas");

			            		} else if (tela.get_rotina_atual() == "Layout ver cartas") {
			            			if(x > 412 && y > 637 && x < 458 && y < 666) {
    		            				tela.reset_all_selected();
    		            				tela.set_rotina_layout("Layout nao ver cartas");
    		            			} else if(tela.verifica_trocar_carta_clicado(x,y)) {
    		            				List<String> cartas = tela.show_selected();
    		            				System.out.println(cartas);
	    		            			if(tela.qtd_selected() == 3) {
	    		            				jogo.jogador_vez_troca_cartas_exerc(cartas);
	    		            				tela.set_cartas(jogo.get_vez_jogador_cartas());
	    		            			}
	    		            			tela.reset_all_selected();
    		            				tela.repinta_tela();
    		            			} else {
    		            				tela.verifica_carta_clicada(x,y);
    		            				//System.out.println("CARTA CLICADA: " + tela.verifica_carta_clicada(x,y));
    		            			}
			            		}
			            		
			            	} else if (tela.get_rotina_atual() == "Distribui Exercitos" && !jogo.verifica_territorio_jogador(tela.verifica_territorio_clicado(x,y))) {
			            		tela.set_rotina_layout("Layout nao ver cartas");
			            	} else if (jogo.verifica_territorio_jogador(tela.verifica_territorio_clicado(x,y))) {
			            		tela.change_name_terr_text(tela.verifica_territorio_clicado(x,y),0);
			            	}
		            	}
		            } else if(e.getButton() == MouseEvent.BUTTON1 && tela.get_fase_atual() == "ATQ" ) {
	            		if(tela.get_rotina_atual() == "Layout ataque pass") {
	            			if(tela.verifica_passar_ataque_clicado(x,y)) {
	            				// passa para proxima rotina se clicar na regiao do circulo
	            				tela.set_next_rotina();
	            				tela.set_rotina_layout("Layout reposiciona pass");
	            				jogo.save_territorios();
	            			} else if (jogo.verifica_territorio_jogador(tela.verifica_territorio_clicado(x,y))) {
	            				// troca para "Layout ataque" se clicar em uma regiao que pertence ao jogador
	            				tela.set_rotina_layout("Layout ataque");
	            				tela.create_ataque_compose_text(tela.verifica_territorio_clicado(x,y), "");
	            			}
	            		} else if(tela.get_rotina_atual() == "Layout ataque") {
	            			if(!(x > 322 && y > 620 && x < 686 && y < 800) && tela.verifica_territorio_clicado(x,y) == null) {
	            				// se clicar fora do layout e fora de qualquer territorio troca para "Layout ataque pass"
	            				tela.set_rotina_layout("Layout ataque pass");
	            			} else if(jogo.verifica_territorio_jogador(tela.verifica_territorio_clicado(x,y))) {
	            				// se clicar em um territorio que pertence ao jogador 
	            				if(tela.verifica_territorio_clicado(x,y) != tela.get_terr_sel(1)) {
	            					// se territorio for diferente do anterior troca regiao que ataca e reseta territorio atacado
	            					tela.change_name_terr_text(tela.verifica_territorio_clicado(x,y),1);
	            					tela.change_name_terr_text("",2);
	            				}
	            			} else if(!jogo.verifica_territorio_jogador(tela.verifica_territorio_clicado(x,y)) && tela.verifica_territorio_clicado(x,y) != null) {
	            				// se clicar em um territorio que nao pertence ao jogador 
	            				if(jogo.verifica_territorio_jogador_fronteira(tela.get_terr_sel(1),tela.verifica_territorio_clicado(x,y))) {
	            					//verifica se faz fronteira com o territorio escolhido
	            					tela.change_name_terr_text(tela.verifica_territorio_clicado(x,y),2);
	            				}
	            			} else if((x > 322 && y > 620 && x < 686 && y < 800)) {
	            				//System.out.println("LAYOUT");
	            				if(tela.get_terr_sel(2) != "" && (x > 452 && y > 645 && x < 562 && y < 674)) {
	            					// so permiti realizar ataque se tiver algum territorio selecionado para ser atacado e 
	            					if(jogo.get_exercito_terr(tela.get_terr_sel(1)) > 1) {
	            						// se territorio atacante possuir mais de 1 exercito
	            						jogo.ataque(jogo.get_qtd_exercito_atq(tela.get_terr_sel(1)),jogo.get_qtd_exercito_def(tela.get_terr_sel(2)));
	            						int[] res = jogo.qtd_vence_derrota();
	            						tela.realiza_ataque();
	            						jogo.posiciona_exercitos_jogador_vez(-res[1],tela.get_terr_sel(1));
	            						jogo.baixas_da_defesa(tela.get_terr_sel(2),-res[0]);
	            					}
	            				}
	            				if(jogo.get_exercito_terr(tela.get_terr_sel(2)) == 0) {
	            					// se territorio atacado ficar sem exercito abrir "Distribui Exercitos"
	            					jogo.conquistou_terr(tela.get_terr_sel(2));
	            					tela.set_rotina_atual("Distribui Exercitos");
	    		            		tela.repinta_tela();
	    		            		tela.create_numero_exercitos_text(tela.get_terr_sel(2),1);
	            				}
	            			}
	            		} else if(tela.get_rotina_atual() == "Distribui Exercitos") {
	            			// selecionar quantidade de exercitos que serao realocados
	            			if(x > 575 && y > 709 && x < 619 && y < 750) {
		            			tela.change_numero_exercitos_text(1,jogo.get_qtd_exercito_atq(tela.get_terr_sel(1)),1);
		            		} else if(x > 380 && y > 718 && x < 424 && y < 741) {
		            			tela.change_numero_exercitos_text(-1,jogo.get_qtd_exercito_atq(tela.get_terr_sel(1)),1);
		            		}
	            			if(tela.verifica_ok_clicado(x,y)) {
		            			// pega territorio selecionado 
		            			int qtd = tela.get_qtd_exerc_sel();
		            			//System.out.println("OK");
		            			if(qtd > 0) {
		            				// nao trocar de tela ate que seja confirmado quantidade realocada
		                			// depois de colocar exercitos trocar para "Layout ataque pass"
		            				jogo.finaliza_conquista(tela.get_terr_sel(2),tela.get_terr_sel(1),qtd);
			            			tela.set_rotina_layout("Layout ataque pass");
		            			}
		            		}
	            		}
	            	} else if(e.getButton() == MouseEvent.BUTTON1 && tela.get_fase_atual() == "REP" ) {
	            		if(tela.get_rotina_atual() == "Layout reposiciona pass") {
		            		if(tela.verifica_passar_ataque_clicado(x,y)) {
		        				tela.set_next_rotina();
		        				tela.set_rotina_layout("Layout nao ver cartas");
		        			} else if((x > 322 && y > 620 && x < 686 && y < 800)) {
		        				
		        			} else if(jogo.verifica_territorio_jogador(tela.verifica_territorio_clicado(x,y)) && jogo.get_max_exerc(tela.verifica_territorio_clicado(x,y)) > 0) {
		        				tela.reposicionamento_selected_lose(tela.verifica_territorio_clicado(x,y));
		        				tela.set_rotina_atual("Distribui Exercitos");
			            		tela.create_numero_exercitos_text("",0);
			            		tela.change_name_terr_text(tela.verifica_territorio_clicado(x,y),1);
			            		tela.repinta_tela();
		        			}
	            		} else if(tela.get_rotina_atual() == "Distribui Exercitos") {
	            			if((x > 322 && y > 620 && x < 686 && y < 800)) {
	            				if(x > 575 && y > 709 && x < 619 && y < 750 && tela.get_terr_sel(0) != "") {
	            					int qtd = tela.get_qtd_exerc_sel();
	            					if(qtd+1 < jogo.get_exercito_terr(tela.get_terr_sel(1)))
	    	            			tela.change_numero_exercitos_text(1,jogo.get_max_exerc(tela.get_terr_sel(1)),0);
	    	            		} else if(x > 380 && y > 718 && x < 424 && y < 741) {
	    	            			tela.change_numero_exercitos_text(-1,jogo.get_max_exerc(tela.get_terr_sel(1)),0);
	    	            		}
	            				if(tela.verifica_ok_clicado(x,y)) {
	    	            			int qtd = tela.get_qtd_exerc_sel();
	    	            			if(qtd > 0) {
	    	            				tela.reset_all_selected();
	    	            				jogo.realocate_exerc(qtd,tela.get_terr_sel(1),tela.get_terr_sel(0));
	    		            			tela.set_rotina_layout("Layout reposiciona pass");
	    	            			}
	    	            		}
		        			} else if(!jogo.verifica_territorio_jogador(tela.verifica_territorio_clicado(x,y))) {
		        				tela.reset_all_selected();
	            				tela.set_rotina_layout("Layout reposiciona pass");
	            			} else if(jogo.verifica_territorio_jogador(tela.verifica_territorio_clicado(x,y)) && jogo.verifica_territorio_jogador_fronteira(tela.get_terr_sel(1),tela.verifica_territorio_clicado(x,y))) {
			            		tela.create_numero_exercitos_text(tela.verifica_territorio_clicado(x,y),0);
			            		tela.reset_all_selected();
			            		tela.reposicionamento_selected_lose(tela.get_terr_sel(1));
			            		tela.reposicionamento_selected_win(tela.verifica_territorio_clicado(x,y));
			            		tela.repinta_tela();
	            			}
	            		}
	            	}
	            	if (tela.get_fase_atual() == "PASS") {
		            	if(jogo.verifica_vez_jogador_objetivo()) {
		            		tela.jogador_ganhou(jogo.get_vez_jogador_nome());
		            		int resposta = JOptionPane.showConfirmDialog(null, "Clique em OK para continuar a jogar.", "Reiniciar", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
		            		if (resposta == JOptionPane.OK_OPTION) {
		                        System.out.println("Reiniciar.");
		                        jogo.reset_all();
		                        tela.reset_all();
		                        jogo.sorteia_obj_todos_jogadores(jogo.jogadores_ativos,jogo.deckobj);
		    			    	jogo.sorteia_todos_territorios(jogo.mapa_mundo, jogo.jogadores_ativos);
		    			    	tela.set_jogador_vez(jogo.get_vez_jogador_color());
		    			    	tela.set_cartas(jogo.get_vez_jogador_cartas());
		    			    	jogo.get_vez_jogador_add_exercito();
		    			    	tela.set_objetivo_jogador_da_vez(jogo.get_obj_jgd_da_vez());
		    			    	tela.repinta_tela();
		                    } else {
		                        System.out.println("Encerrar.");
		                        tela.encerrar_partida();
		                    }
		            	} else { // trocar para proximo jogador
		            		if(jogo.verifica_next_rodada()) {
		            			// proxima rodada
		            			tela.next_rodada();
		            		}
		            		jogo.next_jogador();
		            		tela.set_jogador_vez(jogo.get_vez_jogador_color());
					    	tela.set_cartas(jogo.get_vez_jogador_cartas());
					    	jogo.get_vez_jogador_add_exercito();
					    	tela.set_objetivo_jogador_da_vez(jogo.get_obj_jgd_da_vez());
					    	jogo.jogador_ganha_carta();
					    	tela.set_cartas(jogo.get_vez_jogador_cartas());
					    	//jogo.get_vez_jogador_territorios();
					    	tela.set_next_rotina();
		            	}
		            }
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

package View;

import java.util.*;

class Dado {
	private List<ImagemInfo> dados_ataque;
	private List<ImagemInfo> dados_defesa;
	private boolean exibe;
	
	private Dado() {
		List<ImagemInfo> dados_ataque=new ArrayList<ImagemInfo>();
		List<ImagemInfo> dados_defesa=new ArrayList<ImagemInfo>();
		dados_ataque.add(new ImagemInfo("dado_ataque_1.png",0,0,32,32));
		dados_ataque.add(new ImagemInfo("dado_ataque_2.png",0,0,32,32));
		dados_ataque.add(new ImagemInfo("dado_ataque_3.png",0,0,32,32));
		dados_ataque.add(new ImagemInfo("dado_ataque_4.png",0,0,32,32));
		dados_ataque.add(new ImagemInfo("dado_ataque_5.png",0,0,32,32));
		dados_ataque.add(new ImagemInfo("dado_ataque_6.png",0,0,32,32));
		dados_defesa.add(new ImagemInfo("dado_defesa_1.png",0,0,32,32));
		dados_defesa.add(new ImagemInfo("dado_defesa_2.png",0,0,32,32));
		dados_defesa.add(new ImagemInfo("dado_defesa_3.png",0,0,32,32));
		dados_defesa.add(new ImagemInfo("dado_defesa_4.png",0,0,32,32));
		dados_defesa.add(new ImagemInfo("dado_defesa_5.png",0,0,32,32));
		dados_defesa.add(new ImagemInfo("dado_defesa_6.png",0,0,32,32));
	}
	static void interpreta_lancamento(List<Integer> lancamento_defesa, List<Integer> lancamento_ataque, String cor ) {
		Dado dados = new Dado(); 
	}
	public boolean get_flag() {
		return this.exibe;
	}
}

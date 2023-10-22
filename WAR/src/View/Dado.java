package View;

import java.util.*;

class Dado {
	private static List<ImagemInfo> dados_ataque;
	private static List<ImagemInfo> dados_defesa;
	protected static ImagemInfo[] dados;
	private static boolean exibe;
	static {
		dados_ataque=new ArrayList<ImagemInfo>();
		dados_defesa=new ArrayList<ImagemInfo>();
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
	public static void interpreta_lancamento(List<Integer> lancamento_defesa, List<Integer> lancamento_ataque) {
		dados = new ImagemInfo[lancamento_defesa.size()+lancamento_ataque.size()];
		int i;
		for(i = 0; i < lancamento_defesa.size(); i++) {
			dados[i] = dados_defesa.get(lancamento_defesa.get(i)-1);
		}
		for(int j = 0; j < lancamento_ataque.size(); j++) {
			dados[i] = dados_ataque.get(lancamento_ataque.get(j)-1);
			i++;
		}
	}
	public static void set_exibe(boolean status) {
		exibe = status;
	}
	public static boolean get_flag() {
		return exibe;
	}
	public static ImagemInfo[] get_dados() {
		return dados;
	}
//	public ImagemInfo get_image(char tipo,int pos) {
//		if(tipo == 'a') {
//			return dados_ataque.get(pos-1);
//		} else if (tipo == 'd') {
//			return dados_defesa.get(pos-1);
//		}
//		return null;
//	}
}

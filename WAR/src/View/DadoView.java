package View;

import java.util.*;
import Model.Observado;
import Model.Observador;


class DadoView implements Observador{
	private static List<ImagemInfo> dados_ataque;
	private static List<ImagemInfo> dados_defesa;
	protected static ImagemInfo[] dadosAtk;
	protected static ImagemInfo[] dadosDef;
	protected static String cor;
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
	public void notify(Observado o) {
		// System.out.println(((List<Integer>)o.get('d')).size() + " " + ((List<Integer>)o.get('a')).size());
		List<Integer> l_d = (List<Integer>)o.get('d');
		List<Integer> l_a = (List<Integer>)o.get('a');
		
		interpreta_lancamento(l_d,l_a,(String)o.get('c'));
	}
	
	public static void interpreta_lancamento(List<Integer> lancamento_defesa, List<Integer> lancamento_ataque, String cor_atual) {
		System.out.println("-> CHECK <-");
		System.out.println(lancamento_defesa.size() + " | "  + lancamento_ataque.size());
		System.out.println("DEFESA ->");
		for (Integer valor : lancamento_defesa) {
		    System.out.println(valor);
		}
		System.out.println("ATAQUE ->");
		for (Integer valor : lancamento_ataque) {
		    System.out.println(valor);
		}
		dadosAtk = new ImagemInfo[lancamento_ataque.size()];
		dadosDef = new ImagemInfo[lancamento_defesa.size()];
		int i;
		for(i = 0; i < lancamento_defesa.size(); i++) {
			dadosDef[i] = dados_defesa.get(lancamento_defesa.get(i)-1);
		}
		for(int j = 0; j < lancamento_ataque.size(); j++) {
			dadosAtk[j] = dados_ataque.get(lancamento_ataque.get(j)-1);
		}
		cor = cor_atual;
	}
	public static void set_exibe(boolean status) {
		exibe = status;
	}
	public static boolean get_flag() {
		return exibe;
	}
	public static ImagemInfo[] get_dados_atk() {
		return dadosAtk;
	}
	public static ImagemInfo[] get_dados_def() {
		return dadosDef;
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

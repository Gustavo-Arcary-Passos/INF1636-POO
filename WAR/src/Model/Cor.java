package Model;

class Cor {
	static String[] cores = { "azul", "vermelho", "verde", "amarelo", "preto", "branco" };
	
	public static boolean existe_cor(String cor) {
		for(String existe : cores) {
			if(existe == cor) {
				existe =null;
				return true;
			}
		}
		return false;
	}
}

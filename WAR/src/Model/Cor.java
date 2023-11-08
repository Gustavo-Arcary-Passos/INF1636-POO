package Model;

import java.util.*;

class Cor {	
	public static boolean existe_cor(String cor,List<String> cores) {
		for(String existe : cores) {
			if(existe.equals(cor)) {
				cores.remove(existe);
				return true;
			}
		}
		return false;
	}
}

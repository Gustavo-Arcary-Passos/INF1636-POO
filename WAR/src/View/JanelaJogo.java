package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

class JanelaJogo extends LoadScene {
	public JanelaJogo(Tela frame) {        
		this.images = new ImagemInfo[100];
		count_images_loaded(new ImagemInfo ("war_tabuleiro_fundo.png",0,0,1024,768));
		count_images_loaded(new ImagemInfo ("war_tabuleiro_linhas.png",0,0,1024,768));
		count_images_loaded(new ImagemInfo ("war_tabela_bonus_continente.png",10,400,130,120));
		count_images_loaded(new ImagemInfo ("war_tabela_troca.png",10,540,114,131));
		count_images_loaded(new ImagemInfo ("war_tabuleiro_bottom.png",0,715,1024,85));
		//count_images_loaded(new ImagemInfo ("war_tabuleiro_mapa copy.png",0,0,1024,768));
		
		this.formas_geometricas = new DesenhaTerritorioPoligono[52];
		Color padrao = new Color(75,75,75);
		// America do Sul
		Color amesul = new Color(0,104,56);
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{274,332,326,343,336,315,306,291,285,254,232},new int[]{500,500,487,457,441,441,421,418,402,394,431}, padrao, amesul, "Brasil"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{274,234,278,294,281,311,303,334},new int[]{500,569,645,645,619,567,554,500}, padrao, amesul, "Argentina"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{195,201,218,232,227,240,274,232},new int[]{494,503,503,532,540,558,499,431}, padrao, amesul, "Peru"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{253,194,162,176,189,197},new int[]{394,394,450,477,477,490}, padrao, amesul, "Venezuela"));
		// America do Norte
		Color amenor = new Color(238,64,54);
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{90,83,104,110,102,105,135,146,162,171,181,189,183,178,171,174,166,171,164,162,152,126},new int[]{305,318,353,341,326,318,371,372,404,404,416,402,394,392,385,378,365,356,344,349,350,305}, padrao, amenor, "México"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{107,84,90,78,90,125,177},new int[]{215,255,263,284,305,306,216}, padrao, amenor, "Califórnia"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{202,165,181,203,211,200,207,215,232,237,244,261,280,292,297,244,230,202},new int[]{242,304,304,344,334,313,301,301,274,274,260,260,227,227,217,217,242,242}, padrao, amenor, "Nova York"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{178,126,146,201,230,244},new int[]{215,305,338,243,242,216}, padrao, amenor, "Texas"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{125,111,119,103,108,213,230,222,146},new int[]{134,161,177,206,216,216,186,172,172}, padrao, amenor, "Vancouver"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{230,213,295,303,316,314,325,329,322,331,337,344,340,321,318,289,283,273,262},new int[]{185,216,216,202,202,210,210,198,186,173,178,165,158,159,155,156,166,166,185}, padrao, amenor, "Quebec"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{87,78,70,59,111,133},new int[]{119,137,138,163,163,119}, padrao, amenor, "Alasca"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{133,125,146,222,231,245,258,282,271,243,231,213,208,153,149},new int[]{118,134,172,172,158,158,134,134,112,112,134,134,127,127,118}, padrao, amenor, "Calgary"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{286,271,282,330,334,350,365,372,380,370},new int[]{90,111,134,134,144,144,116,116,102,90}, padrao, amenor, "Groenlândia"));
		// Africa
		Color africa = new Color(101,45,144);
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{529,557,596,606,614,626,617},new int[]{541,595,595,579,579,555,541}, padrao, africa, "África do Sul"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{520,514,535,530,574,598,587},new int[]{478,488,523,540,540,498,478}, padrao, africa, "Angola"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{426,447,503,520,586,547},new int[]{405,447,447,477,477,406}, padrao, africa, "Nigéria"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{437,410,426,514,539,498,493,481,474},new int[]{333,378,405,405,360,360,346,346,333}, padrao, africa, "Argélia"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{542,514,547,562,622,594,597,589},new int[]{355,405,405,432,432,380,373,355}, padrao, africa, "Egito"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{562,598,574,618,642,652,671,638,623},new int[]{433,498,540,540,497,497,460,460,433}, padrao, africa, "Somália"));
		// Europa
		Color euro = new Color(43,56,143);
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{441,438,428,423,440,448,450,452,447},new int[]{172,178,178,192,192,185,185,180,172}, padrao, euro, "Reino Unido"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{460,450,459,453,463,459,450,445,483,490,483,470,482,474,482},new int[]{141,158,158,170,182,190,190,205,205,192,192,170,150,150,141}, padrao, euro, "Reino Unido"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{446,451,460,466,460,477,483,494,501,507,539,526,518,522,515,498,489},new int[]{230,240,240,249,259,286,274,274,258,258,204,182,194,203,214,214,230}, padrao, euro, "França"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{442,416,439,443,456,452,471,479,475,477,461},new int[]{261,304,304,299,299,307,307,292,291,285,261}, padrao, euro, "Espanha"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{539,508,518,526,534,542,537,549,554,558,563,552,546,538,543,552,556,567,552},new int[]{206,258,258,276,276,292,304,304,291,294,294,273,273,257,248,249,254,232,206}, padrao, euro, "Itália"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{508,492,501,514,522,530,535,547,555,551,558,551,564,578,570,578,572,601,610,582,550,544,537,523},new int[]{135,161,178,178,166,166,179,179,166,162,150,140,123,123,140,140,152,152,139,92,92,106,106,135}, padrao, euro, "Suécia"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{563,552,567,582,601,582,576,571},new int[]{183,204,232,232,200,171,171,183}, padrao, euro, "Polônia"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{567,556,555,566,579,575,582,594,602,594,598,608,582},new int[]{232,252,259,259,282,292,303,303,292,285,278,278,232}, padrao, euro, "Romênia"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{601,582,608,619,611,620},new int[]{201,231,277,259,249,234}, padrao, euro, "Ucrânia"));
		// Oceania
		Color oceania = new Color(38,169,224);
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{875,818,823,838,845,877,892,902,917,911,920,885},new int[]{535,637,652,652,668,668,644,644,618,607,592,535}, padrao, oceania, "Austrália"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{840,835,848,886,890,904,907,920,927,954,944,935,925,908,902,887,881,860,850},new int[]{476,485,512,512,524,524,517,517,532,532,514,514,494,494,482,482,495,495,476}, padrao, oceania, "Indonésia"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{929,935,929,933,923,917,901,918,926,931,951,943,939,942,936},new int[]{600,608,617,626,643,643,677,677,660,660,626,616,614,612,600}, padrao, oceania, "Nova Zelândia"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{781,774,783,770,762,757,766,779,787,817,862,854,862,857,838,822,799,790},new int[]{580,593,606,625,625,634,652,652,638,638,558,546,537,532,532,561,561,580}, padrao, oceania, "Perth"));
		// Asia
		Color asia = new Color(246,146,30);
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{610,591,582,612,724,741,723,626}, new int[]{140,170,170,218,218,195,168,168}, padrao, asia, "Letônia"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{583,626,705,732,660,650,630,614,628,631,642,633,608,605}, new int[]{93,168,168,119,119,139,139,112,112,118,118,98,98,93}, padrao, asia, "Estônia"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{612,620,639,646,652,666,669,679,692,684,763,783,773}, new int[]{219,234,235,243,234,234,242,243,263,272,274,240,219}, padrao, asia, "Turquia"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{873,825,886,876,886,906,916,929,938,949,956,941,946,941,951,937}, new int[]{112,196,196,182,171,171,154,178,178,196,185,157,148,139,139,112}, padrao, asia, "Sibéria"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{744,744,749,745,726,706,725,740,824,868}, new int[]{120,125,125,131,131,167,170,196,196,120}, padrao, asia, "Rússia"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{739,725,773,782,906,920,908}, new int[]{197,218,218,241,241,217,197}, padrao, asia, "Cazaquistão"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{654,628,646,640,648,698,726,718,679}, new int[]{339,383,416,430,443,443,398,382,382}, padrao, asia, "Arábia Saudita"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{781,753,786,811,838,888,874,822,805}, new int[]{241,290,344,344,296,296,274,274,241}, padrao, asia, "China"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{884,859,886,895,901,897,901,885,891,896,906,910,918,926,914}, new int[]{345,391,439,439,426,426,414,393,383,390,390,381,381,364,345}, padrao, asia, "Tailândia"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{847,828,841,848,860,854,870,878,872,878,859,883}, new int[]{345,376,402,402,427,434,463,452,439,427,391,345}, padrao, asia, "Bangladesh"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{824,811,915,922,914}, new int[]{321,344,344,333,321}, padrao, asia, "Coreia do Sul", 8, -3));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{838,825,914,907,893,886}, new int[]{296,320,320,310,310,296}, padrao, asia, "Coreia do Norte", -8, -4));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{786,763,798,812,807,847}, new int[]{344,380,442,422,414,344}, padrao, asia, "Índia"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{701,690,715,734,740,751,719}, new int[]{306,324,370,370,381,364,306}, padrao, asia, "Irã"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{671,653,679,706,694,702,691,700}, new int[]{306,338,381,381,359,347,322,306}, padrao, asia, "Iraque"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{937,928,944,941,936,929,931,922,940,946,954,964,953,955}, new int[]{219,234,264,272,272,283,288,301,304,288,288,272,253,249}, padrao, asia, "Japão"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{617,602,614,622,628,672,649,633}, new int[]{334,351,372,372,382,306,306,334}, padrao, asia, "Jordânia"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{806,820,895,907,915,902,909,905}, new int[]{242,273,273,295,282,258,258,242}, padrao, asia, "Mongólia"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{718,709,751,741,763,785,754,762}, new int[]{274,290,365,380,380,344,293,274}, padrao, asia, "Paquistão"));
		count_terras_loaded(new DesenhaTerritorioPoligono(new int[]{628,620,629,637,638,717,709,717,666,660,647,646}, new int[]{271,287,300,300,305,305,291,273,273,269,269,271}, padrao, asia, "Síria"));
		frame.repaint();
	}
	public void desenha(Graphics g) {
		for(int i = 0; i <= this.count_images; i++) {
		    if (images[i] != null) {
		    	g.drawImage(images[i].get_image(), images[i].get_x(), images[i].get_y(), images[i].get_w(), images[i].get_h(), null);
		    }
	    }
		Graphics2D g2d = (Graphics2D) g;
		boolean RU = false;
		for(int i = 0; i < this.count_formas_geometricas; i++) {
		    if (formas_geometricas[i] != null) {
		    	g2d.setColor(formas_geometricas[i].get_cor());
		    	g2d.fill(formas_geometricas[i].get_polygon());
		    	g2d.setColor(formas_geometricas[i].get_border());
		    	g2d.setStroke(new BasicStroke(2));
		    	g2d.draw(formas_geometricas[i].get_polygon());
		    	g2d.setStroke(new BasicStroke(1));
				// desenha o exercito 2d
		    	if(formas_geometricas[i].get_nome() ==  "Reino Unido") {
		    		if(RU) {
		    			formas_geometricas[i].get_exercito_2d().draw(g2d,formas_geometricas[i].get_cor());
		    		}
		    		RU = true;
		    	} else {
		    		formas_geometricas[i].get_exercito_2d().draw(g2d,formas_geometricas[i].get_cor());
		    	}
		    }
	    }
		//Condicional de plot de dados
		if(DadoView.get_flag()) {
			//Dado.set_exibe(false);
			ImagemInfo[] images_atk = DadoView.get_dados_atk();
			ImagemInfo[] images_def = DadoView.get_dados_def();
			int x = 366;
			int y = 458;
			int w = 132;
			int h = 132;
			RoundRectangle2D rt=new RoundRectangle2D.Double(x,y,w,h,20,20);
			g2d.setPaint(new Color(99,55,41));
			g2d.fill(rt);
			g2d.setPaint(new Color(234,184,135));
			g2d.setStroke(new BasicStroke(5));
			g2d.draw(rt);
			g2d.setStroke(new BasicStroke(1));
			int y_min = y;
			int y_max = y+h-2*images_atk[0].get_h()/3;
			int y_progress = (y_max-y_min)/(images_atk.length+1);
			for(int i = 0; i < images_atk.length; i++) {	
				g.drawImage(images_atk[i].get_image(), x+w/4-2*images_atk[i].get_w()/3/2 + images_atk[i].get_w()/3 , y_min+y_progress*(i+1), 2*images_atk[i].get_w()/3, 2*images_atk[i].get_h()/3, null);	
			}
			x = 365+w/2;
			y = 458;
			y_progress = (y_max-y_min)/(images_def.length+1);
			for(int i = 0; i < images_def.length; i++) {
				g.drawImage(images_def[i].get_image(), x+w/4-2*images_def[i].get_w()/3/2 - images_atk[i].get_w()/3 , y_min+y_progress*(i+1), 2*images_def[i].get_w()/3, 2*images_def[i].get_h()/3, null);	
			}
		}
	}
}

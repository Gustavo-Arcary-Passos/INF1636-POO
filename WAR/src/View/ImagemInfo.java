package View;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

class ImagemInfo {
	protected String caminho;
	protected int x;
	protected int y;
	protected int w;
	protected int h;
	protected BufferedImage imagem;
	
	public ImagemInfo (String path,int x,int y,int w,int h){
		this.caminho = path;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.load_image();
	}
	
	public BufferedImage get_image() {
		return this.imagem;
	}
	
	public String get_path() {
		return this.caminho;
	}
	
	public int get_x() {
		return this.x;
	}
	
	public int get_y() {
		return this.y;
	}
	
	public int get_w() {
		return this.w;
	}
	
	public int get_h() {
		return this.h;
	}
	
	public void set_x(int x) {
		this.x = x;
	}
	
	public void set_y(int y) {
		this.y = y;
	}
	
	public void load_image() {
		try {
			this.imagem = ImageIO.read(new File("WAR-Imagens/images/" + this.caminho));
		} catch (IOException e) {
			e.printStackTrace();
		}
	 }
}

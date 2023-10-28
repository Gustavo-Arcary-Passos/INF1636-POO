package View;

import java.awt.Graphics;

public class CartaInfo extends ImagemInfo {

    public CartaInfo(String caminho, int w, int h)
    {
        super(caminho, 512, 384, w, h);
    }

    /**
     * Desenha a imagem na tela, a partir do ponto central dela
     * @param g
     */
    public void desenha(Graphics g)
    {
        g.drawImage(imagem, x - (w / 2), y - (h / 2), w, h, null);
    }

    /**
     * Remove a imagem da tela
     * @param g
     */
    public void apaga(Graphics g)
    {
        g.clearRect(x - (w / 2), y - (h / 2), w, h);
    }
}

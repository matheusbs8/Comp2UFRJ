//Nome: Matheus Barroso de Santana
//DRE: 120041661
import java.awt.*;

public class Selo implements  Colecionavel{
    private final Image imagem;
    private final int posicao;
    private final String pais;
    private final float valorNominal;


    public Selo(int posica, String urlDaImagem, String pais, float valorNominal) {
        this.imagem = obterImagem(urlDaImagem);
        this.posicao = posica;
        this.pais=pais;
        this.valorNominal=valorNominal;

    }
    private Image obterImagem(String url) {
        // ToDo baixaria da Internet...
        return null;
    }
    public float getValorNominal(){
        return valorNominal;
    }
    public String getPais(){
        return pais;
    }

    public Image getImagem() {
        return imagem;
    }

    public int getPosicao() {
        return posicao;
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Repositorio{

    private static final String PREFIXO_URL_IMAGENS = "http://www.nossoalbum.com.br/imagens/";

    private List<Figurinha> todasAsFigurinhas;

    public Repositorio(String sufixoUrlImagens, int quantColecionaveis) {
        todasAsFigurinhas = new ArrayList<>(quantColecionaveis);
        for (int i = 1; i <= quantColecionaveis; i++) {
            Figurinha fig = new Figurinha(i, PREFIXO_URL_IMAGENS + sufixoUrlImagens);
            todasAsFigurinhas.add(fig);
        }
    }


    public int getTotalFigurinhas() {
        return this.todasAsFigurinhas.size();
    }

}

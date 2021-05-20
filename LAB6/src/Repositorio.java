//Nome: Matheus Barroso de Santana
//DRE: 120041661
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Repositorio<T extends Colecionavel>{

    private static final String PREFIXO_URL_IMAGENS = "http://www.nossoalbum.com.br/imagens/";

    private List<T> todosOsColecionaveis;
    private T instancia;

    public Repositorio(String sufixoUrlImagens, int quantColecionaveis, T instancia) {
        this.instancia=instancia;
        todosOsColecionaveis = new ArrayList<>(quantColecionaveis);
        Random r= new Random();
        for (int i = 1; i <= quantColecionaveis; i++) {
            if(instancia instanceof  Figurinha) {
                Figurinha fig = new Figurinha(i, PREFIXO_URL_IMAGENS + sufixoUrlImagens);
                todosOsColecionaveis.add((T)fig);
            }
            if(instancia instanceof  Selo) {
                Selo sel = new Selo(i, PREFIXO_URL_IMAGENS + sufixoUrlImagens,"Brasil", r.nextFloat() );
                todosOsColecionaveis.add((T)sel);
            }
        }
    }

    public T getInstancia(){
        return instancia;
    }

    public int getTotalFigurinhas() {
        return this.todosOsColecionaveis.size();
    }
    public List<T> getColecionaveis(){
        return todosOsColecionaveis;
    }

}

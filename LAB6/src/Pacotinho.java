//Nome: Matheus Barroso de Santana
//DRE: 120041661
import java.util.Random;

public class Pacotinho<T extends Colecionavel>{

    private T col[];
    private T instancia;
    public Pacotinho(Repositorio repo, int[] posicoesDesejadas) {

        if (repo.getInstancia() instanceof Figurinha) {
            Figurinha fig[] = new Figurinha[posicoesDesejadas.length];
            int j = 0;
            for (int i = 0; i < posicoesDesejadas.length; i++) {
                if (posicoesDesejadas[i] < repo.getTotalFigurinhas() + 1 && posicoesDesejadas[i] > 0) {
                    fig[j] =(Figurinha) repo.getColecionaveis().get(i);
                    j++;
                }
            }
            col=(T[])fig;
        }else {
            if (repo.getInstancia() instanceof Selo) {
                Selo sel[] = new Selo[posicoesDesejadas.length];
                int j = 0;
                for (int i = 0; i < posicoesDesejadas.length; i++) {
                    if (posicoesDesejadas[i] < repo.getTotalFigurinhas() + 1 && posicoesDesejadas[i] > 0) {
                        sel[j] = (Selo)repo.getColecionaveis().get(i);
                        j++;
                    }
                }
                col = (T[]) sel;
            }
        }

    }

    /**
     * Produz um pacotinho com quantFigurinhas sorteadas aleatoriamente
     * dentre aqueles presentes no repositório informado.
     *
     * @param repo o repositório desejado
     * @param quantColecionaveis a quantidade de figurinhas a constar no pacotinho
     */
    public Pacotinho(Repositorio repo, int quantColecionaveis) {
        Random gerador = new Random();
        if(repo.getInstancia() instanceof Figurinha) {
           Figurinha fig[] = new Figurinha[quantColecionaveis];
            for (int i = 0; i < quantColecionaveis; i++) {
                int j = gerador.nextInt(repo.getTotalFigurinhas()) + 1;
                fig[i] = (Figurinha) repo.getColecionaveis().get(j);
            }
            col=(T[])fig;
        }else {
            if (repo.getInstancia() instanceof Selo) {
                Selo sel[] = new Selo[quantColecionaveis];
                for (int i = 0; i < quantColecionaveis; i++) {
                    int j = gerador.nextInt(repo.getTotalFigurinhas()) + 1;
                    sel[i] = (Selo)repo.getColecionaveis().get(j) ;
                }
                col = (T[]) sel;
            }
        }
    }

    public T[] getFigurinhas(){

        return col;
    }
}

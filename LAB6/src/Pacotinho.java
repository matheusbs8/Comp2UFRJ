import java.util.Random;

public class Pacotinho {

    private Figurinha fig[];

    public Pacotinho(Repositorio repo, int[] posicoesDesejadas) {
             fig= new Figurinha[posicoesDesejadas.length];
            int j=0;
            for (int i=0; i<posicoesDesejadas.length;i++){
                if(posicoesDesejadas[i]< repo.getTotalFigurinhas()+1 && posicoesDesejadas[i]>0){
                    fig[j]=new Figurinha(posicoesDesejadas[i], "imagem da figurinha"+posicoesDesejadas[i]);
                    j++;
                }
            }
    }

    /**
     * Produz um pacotinho com quantFigurinhas sorteadas aleatoriamente
     * dentre aqueles presentes no repositório informado.
     *
     * @param repo o repositório desejado
     * @param quantFigurinhas a quantidade de figurinhas a constar no pacotinho
     */
    public Pacotinho(Repositorio repo, int quantFigurinhas) {
        Random gerador = new Random();
           fig = new Figurinha[quantFigurinhas];
           for (int i = 0; i < quantFigurinhas; i++) {
               int j = gerador.nextInt(repo.getTotalFigurinhas()) + 1;
               fig[i] = new Figurinha(j, "url da imagem " + j);
           }

    }

    public Figurinha[] getFigurinhas(){

        return fig;
    }
}

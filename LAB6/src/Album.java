import java.awt.*;
import java.util.*;
import java.util.List;

public class Album {

    public static final int PERCENTUAL_MINIMO_PARA_AUTO_COMPLETAR = 90;

    public static final Image IMAGEM_PADRAO_PARA_POSICAO_VAZIA = null;

    private final Repositorio repositorio;
    private final int quantItensPorPacotinho;

    private List<Figurinha> colecionaveisColados;  // direct addressing
    private int quantColecionaveisColadas;

    // poderíamos fazer novamente direct addressing para as repetidas,
    // mas vamos usar um HashMap aqui só para treinarmos
    private Map<Integer, Integer> contRepetidasByPosicao;

    public Album(Repositorio repositorio, int quantItensPorPacotinho) {
        this.repositorio = repositorio;
        this.quantItensPorPacotinho = quantItensPorPacotinho;

        int tamanhoFisicoDaLista = getTamanho() + 1;
        this.colecionaveisColados = new ArrayList<>(tamanhoFisicoDaLista);
        // inicializa as posições com nulls, para poder acessá-las diretamente
        for (int i = 0; i < tamanhoFisicoDaLista; i++) {
            this.colecionaveisColados.add(null);
        }
        this.quantColecionaveisColadas = 0;

        this.contRepetidasByPosicao = new HashMap<>();
    }

    public void receberNovoPacotinho(Pacotinho pacotinho) {
        Figurinha colecionaveisDoPacotinho[] = pacotinho.getFigurinhas();
        if (colecionaveisDoPacotinho.length != this.quantItensPorPacotinho) {
            return;  // melhor ainda: lançaria uma checked exception
        }

        for (int i =0; i<colecionaveisDoPacotinho.length; i++ ) {
            final int posicao = colecionaveisDoPacotinho[i].getPosicao();
            if (possuiItemColado(posicao)) {
                // adiciona como repetida

                // jeito pior
//                Integer contRepetidas = this.contRepetidasByPosicao.get(posicao);
//                this.contRepetidasByPosicao.put(
//                        posicao, contRepetidas == null ? 1 : contRepetidas + 1);

                // jeito mais elegante: getOrDefault
                int contRepetidas = this.contRepetidasByPosicao.getOrDefault(posicao, 0);
                this.contRepetidasByPosicao.put(posicao, contRepetidas + 1);

            } else {
                // item inédito
                this.colecionaveisColados.set(posicao, colecionaveisDoPacotinho[i]);
                this.quantColecionaveisColadas++;
            }
        }
    }

    public Figurinha getItemColado(int posicao) {
        for(Figurinha col : colecionaveisColados){
            if(col!=null) {
                if (col.getPosicao() == posicao) {
                    return col;
                }
            }
        }
        return null;
    }

    public boolean possuiItemColado(int posicao) {
        return getItemColado(posicao)!=null;
    }

    public boolean possuiItemRepetido(int posicao) {
        return contRepetidasByPosicao.get(posicao)!=null;
    }

    public int getTamanho() {
        return this.repositorio.getTotalFigurinhas();
    }

    public int getQuantItensColados() {
//        int contador = 0;
//        for (Figurinha fig : this.figurinhasColadas) {
//            if (fig != null) {
//                contador++;
//            }
//        }
//        return contador;

        // melhor jeito: atributo!
        return this.quantColecionaveisColadas;
    }

    public int getQuantItensFaltantes() {
        return getTamanho() - getQuantItensColados();
    }

    public void autoCompletar() {
        if((getQuantItensColados()*100/getTamanho()>=PERCENTUAL_MINIMO_PARA_AUTO_COMPLETAR)){
            for(int i=1; i<getTamanho(); i++){
                if(colecionaveisColados.get(i)==null) {
                    if(colecionaveisColados instanceof  Figurinha)
                        colecionaveisColados.set(i,new Figurinha(i, ""));
                   /* if(colecionaveisColados instanceof  Selo) {
                        Random r= new Random();
                        colecionaveisColados.set(i, (T)new Selo(i,"g", "Brasil", r.nextFloat()));
                    }*/

                    this.quantColecionaveisColadas++;
                        System.out.println(i);
                }
            }

        }


    }

    private Image getImagem(int posicao) {
        return possuiItemColado(posicao)
                ? this.getItemColado(posicao).getImagem()
                : IMAGEM_PADRAO_PARA_POSICAO_VAZIA;
    }

//    public static void main(String[] args) {
//        ArrayList<Integer> meuArrayList = new ArrayList<>(200);
//
//        // inicializa as posições com nulls, para poder acessá-las diretamente
//        for (int i = 0; i < 200; i++) {
//            meuArrayList.add(null);
//        }
//
////        System.out.println(meuArrayList.get(3));
//
//        meuArrayList.add(3, 300000);  // insert com shift right
//
//        for (int numero : meuArrayList) {
//            System.out.println(numero);
//        }
//    }
}

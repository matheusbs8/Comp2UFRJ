
//Nome: Matheus Barroso de Santana
//DRE: 120041661
 public class TamanhoMaximoExcedidoException extends Exception {

    private int tamanho;

    public TamanhoMaximoExcedidoException(){

    }
    public TamanhoMaximoExcedidoException(int tamanho){
        this.tamanho=tamanho;
    }
    public int getTamanhoTexto(){
        return tamanho;
    }
}

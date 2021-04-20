public class Livro extends Produto {

    private int numeroDePaginas;
    private String trechoEmDestaque;
    private String autor;
    private int anoDePublicacao;


    public Livro(String nome, String editora) {
        super("Livro: "+nome, "url");
    }

    private int getNumeroDePaginas() {
        return 0;
    }

    public String getTrechoEmDestaque() {
        return trechoEmDestaque;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }
}

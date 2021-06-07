package modelo;

public class Livro {

    private String titulo;
    private String autor;
    private int anoDePublicacao;
    public Livro(String titulo, String autor, int anoDePublicacao) {
        this.anoDePublicacao=anoDePublicacao;
        this.autor=autor;
        this.titulo=titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoDePublicacao() {
        return anoDePublicacao;
    }
}

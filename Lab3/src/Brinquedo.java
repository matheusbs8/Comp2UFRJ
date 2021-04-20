public class Brinquedo extends Produto {
private String marca;
private int idadeMinimaRecomendada;
    public Brinquedo(String descricao) {
        super(descricao, "url do brinquedo");
    }

    public String getMarca() {

        return marca;
    }

    public int getIdadeMinimaRecomendada() {

        return idadeMinimaRecomendada;
    }
}

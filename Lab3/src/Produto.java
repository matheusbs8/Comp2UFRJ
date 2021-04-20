public class Produto {
    private float preco;
    private String descricao;
    private String urlDaImagem;
    private int pesoEmGramas;
    private Dimensoes dimensoes;
    public Produto(String descricao, String urlDaImagem) {
        this.descricao=descricao;
        this.urlDaImagem=urlDaImagem;
    }

    /**
     * @return uma descrição textual do produto
     */
    public String getDescricao() {
        return descricao;
    }

    public int getPesoEmGramas() {
        return pesoEmGramas;
    }

    public Dimensoes getDimensoes() {
        return dimensoes;
    }

    public float precoEmReais() {
        return preco;
    }

    public void setPrecoEmReais(float preco) {
        this.preco= (float) (preco*1.00);
    }

    public String getUrlDaImagem() {
        return urlDaImagem;
    }
}

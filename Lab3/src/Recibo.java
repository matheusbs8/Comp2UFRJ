public class Recibo {
    private Produto produto;
    private int quantidade;
    private Usuario comprador;

    public Recibo(Produto produto, int quantidade, Usuario comprador){
        this.comprador=comprador;
        this.quantidade=quantidade;
        this.produto=produto;
    }

    public float getValorTotalDaCompra() {

        return quantidade*produto.precoEmReais();
    }

    public Usuario getUsuario() {
        return comprador;
    }

    @Override
    public String toString() {

        return String.format("Recibo no valor de R$%.2f para %s referente à compra de %d unidades de %s", getValorTotalDaCompra(), comprador.getNome(), quantidade, produto.getDescricao());
    }
}

import java.util.ArrayList;

/**
 * Implementa uma loja virtual para produtos de qualquer tipo,
 * desde que tenham descrição, preço e dimensões.
 *
 * Essa classe será um singleton, isto é, permitiremos apenas
 * uma instância desde objeto no sistema.
 */
public class Loja {
    ArrayList<Usuario> usuarios = new ArrayList();
    ArrayList<ItemEstoque> estoque = new ArrayList();

    private static final Loja instanciaUnica = new Loja();

    static {
        System.out.println("Estou subindo a classe Loja...");
    }

    protected Loja() {
        // escrevo código normalmente para o construtor
    }

    public static Loja getInstanciaUnica() {
        return instanciaUnica;
    }

    /**
     * Inclui no estoque da loja a quantidade informado do produto.
     *
     * @param produto o produto a ser incluído
     * @param quantidadeAIncluir a quantidade que será acrescentada à quantidade existente.
     */
    public void incluirProduto(Produto produto, int quantidadeAIncluir) {
        int cont=0, indice=0;
        for (int i=0; i<estoque.size(); i++){
            if (estoque.get(i).produto.equals(produto)){
                cont++;
                indice=i;
                break;
            }
        }
        if(cont==0){
            ItemEstoque item = new ItemEstoque(produto, quantidadeAIncluir);
            estoque.add(item);
        }
        else{
            estoque.get(indice).quantidade+=quantidadeAIncluir;
        }
    }

    public void cadastrarUsuario(Usuario usuario) {
        int cont =0;
        for (int i=0; i<usuarios.size(); i++){
            if(usuario.equals(usuarios.get(i))){
                cont++;
            }
        }
        if (cont==0){
            usuarios.add(usuario);
        }
    }

    /**
     * Efetua a venda do produto desejado na quantidade especificada.
     *
     * @param produto o produto
     * @param quantidadeDesejada a quantidade
     *
     * @return um Recibo indicando a venda feita, se o produto existia (em quantidade suficiente)
     *         no estoque da loja; null, caso o usuário ou o produto sejam desconhecidos,
     *         ou não haja quantidade suficiente do produto desejado
     */
    public Recibo efetuarVenda(Produto produto, int quantidadeDesejada, Usuario usuario) {
        int cont=0;
        Usuario comprador=null;
        for(int i=0; i<usuarios.size();i++){
            if(usuario.equals(usuarios.get(i))){
                comprador=usuarios.get(i);
                cont++;
                break;
            }
        }
        if(cont==0){
            return null;
        }
        else{
            cont=0;
            int indice=-1;
            for(int i=0; i<estoque.size();i++){
                if(produto.equals(estoque.get(i).produto)){
                    cont++;
                    indice=i;
                    break;
                }
            }
            if(cont==0){
                return null;
            }
            else{
                if(estoque.get(indice).quantidade<quantidadeDesejada)
                    return  null;
                else{
                    estoque.get(indice).quantidade-=quantidadeDesejada;
                     return new Recibo(estoque.get(indice).produto, quantidadeDesejada, comprador);
                }

            }
        }

    }

    /**
     * @param produto o produto a ser consultado
     *
     * @return a quantidade em estoque;
     *         0 se não houver nenhuma unidade;
     *         -1 se o produto não é sequer vendido pela loja
     */
    public int informarQuantidadeEmEstoque(Produto produto) {
        int cont=0, indice=-1;
        for(int i=0; i<estoque.size(); i++){
            if(estoque.get(i).produto.equals(produto)){
                cont++;
                indice=i;
            }
        }
        if (cont==0){
            return -1;
        }
        else{
            return estoque.get(indice).quantidade;
        }

    }

    private class ItemEstoque {

        public Produto produto;

        int quantidade;


        ItemEstoque(Produto produto, int quantidade) {
            this.produto=produto;
            this.quantidade=quantidade;
        }
    }

}

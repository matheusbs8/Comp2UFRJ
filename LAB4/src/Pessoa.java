public class Pessoa {
    public Pessoa(String nome){
        this.nome=nome;

    }
    public final static int TAMANHO_MAXIMO_DO_NOME = 30;
    private String nome;
    private int anoNascimento;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.length() > TAMANHO_MAXIMO_DO_NOME) {
            // ToDo: lançar uma exceção!!!
            return;
        }

        this.nome = nome;
    }
    public int getAnoNascimento() {
        return anoNascimento;
    }
}


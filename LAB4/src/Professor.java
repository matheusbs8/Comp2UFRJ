//Nome: Matheus Barroso de Santana
//DRE:120041661
public class Professor extends Pessoa{
    private int anoContratacao;
    public Professor(String nome, int anoContratacao){
        super(nome);
        this.anoContratacao=anoContratacao;
    }

    public int getAnoContratacao(){
        return anoContratacao;
    }

}

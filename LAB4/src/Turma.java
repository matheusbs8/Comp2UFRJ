import java.util.HashMap;
import java.util.Map;

public class Turma {
    private  Disciplina disciplina;
    private Periodo periodo;
    private Professor professor;
    private static HashMap<Long, NotaAluno> notas= new HashMap<>();

    public Turma(Disciplina disciplina, Periodo periodo, Professor professor){
        this.periodo=periodo;
        this.professor=professor;
        this.disciplina=disciplina;

    }
    public void inscreverAluno(Aluno aluno){
        if(Siguinha.getAlunoBydre().get(aluno.getDre())==null){
            System.out.println("aluno não é cadastrado");
        }
        else{
            notas.put(aluno.getDre(), new NotaAluno(aluno));
        }
    }

    public void atribuirMediaFinal(long dre, float nota){
        if(notas.get(dre) ==null){
            System.out.println("aluno não pertence a turma");
        }
        else {
            notas.get(dre).a.inserirItemHistorico(disciplina, nota, periodo);
            notas.get(dre).mediaFinal=nota;

        }
    }

    public float obterMediaFinal(long dre){
        if(notas.get(dre) ==null ){
            System.out.println("aluno não pertence a turma");
            return -1;
        }
        else {
            if(notas.get(dre).mediaFinal==-1){
                System.out.println("aluno sem nota atribuida");
                return  -1;
            }

           return notas.get(dre).mediaFinal;
        }
    }

    public String listarAlunos(){
        String lista ="";
        for (Map.Entry<Long, NotaAluno> parChaveValor : notas.entrySet()) {
            long chave = parChaveValor.getKey();
            Aluno valor = parChaveValor.getValue().a;
            lista+=""+chave+"----->"+valor.getNome();
            lista+="\n";
        }
        return lista;
    }

    private class NotaAluno {

        public Aluno a;
        float mediaFinal;
        private NotaAluno(Aluno a){
            this.a=a;
            this.mediaFinal=-1;
        }


    }

}

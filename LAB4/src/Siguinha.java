//Nome: Matheus Barroso de Santana
//DRE:120041661
import java.util.Calendar;
import java.util.HashMap;

public class Siguinha {

    public final static float MEDIA_MINIMA_PARA_APROVACAO = 5.0f;

    private static HashMap<Long, Aluno> alunoBydre = new HashMap<>();

    private static Periodo periodoCorrente = null;

    public static HashMap<Long, Aluno> getAlunoBydre() {
        return alunoBydre;
    }

    String instituicaoDeEnsino;

    public static int obterAnoCorrente() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    private static int obterSemestreCorrente() {
        return obterMesCorrente() <= 6 ? 1 : 2;
    }

    public static int obterMesCorrente() {
        return Calendar.getInstance().get(Calendar.MONTH);
    }

    public static Periodo obterPeriodoCorrente() {

        if (periodoCorrente != null) {
            if (periodoCorrente.getAno() != obterAnoCorrente() ||
                    periodoCorrente.getSemestre() != obterSemestreCorrente()) {
                periodoCorrente = null;  // invalida o cache
            }
        }

        if (periodoCorrente == null) {  // verifica o memo ("cache")
            // atualiza o cache
            periodoCorrente = new Periodo(obterAnoCorrente(), obterSemestreCorrente());
        }

        return periodoCorrente;
    }

    public static void cadastrarAluno(long dre,String nome){
        if(alunoBydre.get(dre)!=null){
            System.out.println("dre já cadastrado");
        }
        else {
            Aluno novo = new Aluno(dre, nome);
            alunoBydre.put(dre, novo);
        }
    }
    public static Aluno obterAluno(long dre){
        if(alunoBydre.get(dre)==null){
            System.out.println("dre não cadastrado");
        }
        return alunoBydre.get(dre);
    }

    // apenas para escrever testes rápidos, por ora
    public static void main(String[] args) {
       /* cadatrarAluno(12345678, "Alberto");
        cadatrarAluno(12345679, "lucas");
        cadatrarAluno(12345670, "ana");
        cadatrarAluno(12345671, "natalia");
        Professor p= new Professor("Eduardo", 2010);
        Disciplina d= new Disciplina("combinatoria",7, "mab347");
        Turma t= new Turma(d, Siguinha.obterPeriodoCorrente(), p);
        t.inscreverAluno(obterAluno(12345678));
        t.inscreverAluno(obterAluno(12345679));
        t.inscreverAluno(obterAluno(12345671));
        //t.inscreverAluno(alunoBydre.get(12345670));

        t.atribuirMediaFinal(12345678, 9);
        t.atribuirMediaFinal(12345670, 8);
        System.out.println(t.obterMediaFinal(12345678));
        System.out.println(t.obterMediaFinal(12345670));
        System.out.println(t.listarAlunos());

        System.out.println(obterAluno(12345678));

        */
       /* HashMap<Integer, String> numerosPorExtenso = new HashMap<>();
        numerosPorExtenso.put(1, "um");
        numerosPorExtenso.put(2, "dois");
        numerosPorExtenso.put(3, "três");
        numerosPorExtenso.put(4, "quatro");

        System.out.println(numerosPorExtenso.get(2));
        System.out.println(numerosPorExtenso.get(600));

        // formar de iterar pelo mapa
        for (Integer chave : numerosPorExtenso.keySet()) {
            System.out.println(chave);
        }

        // formar de iterar pelo mapa
        for (String valor : numerosPorExtenso.values()) {
            System.out.println(valor);
        }

        for (Map.Entry<Integer, String> parChaveValor : numerosPorExtenso.entrySet()) {
            Integer chave = parChaveValor.getKey();
            String valor = parChaveValor.getValue();
            System.out.println(chave + " ---> " + valor);
        }*/

    }
}

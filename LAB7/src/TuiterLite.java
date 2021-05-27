//Nome: Matheus Barroso de Santana
//DRE: 120041661
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *  Esta classe implementa um sistema de mensagens curtas estilo Twitter.
 *  É preciso cadastrar um usuário, identificado pelo seu e-mail, para que tuítes possam ser feitos.
 *  Usuários começam como iniciantes, depois são promovidos a senior e a ninja, em função do número de tuítes.
 *  Existe um tamanho máximo permitido por mensagem (constante TAMANHO_MAXIMO_TUITES).
 *  As mensagens podem conter hashtags (palavras iniciadas por #), que são detectadas automaticamente.
 *  Os tuítes podem conter, além da mensagem de texto, um anexo qualquer.
 *  Há um método para retornar, a qualquer momento, qual a hashtag mais usada em toda a história do sistema.
 */
public class TuiterLite {

    public static int TAMANHO_MAXIMO_TUITES = 120;
    private String mais="";
    private int cont=0;

    /**
     * Cadastra um usuário, retornando o novo objeto Usuario criado.
     * @param nome O nome do usuário.
     * @param email O e-mail do usuário (precisa ser único no sistema).
     * @return O Usuario criado.
     */
    HashSet<Usuario> usuarios = new HashSet<>();
    HashMap<String, Integer> htags = new HashMap<>();

    public Usuario cadastrarUsuario(String nome, String email) {  // throws UsuarioJaExisteException {
        Usuario novo= new Usuario(nome, email);
        if(usuarios.contains(novo)){
            return null;
        }
        usuarios.add(novo);
        return novo;
    }

    /**
     *
     * @param usuario O autor do tuíte
     * @param texto O texto desejado
     * @return Um "tuíte", que será devidamente publicado no sistema
     *
     * PS.: Se o texto exceder o limite pré-definido, ou o usuário não estiver cadastrado, return null
     */
    public Tuite tuitarAlgo(Usuario usuario, String texto) {
        Set<String> hashtags=new HashSet<>();
        if(texto.length()>TAMANHO_MAXIMO_TUITES)
            return null;
        int index=texto.indexOf('#');
        if(index!=-1) {
            String tex = texto.substring(index);
            String tags[] = tex.split("#");
            int j = 0;
            for (int i = 0; i < tags.length; i++) {
                if(tags[i]=="")
                    continue;
                j = 1;
                int t = tags[i].indexOf(' ');
                String s = "";
                if (t != -1)
                    s = "#" + tags[i].substring(0, tags[i].indexOf(' '));
                else {
                    s = "#" + tags[i];
                }
                if (!(hashtags.contains(s))) {
                    hashtags.add(s);
                    // System.out.println(s);
                }
                if (htags.get(s) == null) {
                    htags.put(s, j);
                } else {
                    j += htags.get(s);
                    htags.put(s, j);
                }
                if (j > cont) {
                    cont = j;
                    mais = s;
                }
            }
        }
        return  new Tuite(usuario, texto, hashtags);


    }

    /**
     * Retorna a hashtag mais comum dentre todas as que já apareceram.
     * A cada tuíte criado, hashtags devem ser detectadas automaticamente para que este método possa funcionar.
     * @return A hashtag mais comum, ou null se nunca uma hashtag houver sido tuitada.
     */
    public String getHashtagMaisComum() {

        return mais;
    }
}

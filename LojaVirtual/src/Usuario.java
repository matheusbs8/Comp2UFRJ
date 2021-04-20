public class Usuario {
    private  String nome;
    private long cpf;
    private String endereco;
    public Usuario(String nome, long cpf, String endereco) {
        this.cpf=cpf;
        this.nome=nome;
        this.endereco=endereco;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Usuario usuario = (Usuario) object;
        return cpf == usuario.cpf;
    }


}

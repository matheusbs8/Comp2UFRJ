package modelo;

import java.util.ArrayList;
import java.util.Objects;

public class Usuario {

    private String nome;
    private  long cpf;
    private String endereco;
    private ArrayList<Livro> livros = new ArrayList();

    public Usuario(String nome, long cpf) {
        this.cpf=cpf;
        this.nome=nome;
    }

    public int getEnprestimos() {
        return livros.size();
    }
    public  ArrayList getLivros(){
        return livros;
    }

    public void setEnprestimos(Livro enprestimo) {
        livros.add(enprestimo);
    }

    public long getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome=nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco=endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return cpf == usuario.cpf;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}

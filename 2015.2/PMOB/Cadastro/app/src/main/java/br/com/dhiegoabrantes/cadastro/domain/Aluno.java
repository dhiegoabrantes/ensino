package br.com.dhiegoabrantes.cadastro.domain;

/**
 * Created by dhiego on 15/08/15.
 */
public class Aluno {

    private String nome;
    private String site;
    private String endereco;
    private String telefone;
    private float nota;

    public Aluno(){

    }

    public Aluno(String nome, String site, String endereco, String telefone, float nota){
        this.nome = nome;
        this.site = site;
        this.endereco = endereco;
        this.telefone = telefone;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public float getNota() {
        return nota;
    }

    public void setNota(float nota) {
        this.nota = nota;
    }
}

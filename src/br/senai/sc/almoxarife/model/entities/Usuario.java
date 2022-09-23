package br.senai.sc.almoxarife.model.entities;

public class Usuario {

    private String email;
    private String nome;
    private String usuario;
    private String senha;
    private nivelAcesso nivelAcesso;

    public Usuario(String email, String nome, String usuario, String senha, nivelAcesso nivelAcesso) {
        this.email = email;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.nivelAcesso = nivelAcesso;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public nivelAcesso getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(nivelAcesso nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

}

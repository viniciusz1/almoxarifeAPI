package br.senai.sc.almoxarife.model.entities;

public class Usuario {
    private String email, nome, usuario, senha, telefone, nivelAcesso;

    public Usuario(String email, String nome, String usuario, String senha, String telefone, String nivelAcesso) {
        this.email = email;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.telefone = telefone;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }
}

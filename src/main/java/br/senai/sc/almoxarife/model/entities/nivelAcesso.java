package br.senai.sc.almoxarife.model.entities;

public enum nivelAcesso {
    Professor("Professor"), //0
    Antendente("Atendente"), //1
    Supervisor("Supervisor"), //2
    Administrador("Administrador"); //3
    String nivelAcesso;
    nivelAcesso(String nivelacesso){
        this.nivelAcesso = nivelacesso;
    }
}

package br.senai.sc.almoxarife.model.entities;

public enum Status {
    AGUARDANDO("Aguardando Entrega"), //0
    DEVOLVIDO("Devolvido"), //1
    ENTREGUE("Entregue"); //2
    String status;
    Status(String status){
        this.status = status;
    }
    Status(){}
}

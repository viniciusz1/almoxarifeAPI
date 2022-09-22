package br.senai.sc.almoxarife.model.entities;

public enum Status {
    AGUARDANDO("Aguardando Entrega"),
    DEVOLVIDO("Devolvido"),
    ENTREGUE("Entregue");
    String status;
    Status(String status){
        this.status = status;
    }
    Status(){}
}

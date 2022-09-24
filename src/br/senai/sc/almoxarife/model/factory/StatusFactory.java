package br.senai.sc.almoxarife.model.factory;

import br.senai.sc.almoxarife.model.entities.Status;

public class StatusFactory {
    public Status getStatus(Integer ordinal){
        switch (ordinal){
            case 1 -> {
                return Status.DEVOLVIDO;
            }
            case 2 -> {
                return Status.ENTREGUE;
            }
            default -> {
                return Status.AGUARDANDO; //0
            }
        }
    }
}

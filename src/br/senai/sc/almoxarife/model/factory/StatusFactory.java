package br.senai.sc.almoxarife.model.factory;

import br.senai.sc.almoxarife.model.entities.Status;

public class StatusFactory {
    public Status getStatus(Integer ordinal){
        switch (ordinal){
            case 0 -> {
                return Status.AGUARDANDO;
            }
            case 1 -> {
                return Status.DEVOLVIDO;
            }
            default -> {
                return Status.ENTREGUE;
            }
        }
    }
}

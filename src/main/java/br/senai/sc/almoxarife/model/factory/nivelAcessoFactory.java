package br.senai.sc.almoxarife.model.factory;

import br.senai.sc.almoxarife.model.entities.Status;
import br.senai.sc.almoxarife.model.entities.nivelAcesso;

public class nivelAcessoFactory {
    public nivelAcesso getNivelAcesso(Integer ordinal){
        switch (ordinal){
            case 1 -> {
                return nivelAcesso.Antendente;
            }
            case 2 -> {
                return nivelAcesso.Supervisor;
            }
            case 3 -> {
                return nivelAcesso.Administrador;
            }
            default -> {
                return nivelAcesso.Professor; //0
            }
        }
    }
}

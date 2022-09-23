package br.senai.sc.almoxarife.controller;

import br.senai.sc.almoxarife.model.entities.Entrada;
import br.senai.sc.almoxarife.model.service.EntradaService;

import java.util.ArrayList;

public class EntradaController {

    public void inserir(Entrada entrada){
        new EntradaService().inserir(entrada);
    }

    public ArrayList<Entrada> buscarTodasEntradas(){
        return new EntradaService().buscarTodasEntradas();
    }


}

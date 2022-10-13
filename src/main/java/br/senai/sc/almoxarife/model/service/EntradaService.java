package br.senai.sc.almoxarife.model.service;

import br.senai.sc.almoxarife.model.dao.EntradaDAO;
import br.senai.sc.almoxarife.model.entities.Entrada;

import java.util.ArrayList;

public class EntradaService {

    public void inserir(Entrada entrada){
        new EntradaDAO().inserirEntrada(entrada);
    }

    public ArrayList<Entrada> buscarTodasEntradas(){
            return new EntradaDAO().buscarTodasEntradas();
    }



}

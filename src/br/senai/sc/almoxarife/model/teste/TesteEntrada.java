package br.senai.sc.almoxarife.model.teste;

import br.senai.sc.almoxarife.model.dao.EntradaDAO;
import br.senai.sc.almoxarife.model.entities.Entrada;


import java.text.DateFormat;
import java.util.Date;

public class TesteEntrada {
    public static void main(String[] args) {
//        Date data = new Date();
//        DateFormat dfs = DateFormat.getDateInstance(DateFormat.SHORT);
//        new EntradaDAO().inserirEntrada(new Entrada(1, 12, 1, data));
        System.out.println(new EntradaDAO().buscarTodasEntradas());
    }
}

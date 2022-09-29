package br.senai.sc.almoxarife.model.dao;

import br.senai.sc.almoxarife.model.entities.Pedido;
import br.senai.sc.almoxarife.model.entities.Status;
import br.senai.sc.almoxarife.model.factory.Builder;
import br.senai.sc.almoxarife.model.factory.ConexaoFactory;
import br.senai.sc.almoxarife.model.factory.StatusFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

public class PedidoDAO {
    private Connection conn;
    public PedidoDAO() {
        this.conn = new ConexaoFactory().conectaBD();
    }
    //PROBLEMA: PARA PEGAR UM PEDIDO, TEM QUE DAR JOIN ENTRE PEDIDOPRODUTO, PRODUTO
    public ArrayList<Pedido> buscarTodosPedidos() {
        ArrayList<Pedido> listaDePedidos = new ArrayList<>();
        Builder builder = new Builder();
        builder.Append("SELECT pedido.codigo as codigoPedido");
        builder.Append(",pedido.dataEntrega");
        builder.Append(",pedido.dataDevolucao");
        builder.Append(",pedido.usuarioEmail");
        builder.Append(",pedido.status");
        builder.Append(",produtoPedido.quantidade");
        builder.Append(",produto.*");
        builder.Append("from pedido");
        builder.Append("JOIN produtoPedido");
        builder.Append("ON produtoPedido.pedidoCodigo=pedido.codigo");
        builder.Append("JOIN produto ");
        builder.Append("ON produto.codigo=produtoPedido.produtoCodigo");
        String sql = builder.Build();
        try (PreparedStatement prtm = conn.prepareStatement(sql)) {
            ResultSet resultSet = prtm.executeQuery();
            while (resultSet.next()) {
                Pedido pedido = extrairObjetoPedido(resultSet);
                int cont = 0;
                for(Pedido p : listaDePedidos){
                    if(p.getCodigo() == pedido.getCodigo()){
                        listaDePedidos.get(listaDePedidos.indexOf(p)).
                                addProduto(new ProdutoDAO().extrairObjetoProduto(resultSet));
                        cont++;
                    }
                }
                if(cont == 0){
                    pedido.addProduto(new ProdutoDAO().extrairObjetoProduto(resultSet));
                    listaDePedidos.add(pedido);
                }
            }
            listaDePedidos.forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaDePedidos;
    }

    public static void main(String[] args) {
        Builder builder = new Builder();
        builder.Append("SELECT pedido.*");
        builder.Append("from pedido");
        builder.Append("join usuario");
        builder.Append("on usuario.email = ?;");
        String sql = builder.Build();
        System.out.println(sql);
    }


    public ArrayList<Pedido> buscarPedidosProfessor(String emailProfessor) {
        ArrayList<Pedido> listaDePedidos = new ArrayList<>();
        Builder builder = new Builder();
        builder.Append("SELECT pedido.codigo as codigoPedido");
        builder.Append(",pedido.dataEntrega");
        builder.Append(",pedido.dataDevolucao");
        builder.Append(",pedido.usuarioEmail");
        builder.Append(",pedido.status");
        builder.Append(",produtoPedido.quantidade");
        builder.Append(",produto.*");
        builder.Append("from pedido");
        builder.Append("JOIN produtoPedido");
        builder.Append("ON produtoPedido.pedidoCodigo=pedido.codigo");
        builder.Append("JOIN produto ");
        builder.Append("ON produto.codigo=produtoPedido.produtoCodigo");
        builder.Append("WHERE pedido.usuarioEmail=?;");
        String sql = builder.Build();
        try (PreparedStatement prtm = conn.prepareStatement(sql)) {
            prtm.setString(1, emailProfessor);
            ResultSet resultSet = prtm.executeQuery();
            while (resultSet.next()) {
                Pedido pedido = extrairObjetoPedido(resultSet);
                int cont = 0;
                for(Pedido p : listaDePedidos){
                    if(p.getCodigo() == pedido.getCodigo()){
                        listaDePedidos.get(listaDePedidos.indexOf(p)).
                        addProduto(new ProdutoDAO().extrairObjetoProduto(resultSet));
                        cont++;
                    }
                }
                if(cont == 0){
                    pedido.addProduto(new ProdutoDAO().extrairObjetoProduto(resultSet));
                    listaDePedidos.add(pedido);
                }
            }
            System.out.println(listaDePedidos.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaDePedidos;
    }

    public Pedido extrairObjetoPedido(ResultSet resultSet) {
        try {
            return new Pedido(
                    resultSet.getInt("codigoPedido"),
                    resultSet.getString("usuarioEmail"),
                    resultSet.getDate("dataEntrega"),
                    resultSet.getDate("dataDevolucao"),
                    new StatusFactory().getStatus(resultSet.getInt("status")));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao extrair o pedido! extrairObjetoPedido");
        }
    }

    public Pedido buscarPedidoPorCodigo(int codigoPedido) {
        Pedido pedidoRetorno = new Pedido();
        Builder builder = new Builder();
        builder.Append("SELECT pedido.codigo as codigoPedido");
        builder.Append(",pedido.dataEntrega");
        builder.Append(",pedido.dataDevolucao");
        builder.Append(",pedido.usuarioEmail");
        builder.Append(",pedido.status");
        builder.Append(",produtoPedido.quantidade");
        builder.Append(",produto.*");
        builder.Append("from pedido");
        builder.Append("JOIN produtoPedido");
        builder.Append("ON produtoPedido.pedidoCodigo=pedido.codigo");
        builder.Append("JOIN produto ");
        builder.Append("ON produto.codigo=produtoPedido.produtoCodigo");
        builder.Append("WHERE pedido.codigo = ?");
        String sql = builder.Build();
        try (PreparedStatement prtm = conn.prepareStatement(sql)) {
            prtm.setInt(1, codigoPedido);
            try (ResultSet resultSet = prtm.executeQuery();){
                int cont = 0;
                while (resultSet.next()) {
                    if(cont != 0){
                        pedidoRetorno = extrairObjetoPedido(resultSet);
                    }
                    cont++;
                    pedidoRetorno.addProduto(new ProdutoDAO().extrairObjetoProduto(resultSet));
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            return pedidoRetorno;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pedidoRetorno;
    }

    public ArrayList<Pedido> buscarPedidosPorStatus(Status status) {
        ArrayList<Pedido> listaDePedidos = new ArrayList<>();
        Builder builder = new Builder();
        builder.Append("SELECT pedido.codigo as codigoPedido");
        builder.Append(",pedido.dataEntrega");
        builder.Append(",pedido.dataDevolucao");
        builder.Append(",pedido.usuarioEmail");
        builder.Append(",pedido.status");
        builder.Append(",produtoPedido.quantidade");
        builder.Append(",produto.*");
        builder.Append("from pedido");
        builder.Append("JOIN produtoPedido");
        builder.Append("ON produtoPedido.pedidoCodigo=pedido.codigo");
        builder.Append("JOIN produto ");
        builder.Append("ON produto.codigo=produtoPedido.produtoCodigo");
        builder.Append("WHERE pedido.status=?;");
        String sql = builder.Build();
        try (PreparedStatement prtm = conn.prepareStatement(sql)) {
            prtm.setInt(1, status.ordinal());
            ResultSet resultSet = prtm.executeQuery();
            while (resultSet.next()) {
                Pedido pedido = extrairObjetoPedido(resultSet);
                int cont = 0;
                for(Pedido p : listaDePedidos){
                    if(p.getCodigo() == pedido.getCodigo()){
                        listaDePedidos.get(listaDePedidos.indexOf(p)).
                                addProduto(new ProdutoDAO().extrairObjetoProduto(resultSet));
                        cont++;
                    }
                }
                if(cont == 0){
                    pedido.addProduto(new ProdutoDAO().extrairObjetoProduto(resultSet));
                    listaDePedidos.add(pedido);
                }
            }
            System.out.println(listaDePedidos.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaDePedidos;
    }

    public ArrayList<Pedido> buscarPedidosEntradaPorData(Date data) {

        ArrayList<Pedido> listaDePedidos = new ArrayList<>();
        Builder builder = new Builder();
        builder.Append("SELECT pedido.codigo as codigoPedido");
        builder.Append(",pedido.dataEntrega");
        builder.Append(",pedido.dataDevolucao");
        builder.Append(",pedido.usuarioEmail");
        builder.Append(",pedido.status");
        builder.Append(",produtoPedido.quantidade");
        builder.Append(",produto.*");
        builder.Append("from pedido");
        builder.Append("JOIN produtoPedido");
        builder.Append("ON produtoPedido.pedidoCodigo=pedido.codigo");
        builder.Append("JOIN produto ");
        builder.Append("ON produto.codigo=produtoPedido.produtoCodigo");
        builder.Append("WHERE pedido.dataEntrega=?;");
        String sql = builder.Build();
        try (PreparedStatement prtm = conn.prepareStatement(sql)) {
            prtm.setString(1, data.toString());
            ResultSet resultSet = prtm.executeQuery();
            while (resultSet.next()) {
                Pedido pedido = extrairObjetoPedido(resultSet);
                int cont = 0;
                for(Pedido p : listaDePedidos){
                    if(p.getCodigo() == pedido.getCodigo()){
                        listaDePedidos.get(listaDePedidos.indexOf(p)).
                                addProduto(new ProdutoDAO().extrairObjetoProduto(resultSet));
                        cont++;
                    }
                }
                if(cont == 0){
                    pedido.addProduto(new ProdutoDAO().extrairObjetoProduto(resultSet));
                    listaDePedidos.add(pedido);
                }
            }
            System.out.println(listaDePedidos.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listaDePedidos;
    }

    public ArrayList<Pedido> buscarPedidoDevolucaoPorData(Date data) {
        ArrayList<Pedido> listaDePedidos = new ArrayList<>();
        String query = "select * from pedido where dataDevolucao = ?";
        try (PreparedStatement prtm = conn.prepareStatement(query)) {
            prtm.setDate(1, (java.sql.Date) data);
            try (ResultSet resultSet = prtm.executeQuery()) {
                if (resultSet.next()) {
                    listaDePedidos.add(extrairObjetoPedido(resultSet));
                }
                return listaDePedidos;
            } catch (Exception e) {
                throw new RuntimeException("Erro na execução do comando SQL!");
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro na preparação do comando SQL!");
        }
    }

    public void inserirPedidoDB(Pedido pedido) {
        //mais complexo
    }

}

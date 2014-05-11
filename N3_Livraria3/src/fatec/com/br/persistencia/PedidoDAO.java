/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fatec.com.br.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class PedidoDAO implements DAO<PedidoVO> {
    
    //Variaveis auxiliares
    Statement stm = null;
    PreparedStatement pstm = null;
    private Banco banco=null;
    ResultSet rs = null;
    String sql = null;

    public PedidoDAO(Banco banco) {
        this.banco=banco;
    }
    
    @Override
    public boolean inserir(PedidoVO obj) throws SQLException {
         //insere na tabela autor
        boolean retorno;
        sql = "INSERT INTO pedido (codPedido,codUsuario,codLivro,qtd,data) VALUES (?,?,?,?,CURDATE())";
        System.out.println(sql);
        banco.abrir();
        pstm = banco.getConexao().prepareStatement(sql);
        pstm.setInt(1,obj.getCodPedido());
        pstm.setInt(2,obj.getCodCliente());
        pstm.setInt(3,obj.getCodLivro());
        pstm.setInt(4,obj.getQtd());
        retorno = (pstm.executeUpdate() == 0 ? false : true);
        banco.fechar();
        return retorno;
    }

    @Override
    public boolean alterar(PedidoVO obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(PedidoVO obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PedidoVO pesquisar(int pk) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public int proximoCodigoPedido() throws SQLException {
        int codigo;
        sql = "select ifnull(MAX(codPedido), 0)+1 as codigo from pedido";
        banco.abrir();
        pstm = banco.getConexao().prepareStatement(sql);
        rs = pstm.executeQuery(sql);
       //testa se achou alguem
        rs.next();
        codigo = rs.getInt("codigo");
        banco.fechar();
        return codigo;
    }
    @Override
    public List listar(String criterio) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public ResultSet listarPedido(int codCliente) throws SQLException {
        sql = "select p.codPedido,p.data from pedido p, titulo t where p.codLivro=t.cod and codUsuario="+codCliente+" group by codPedido";
        pstm = banco.getConexao().prepareStatement(sql);
        rs = pstm.executeQuery(sql);
       //testa se achou alguem
        return rs;
    }
    public ResultSet listarDetalhes(int codPedido) throws SQLException {
        sql = "select t.titulo, p.qtd, l.precoVenda,(p.qtd*l.precoVenda) as total  from titulo t,pedido p, livro l where p.codLivro=t.cod and t.cod=l.titulo and codPedido="+ codPedido;
        pstm = banco.getConexao().prepareStatement(sql);
        rs = pstm.executeQuery(sql);
       //testa se achou alguem
        return rs;
    }
   
}
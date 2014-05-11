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

/**
 *
 * @author David
 */
public class LivroDAO implements DAO<LivroVO>{
    Statement stm = null;
    PreparedStatement pstm = null;
    private Banco banco=null;
    ResultSet rs = null;
    String sql = null;
    
    public LivroDAO(Banco bi){
        this.banco=bi;
    }
            
    @Override
    public boolean inserir(LivroVO obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean alterar(LivroVO obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(LivroVO obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LivroVO pesquisar(int pk) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listar(String criterio) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public ResultSet relatorioVenda(){
        try{
            sql = "select COUNT(p.codLivro) as qtd, t.titulo, (l.precoVenda-l.precoCusto)* qtd from pedido p, titulo t, livro l where  p.codLivro=t.cod and l.titulo=p.codLivro group by p.codLivro order by qtd desc";
            pstm = banco.getConexao().prepareStatement(sql);
            rs = pstm.executeQuery(sql);
        }catch(SQLException ex){
            System.out.println(ex);
        }
       //testa se achou alguem
        return rs;
    }
    public ResultSet relatorioEditora(){
        try{
            sql = "select COUNT(p.codLivro) as qtd, t.titulo, (l.precoVenda-l.precoCusto)* qtd from pedido p, titulo t, livro l where  p.codLivro=t.cod and l.titulo=p.codLivro group by p.codLivro order by qtd desc";
            pstm = banco.getConexao().prepareStatement(sql);
            rs = pstm.executeQuery(sql);
        }catch(SQLException ex){
            System.out.println(ex);
        }
       //testa se achou alguem
        return rs;
    }
        public int contaLivros(int cod){
            int r=0;
            try{
                sql = "select COUNT(*) as qtd from livro where titulo="+cod;
                System.out.println(sql);
                pstm = banco.getConexao().prepareStatement(sql);
                rs = pstm.executeQuery(sql);
                rs.first();
                r=rs.getInt("qtd");
            }catch(SQLException ex){
                System.out.println(ex);
            }
       //testa se achou alguem
        return r;
    }
}

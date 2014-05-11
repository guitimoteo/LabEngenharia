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
public class FuncionarioDAO implements DAO<FuncionarioVO>{
    PreparedStatement pstm = null;
    Statement stm=null;
    Banco banco=null;
    ResultSet rs=null;
    String sql=null;

    public FuncionarioDAO(Banco b) {
        this.banco=b;
    }
    
    @Override
    
    public boolean inserir(FuncionarioVO obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public FuncionarioDAO() {
    }

    @Override
    public boolean alterar(FuncionarioVO obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(FuncionarioVO obj) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FuncionarioVO pesquisar(int pk) throws SQLException {
        FuncionarioVO func=null;
        sql="Select * from funcionario where matricula= "+pk;
        banco.abrir();
        stm=banco.getConexao().createStatement();
        rs=stm.executeQuery(sql);
        if(rs.next()){
            func=new FuncionarioVO();
            func.setMatricula(rs.getInt("matricula"));
            func.setSenha(rs.getInt("senha"));
            func.setNome(rs.getString("nome"));
        }
        banco.fechar();
        return func;
       }

    @Override
    public List listar(String criterio) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

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
import java.util.Vector;
import n3_livraria2.Cliente;

/**
 *
 * @author David
 */
public class ClienteDAO implements DAO<Cliente>{
    PreparedStatement pstm = null;
    Statement stm=null;
    Banco banco=null;
    ResultSet rs=null;
    String sql=null;

    public ClienteDAO(Banco banco) {
        this.banco=banco;
    }
    
    @Override
    public boolean inserir(Cliente obj) throws SQLException {
        sql="insert into usuario (login,senha,nome,dataNasc,endereco,cpf) Values(?,?,?,?,?,?)";
        banco.abrir();
        pstm=banco.getConexao().prepareStatement(sql);
        pstm.setString(1, obj.getLogin());
        pstm.setString(2, obj.getSenha());
        pstm.setString(3, obj.getNome());
        pstm.setString(4, obj.getNascimento());
        pstm.setString(5, obj.getEndereco());
        pstm.setString(6, obj.getCpf());
        boolean retorno;
        retorno=(pstm.executeUpdate()==0 ? false:true);
        banco.fechar();
        return retorno;
    }

    @Override
    public boolean alterar(Cliente obj) throws SQLException {
        sql="update usuario set nome=?, senha=?, dataNasc=?, endereco=?, cpf=? where login= ?";
        banco.abrir();
        pstm=banco.getConexao().prepareStatement(sql);
        pstm.setString(2, obj.getSenha());
        pstm.setString(1, obj.getNome());
        pstm.setString(3, obj.getNascimento());
        pstm.setString(4, obj.getEndereco());
        pstm.setString(5, obj.getCpf());
        pstm.setString(6, obj.getLogin());
        boolean retorno;
        retorno=(pstm.executeUpdate()==0 ? false:true);
        banco.fechar();
        return retorno;
    }

    @Override
    public boolean excluir(Cliente obj) throws SQLException {
        sql="delete from usuario where login= ?";
        banco.abrir();
        pstm=banco.getConexao().prepareStatement(sql);
        pstm.setString(1, obj.getLogin());
        boolean retorno;
        retorno=(pstm.executeUpdate()==0 ? false:true);
        banco.fechar();
        return retorno;
    }

    @Override
    public Cliente pesquisar(int pk) throws SQLException {
        Cliente cli=null;
        sql="Select * from usuario where login= "+pk;
        banco.abrir();
        stm=banco.getConexao().createStatement();
        rs=stm.executeQuery(sql);
        if(rs.next()){
            cli=new Cliente();
            cli.setLogin(rs.getString("login"));
            cli.setSenha(rs.getString("senha"));
            cli.setNome(rs.getString("nome"));
            cli.setNascimento(rs.getString("nascimento"));
            cli.setEndereco(rs.getString("endereco"));
            cli.setCpf(rs.getString("cpf"));
        }
        banco.fechar();
        return cli;
    }
    
    public Cliente pesquisarUsuario(String login) throws SQLException {
        Cliente cli=null;
        sql="Select * from usuario where login like '"+login+"'";
        banco.abrir();
        stm=banco.getConexao().createStatement();
        rs=stm.executeQuery(sql);
        rs.first();
            cli=new Cliente();
            cli.setLogin(rs.getString("login"));
        banco.fechar();
        return cli;
    }
    
     public Cliente pesquisarNomeSenha(String senha,String login) throws SQLException {
        Cliente cli=null;
        sql="Select * from usuario where senha like '"+senha+"' and login like '"+login+"'";
        banco.abrir();
        stm=banco.getConexao().createStatement();
        rs=stm.executeQuery(sql);
        rs.first();
            cli=new Cliente();
            cli.setLogin(rs.getString("login"));
            cli.setSenha(rs.getString("senha"));
            cli.setNome(rs.getString("nome"));
            cli.setNascimento(rs.getDate("dataNasc").toString());
            cli.setEndereco(rs.getString("endereco"));
            cli.setCpf(rs.getString("cpf"));
        banco.fechar();
        return cli;
    }
    public int pesquisarCodigo(String senha,String login) throws SQLException {
        int cod=0;
        sql="Select cod from usuario where senha like '"+senha+"' and login like '"+login+"'";
        banco.abrir();
        stm=banco.getConexao().createStatement();
        rs=stm.executeQuery(sql);
        if(rs.next()){
           cod=rs.getInt("cod");
        }
        banco.fechar();
        return cod;
    }
    @Override
    public List listar(String criterio) throws SQLException {
        Vector lista = new Vector<Cliente>();
        
        return lista;
    }
    
    
}

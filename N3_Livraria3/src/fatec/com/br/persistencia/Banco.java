/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.com.br.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;


/**
 *
 * @author david
 */
public class Banco {
    public Banco(){
        
    }
    public Banco(String usuario, String senha, String porta, String servidor, String nomeBanco) {
        this.usuario = usuario;
        this.senha = senha;
        this.porta = porta;
        this.servidor = servidor;
        this.nomeBanco = nomeBanco;
    }
    private String usuario, senha, porta, servidor, nomeBanco;
    private Connection conexao=null;
    private ResultSet rs=null;
    private Statement stm=null;
    
    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public String getPorta() {
        return porta;
    }

    public String getServidor() {
        return servidor;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setPorta(String porta) {
        this.porta = porta;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }
    public void abrir(){
       try {
            Class.forName("com.mysql.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
      
        try{
            
            String strCon = "jdbc:mysql://"+servidor+":"+porta+"/"+nomeBanco;
            conexao = DriverManager.getConnection(strCon, usuario, senha);
        }
        catch(Exception ee){
            System.out.println(ee);
            
        }
    }
    public void fechar(){
        try {
            conexao.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    public Connection getConexao(){
       return conexao;
    }
    public int atualizar(String sql){
            
        try {
            stm = conexao.createStatement();
            return stm.executeUpdate(sql);
        } catch (SQLException ex) {
            System.out.println(ex);
            return -1;
        }
    }
    public ResultSet selecionar(String sql){
        try{           
            stm = conexao.createStatement();
            rs = stm.executeQuery(sql);
            return rs;    
           }
            catch(Exception erro){
                System.out.println(erro);
            }
        return rs;
    }
}

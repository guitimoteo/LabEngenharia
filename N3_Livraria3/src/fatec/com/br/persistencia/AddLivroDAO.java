/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.com.br.persistencia;
import fatec.com.br.persistencia.LivroVO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
/**
 *
 * @author Caique
 */
public class AddLivroDAO implements DAO<LivroVO> {

    //Variaveis auxiliares
    Statement stm = null;
    PreparedStatement pstm = null;
    Banco banco = null;
    ResultSet rs = null;
    String sql = null;
    
    public AddLivroDAO(Banco banco) { //composição
        this.banco = banco;
    }
    
    @Override
    public boolean inserir(LivroVO obj) throws SQLException {
        //insere na tabela autor
        boolean retorno;
        sql = "INSERT INTO livro (titulo, dataPublicacao, editora, precoVenda, resumo, indice, precoCusto, autor, formato, categoria) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";
        System.out.println(sql);
        banco.abrir();
        pstm = banco.getConexao().prepareStatement(sql);
        pstm.setInt(1, obj.getCodtitulo());
        pstm.setString(2, obj.getDataPublicacao());
        pstm.setString(3, obj.getEditora());
        pstm.setDouble(4, obj.getPrecoVenda());
        pstm.setString(5, obj.getResumo());
        pstm.setString(6, obj.getIndice());
        pstm.setDouble(7, obj.getPrecoCusto());
        pstm.setInt(8, obj.getCodautor());
        pstm.setString(9, obj.getFormato());
        pstm.setString(10, obj.getCategoria());
        retorno = (pstm.executeUpdate() == 0 ? false : true);
        banco.fechar();
        return retorno;
    }


    @Override
    public boolean excluir(LivroVO obj) throws SQLException {
        boolean retorno;
        sql = "Delete from table livro where id = ?";
        banco.abrir();
        pstm = banco.getConexao().prepareStatement(sql);
        pstm.setInt(1, obj.getCodtitulo());
        retorno = (pstm.executeUpdate() == 0 ? false : true);
        banco.fechar();
        return retorno;
    }
    @Override
    public boolean alterar(LivroVO obj) throws SQLException {
        boolean retorno;
        sql = "update livro  set titulo=?, dataPublicacao=?, editora=?, precoVenda=?, resumo=?, indice=?, precoCusto=?, autor=?, formato=?, categoria=? where id=?";
        System.out.println(sql);
        banco.abrir();
        pstm = banco.getConexao().prepareStatement(sql);
        pstm.setInt(1, obj.getCodtitulo());
        pstm.setString(2, obj.getDataPublicacao());
        pstm.setString(3, obj.getEditora());
        pstm.setDouble(4, obj.getPrecoVenda());
        pstm.setString(5, obj.getResumo());
        pstm.setString(6, obj.getIndice());
        pstm.setDouble(7, obj.getPrecoCusto());
        pstm.setInt(8, obj.getCodautor());
        pstm.setString(9, obj.getFormato());
        pstm.setString(10, obj.getCategoria());
        pstm.setInt(11, obj.getCod());
        retorno = (pstm.executeUpdate() == 0 ? false : true);
        banco.fechar();
        return retorno;
    }

    @Override
    public LivroVO pesquisar(int pk) throws SQLException {
        LivroVO li = new LivroVO();
        sql="Select * from livro where id="+pk;
        System.out.println(sql);
        banco.abrir();
        stm=banco.getConexao().createStatement();
        rs=stm.executeQuery(sql);
        rs.first();
        li.setCodtitulo(rs.getInt("titulo"));
        li.setCodautor(rs.getInt("autor"));
        li.setEditora(rs.getString("editora"));
        li.setFormato(rs.getString("formato"));
        li.setDataPublicacao(rs.getString("dataPublicacao"));
        li.setCategoria(rs.getString("categoria"));
        li.setPrecoVenda(rs.getDouble("precoVenda"));
        li.setPrecoCusto(rs.getDouble("precoCusto"));
        li.setResumo(rs.getString("resumo"));
        li.setIndice(rs.getString("indice"));
        banco.fechar();
        return li;
    }
    public LivroVO pesquisarBasico(int pk) throws SQLException {
        LivroVO li = new LivroVO();
        sql="Select * from livro where titulo="+pk;
        System.out.println(sql);
        banco.abrir();
        stm=banco.getConexao().createStatement();
        rs=stm.executeQuery(sql);
        rs.first();
        li.setCodtitulo(rs.getInt("titulo"));
        li.setCodautor(rs.getInt("autor"));
        li.setEditora(rs.getString("editora"));
        li.setFormato(rs.getString("formato"));
        li.setDataPublicacao(rs.getString("dataPublicacao"));
        li.setCategoria(rs.getString("categoria"));
        li.setPrecoVenda(rs.getDouble("precoVenda"));
        li.setPrecoCusto(rs.getDouble("precoCusto"));
        li.setResumo(rs.getString("resumo"));
        li.setIndice(rs.getString("indice"));
        banco.fechar();
        return li;
    }
    public ResultSet carregaAutor() throws SQLException {
        sql="Select nome from autor";
        stm=banco.getConexao().createStatement();
        rs=stm.executeQuery(sql);
        return rs;
    }
    public ResultSet carregaTitulo() throws SQLException {
        sql="Select titulo from titulo";
        stm=banco.getConexao().createStatement();
        rs=stm.executeQuery(sql);
        return rs;
    }
    public void novoTitulo(){
        try{
            sql = "INSERT INTO titulo (titulo, isbn) VALUES (?,?)";
            banco.abrir();
            pstm = banco.getConexao().prepareStatement(sql);
            pstm.setString(1, JOptionPane.showInputDialog("Digite o titulo."));
            pstm.setString(2, JOptionPane.showInputDialog("Digite o ISBN."));
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null,"Inserido com sucesso!");
            banco.fechar();
        }catch(SQLException ex){
            
        }
    }
    public void novoAutor(){
        try{
            sql = "INSERT INTO autor (nome) VALUES (?)";
            banco.abrir();
            pstm = banco.getConexao().prepareStatement(sql);
            pstm.setString(1, JOptionPane.showInputDialog("Digite o nome."));
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null,"Inserido com sucesso!");
            banco.fechar();
        }catch(SQLException ex){
            
        }
    }
    /**
     * Retorna o numero do proximo cliente
     * @return codigo
     */
    public int proximoCodigotitulo() throws SQLException {
        int codigo;
        sql = "SELECT IFNULL(MAX(cod), 0) + 1 as codigo "  + "FROM titulo";
        banco.abrir();
        stm = banco.getConexao().createStatement();
        rs = stm.executeQuery(sql);
        //sempre vai ter 1 registro
        rs.next();
        codigo = rs.getInt("codigo");
        banco.fechar();
        return codigo;
    }
        public int proximoCodigoautor() throws SQLException {
        int codigo;
        sql = "SELECT IFNULL(MAX(cod), 0) + 1 as codigo "
                + "FROM autor";
        banco.abrir();
        stm = banco.getConexao().createStatement();
        rs = stm.executeQuery(sql);
        //sempre vai ter 1 registro
        rs.next();
        codigo = rs.getInt("codigo");
        banco.fechar();
        return codigo;
    }

    @Override
    public List listar(String criterio) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package n3_livraria2;

import fatec.com.br.persistencia.AddLivroDAO;
import fatec.com.br.persistencia.Banco;
import fatec.com.br.persistencia.LivroDAO;
import fatec.com.br.persistencia.LivroVO;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author david
 */
public class FormPesquisa extends javax.swing.JFrame {
    private Main main;
    private int cod;
    private ResultSet rs;
    private JTable table;
    private Statement stm;
    private Banco banco = new Banco("root", "", "3306","localhost", "livraria");
    private LivroVO li;
    private AddLivroDAO livroDAO = new AddLivroDAO(banco);/**
     * Creates new form FormPesquisa
     */
    public FormPesquisa(Main m) {
        main= m;
        initComponents();
        getContentPane().setBackground(Color.getHSBColor(0.650f,0.158f,0.750f));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPesquisa = new javax.swing.JTextField();
        cbmPesquisa = new javax.swing.JComboBox();
        btPesquisar = new javax.swing.JButton();
        spResultado = new javax.swing.JScrollPane();
        btDetalhes = new javax.swing.JButton();
        btAddCarrinho = new javax.swing.JButton();
        btCarrinho = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Livraria -Pesquisa-");
        setBounds(new java.awt.Rectangle(0, 0, 1000, 700));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        cbmPesquisa.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Titulo", "Autor", "Editora", "Categoria" }));

        btPesquisar.setText("Pesquisar");
        btPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPesquisarActionPerformed(evt);
            }
        });

        btDetalhes.setText("Detalhes");
        btDetalhes.setEnabled(false);
        btDetalhes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDetalhesActionPerformed(evt);
            }
        });

        btAddCarrinho.setText("Adicionar ao carrinho");
        btAddCarrinho.setEnabled(false);
        btAddCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddCarrinhoActionPerformed(evt);
            }
        });

        btCarrinho.setText("Carrinho");
        btCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCarrinhoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spResultado)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbmPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btCarrinho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btDetalhes))
                                .addComponent(btAddCarrinho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbmPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spResultado, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btDetalhes)
                    .addComponent(btCarrinho))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btAddCarrinho)
                .addGap(23, 23, 23))
        );

        setSize(new java.awt.Dimension(1000, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btAddCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddCarrinhoActionPerformed
        // TODO add your handling code here:
        
        String[] item= new String[3];
        String qtd=JOptionPane.showInputDialog("Digite a quantidade:", "1");
        int x = table.getSelectedRow();
        String cod= table.getValueAt(x, 0).toString();
        LivroDAO livroDAO= new LivroDAO(banco);
        int codn= Integer.parseInt(cod);
        int qtdn=Integer.parseInt(qtd);
        int estoque=livroDAO.contaLivros(codn);
        if(qtdn>estoque){
            JOptionPane.showMessageDialog(rootPane,"Não temos livros suficientes!");
        }else{
            item[0]=cod;
            cod= table.getValueAt(x, 1).toString();
            item[1]=cod;
            item[2]=qtd;
            System.out.println(item[0]+" - "+item[1]+" - "+item[2]);
            main.getItens().itens.add(item);
        }
    }//GEN-LAST:event_btAddCarrinhoActionPerformed

    private void btCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCarrinhoActionPerformed
        // TODO add your handling code here:
        main.getCarrinho().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btCarrinhoActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void btDetalhesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDetalhesActionPerformed
        // TODO add your handling code here:
        int x=table.getSelectedRow();
        cod=Integer.parseInt(table.getValueAt(x, 0).toString());
        try {
            li=livroDAO.pesquisarBasico(cod);
        } catch (SQLException ex) {
            Logger.getLogger(FormPesquisa.class.getName()).log(Level.SEVERE, null, ex);
        }
        main.getDetalhes().carregar(li);
        this.setVisible(false);
    }//GEN-LAST:event_btDetalhesActionPerformed

    private void btPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPesquisarActionPerformed
        // TODO add your handling code here:
        rs=null;
        String sql;
        if(cbmPesquisa.getSelectedItem()=="Autor")
            sql= "Select t.cod, t.titulo, a.nome as autor, l.precoVenda as preço from livro l, autor a, titulo t where l.autor=a.cod and l.titulo=t.cod and a.nome like '%"+txtPesquisa.getText()+"%'";
        else if(cbmPesquisa.getSelectedItem()=="Titulo")
            sql= "Select t.cod, t.titulo, a.nome as autor, l.precoVenda as preço from livro l, autor a, titulo t where l.autor=a.cod and l.titulo=t.cod and t.titulo like '%"+txtPesquisa.getText()+"%'";
            else if(cbmPesquisa.getSelectedItem()=="Categoria")
                    sql= "Select t.cod, t.titulo, a.nome as autor, l.precoVenda as preço from livro l, autor a, titulo t, categoria c where l.autor=a.cod and l.categoria=c.cod and l.titulo=t.cod and c.nome like '%"+txtPesquisa.getText()+"%' or l.categoria like '%"+txtPesquisa.getText()+"%'";
                else
                    sql= "Select t.cod, t.titulo, a.nome as autor, l.precoVenda as preço from livro l, autor a, titulo t where l.autor=a.cod and l.titulo=t.cod and l."+cbmPesquisa.getSelectedItem().toString().toLowerCase()+" like '%"+txtPesquisa.getText()+"%'";
        System.out.println(sql);
        try{
            banco.abrir();
            stm=banco.getConexao().createStatement();
            rs=stm.executeQuery(sql);
        }catch(SQLException ex){
            
        }
        montaTabela();       
    }//GEN-LAST:event_btPesquisarActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.setVisible(false);
        main.getPrincipal().setVisible(true);
    }//GEN-LAST:event_formWindowClosing
    private void montaTabela(){
            try{
                DefaultTableModel tableMode1 = new DefaultTableModel(
                        new String[]{},0){ };
                int qtdColunas = rs.getMetaData().getColumnCount();
                for(int indice=1; indice<=qtdColunas; indice ++)
                    tableMode1.addColumn(rs.getMetaData().getColumnName(indice));

                table = new JTable(tableMode1);
                DefaultTableModel dtm= (DefaultTableModel) table.getModel();

                while(rs.next()){
                    try{
                        String[] dados = new String[qtdColunas];
                        for(int i= 1; i<=qtdColunas; i++){
                            dados[i-1] =rs.getString(i);
                        }
                        dtm.addRow(dados);
                        spResultado.setViewportView(table);
                        spResultado.enableInputMethods(false);
                    }catch(Exception ef){
                        System.out.println("Erro ao montar linha!");
                    }
                }
            }catch(Exception ee){
                System.out.println("Erro ao montar tabela!--"+ee);
            }
            table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt){
             tabelaMouseClicked(evt);
         }
      });
    }
    private void tabelaMouseClicked(java.awt.event.MouseEvent evt){
        btAddCarrinho.setEnabled(true);
        btDetalhes.setEnabled(true);
      }
    
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddCarrinho;
    private javax.swing.JButton btCarrinho;
    private javax.swing.JButton btDetalhes;
    private javax.swing.JButton btPesquisar;
    private javax.swing.JComboBox cbmPesquisa;
    private javax.swing.JScrollPane spResultado;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}
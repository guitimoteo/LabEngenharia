/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package n3_livraria2;

import fatec.com.br.persistencia.AddLivroDAO;
import fatec.com.br.persistencia.Banco;
import fatec.com.br.persistencia.LivroVO;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class FormNovoLivro extends javax.swing.JFrame {
    int alter=0;
    int cod = 0;
    String codi, resp;
    int autorr = 0, titulor = 0;
    private Banco banco = new Banco("root", "", "3306","localhost", "livraria");
    private LivroVO li;
    private AddLivroDAO livroDAO = new AddLivroDAO(banco);

    /**
     *
     * Creates new form FormDetalhes
     */
    public FormNovoLivro() {

        initComponents();
        getContentPane().setBackground(Color.getHSBColor(0.650f, 0.158f, 0.750f));
        carregaComboAutor();
        carregaComboTitulo();
    }

    public FormNovoLivro(Main m) {

        initComponents();
        getContentPane().setBackground(Color.getHSBColor(0.650f, 0.158f, 0.750f));

        //codigo caique
    }

    private void carregaComboAutor() {
        cmbAutor.removeAllItems();
        cmbAutor.addItem("Selecione");
        cmbTitulo.addItem("Selecione");
        try {
            banco.abrir();
            ResultSet rs = livroDAO.carregaAutor();
            while (rs.next()) {
                cmbAutor.addItem(rs.getString("nome"));
            }
            System.out.println("carrego Autor!");
            banco.fechar();
        } catch (SQLException ex) {
            Logger.getLogger(FormNovoLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void carregaComboTitulo() {
        cmbTitulo.removeAllItems();
        cmbTitulo.addItem("Selecione");
        try {
            banco.abrir();
            ResultSet rs = livroDAO.carregaTitulo();
            while (rs.next()) {
                cmbTitulo.addItem(rs.getString("titulo"));
            }
            System.out.println("Carrego titulo!");
            banco.fechar();
        } catch (SQLException ex) {
            Logger.getLogger(FormNovoLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btRetornar = new javax.swing.JButton();
        txtEditora = new javax.swing.JTextField();
        txtFormato = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        taResumo = new javax.swing.JTextArea();
        btNovoautor = new javax.swing.JButton();
        cmbAutor = new javax.swing.JComboBox();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btNovotitulo = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtCategoria = new javax.swing.JTextField();
        txtData = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtVenda = new javax.swing.JTextField();
        txtCusto = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        taIndice = new javax.swing.JTextArea();
        btSalva = new javax.swing.JButton();
        cmbTitulo = new javax.swing.JComboBox();

        setTitle("Livraria -Detalhes-");
        setBounds(new java.awt.Rectangle(0, 0, 1000, 600));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setText("Titulo:");

        jLabel2.setText("Autor:");

        jLabel3.setText("Editora:");

        jLabel4.setText("Formato:");

        jLabel7.setText("Resumo:");

        btRetornar.setText("Retornar");
        btRetornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRetornarActionPerformed(evt);
            }
        });

        taResumo.setColumns(20);
        taResumo.setRows(5);
        jScrollPane3.setViewportView(taResumo);

        btNovoautor.setText("Novo Autor");
        btNovoautor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoautorActionPerformed(evt);
            }
        });

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btNovotitulo.setText("Novo Titulo");
        btNovotitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovotituloActionPerformed(evt);
            }
        });

        jLabel10.setText("Data Publicação:");

        jLabel11.setText("Preço Venda:");

        jLabel12.setText("Indice");

        jLabel13.setText("Preço Custo:");

        jLabel14.setText("Categoria: ");

        jLabel18.setText("(Formato AAAA/MM/DD)");

        taIndice.setColumns(20);
        taIndice.setRows(5);
        jScrollPane2.setViewportView(taIndice);

        btSalva.setText("Salvar");
        btSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtCusto, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(cmbTitulo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cmbAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btNovotitulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel16))
                            .addComponent(btNovoautor))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFormato, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtEditora, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(41, 41, 41)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCategoria)
                                .addGap(81, 81, 81))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(241, 241, 241)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btAlterar, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                                        .addComponent(btRetornar, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                                        .addComponent(btSalva, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(84, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btNovotitulo)
                        .addComponent(jLabel16)
                        .addComponent(cmbTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btNovoautor))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEditora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFormato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel18)
                        .addComponent(jLabel14)
                        .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtCusto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btSalva)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btRetornar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))))
                .addGap(23, 23, 23))
        );

        setSize(new java.awt.Dimension(1000, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void btRetornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRetornarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btRetornarActionPerformed


    private void btNovoautorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoautorActionPerformed
        livroDAO.novoAutor();
        carregaComboAutor();
    }//GEN-LAST:event_btNovoautorActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        cod = Integer.parseInt(JOptionPane.showInputDialog("Insira o código do livro:"));
        alter=1;
        try {
            li=livroDAO.pesquisar(cod);
            cmbTitulo.setSelectedIndex(li.getCodtitulo());
            cmbAutor.setSelectedIndex(li.getCodautor());
            txtEditora.setText(li.getEditora());
            txtFormato.setText(li.getFormato());
            txtData.setText(li.getDataPublicacao());
            txtCategoria.setText(li.getCategoria());
            txtVenda.setText(String.valueOf(li.getPrecoVenda()));
            txtCusto.setText(String.valueOf(li.getPrecoCusto()));
            taResumo.setText(li.getResumo());
            taIndice.setText(li.getIndice());
            
        } catch (SQLException ex) {
            Logger.getLogger(FormNovoLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        cod = Integer.parseInt(JOptionPane.showInputDialog("Insira o código do livro:"));
        int resp;
        resp = JOptionPane.showConfirmDialog(rootPane,
                "Deseja excluir o livro de codigo?"+cod, "Mensagem ao Usuário",JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (resp == 0) { //confirmou 
            li = new LivroVO(cod);
            try {
                if (livroDAO.excluir(li)) {
                    JOptionPane.showMessageDialog(rootPane,
                            "Dados Excluidos com Sucesso", "Mensagem ao Usuário",JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(rootPane,"Erro ao excluir!","Mensagem ao Usuário", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, ex.getMessage(),"Mensagem ao Usuário",JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btNovotituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovotituloActionPerformed
        livroDAO.novoTitulo();
        carregaComboTitulo();
    }//GEN-LAST:event_btNovotituloActionPerformed
    private void limpaCampo(){
        cmbTitulo.setSelectedIndex(0);
        cmbAutor.setSelectedIndex(0);
        txtEditora.setText("");
        txtFormato.setText("");
        txtData.setText("");
        txtCategoria.setText("");
        txtVenda.setText("");
        txtCusto.setText("");
        taResumo.setText("");
        taIndice.setText("");
    }
    private void btSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvaActionPerformed
        // TODO add your handling code here:
        li = new LivroVO();
        li.setCod(cod);
        li.setCodtitulo(cmbTitulo.getSelectedIndex());
        li.setCodautor(cmbAutor.getSelectedIndex());
        li.setEditora(txtEditora.getText());
        li.setFormato(txtFormato.getText());
        li.setDataPublicacao(txtData.getText());
        li.setCategoria(txtCategoria.getText());
        li.setPrecoVenda(Double.parseDouble(txtVenda.getText()));
        li.setPrecoCusto(Double.parseDouble(txtCusto.getText()));
        li.setResumo(taResumo.getText());
        li.setIndice(taIndice.getText());
        try {
            if(alter==1)
                livroDAO.alterar(li);
            else
                livroDAO.inserir(li);
            alter=0;
            limpaCampo();
            JOptionPane.showMessageDialog(rootPane,"Salvo com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(FormNovoLivro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btSalvaActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btNovoautor;
    private javax.swing.JButton btNovotitulo;
    private javax.swing.JButton btRetornar;
    private javax.swing.JButton btSalva;
    private javax.swing.JComboBox cmbAutor;
    private javax.swing.JComboBox cmbTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea taIndice;
    private javax.swing.JTextArea taResumo;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtCusto;
    private javax.swing.JTextField txtData;
    private javax.swing.JTextField txtEditora;
    private javax.swing.JTextField txtFormato;
    private javax.swing.JTextField txtVenda;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package n3_livraria2;

import fatec.com.br.persistencia.Banco;
import fatec.com.br.persistencia.ClienteDAO;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author David
 */
public class FormCadastro extends javax.swing.JFrame {
    Main main;
    private Banco banco = new Banco("root","","3306", "localhost","livraria");
    private Cliente cli;
    private ClienteDAO cliDAO = new ClienteDAO(banco);
    private int altera=0, exclui=0;
    /**
     * Creates new form FormCadastro
     */
    public FormCadastro(Main m) {
        main=m;
        initComponents();
        getContentPane().setBackground(Color.getHSBColor(0.650f,0.158f,0.750f));
    }
    
     public void FormAlterar(){
        jButton1.setEnabled(false);
        btnExcluir.setEnabled(false);
    }
    
    public void FormCadastrar(){
        jButton1.setEnabled(true);
        btnExcluir.setEnabled(true);
        altera=0;
        exclui=0;
    }
    
    public void carregar(Cliente c){
        cli=c;
        txtNome.setText(cli.getNome());
        txtNascimento.setText(cli.getNascimento());
        txtCPF.setText(cli.getCpf());
        txtEndereco.setText(cli.getEndereco());
        txtUsuario.setText(cli.getLogin());
        psSenha.setText(cli.getSenha());
        FormAlterar();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtNascimento = new javax.swing.JTextField();
        txtCPF = new javax.swing.JTextField();
        txtEndereco = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        psSenha = new javax.swing.JPasswordField();
        btnAlterar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Livraria -Cadastro-");
        setBounds(new java.awt.Rectangle(0, 0, 460, 200));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setText("Nome:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 14, 70, 14);

        jLabel2.setText("Data Nascimento:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 45, 110, 14);

        jLabel3.setText("CPF:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 74, 70, 14);

        jLabel4.setText("Endereço:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 100, 90, 14);

        jLabel5.setText("Usuario:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 130, 80, 14);

        jLabel6.setText("Senha:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 160, 80, 14);

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });
        getContentPane().add(txtNome);
        txtNome.setBounds(130, 10, 134, 20);
        getContentPane().add(txtNascimento);
        txtNascimento.setBounds(130, 40, 102, 20);
        getContentPane().add(txtCPF);
        txtCPF.setBounds(130, 70, 102, 20);
        getContentPane().add(txtEndereco);
        txtEndereco.setBounds(130, 100, 178, 20);

        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(txtUsuario);
        txtUsuario.setBounds(130, 130, 121, 20);

        jButton1.setText("Concluir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 210, 90, 30);

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(350, 210, 90, 30);
        getContentPane().add(psSenha);
        psSenha.setBounds(130, 160, 120, 20);

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAlterar);
        btnAlterar.setBounds(130, 210, 90, 30);

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir);
        btnExcluir.setBounds(240, 210, 90, 30);

        jLabel7.setText("(Formato AAAA/MM/DD)");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(240, 40, 140, 14);

        setSize(new java.awt.Dimension(457, 292));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        limpaCampos();
        FormCadastrar();
        altera=0;
        exclui=0;
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        main.getLogin().setVisible(true);
        limpaCampos();
    }//GEN-LAST:event_formWindowClosing

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(txtNome.getText().length() ==0 || txtCPF.getText().length() ==0 || txtEndereco.getText().length() ==0 || txtUsuario.getText().length() ==0 || psSenha.getText().length() ==0){
            JOptionPane.showMessageDialog(null,"Preencha todos os campos para realizar o cadastro!");
        }
        else{
            cli = new Cliente();
            cli.setNome(txtNome.getText());
            cli.setNascimento(txtNascimento.getText());
            cli.setCpf(txtCPF.getText());
            cli.setEndereco(txtEndereco.getText());
            cli.setLogin(txtUsuario.getText());
            cli.setSenha(psSenha.getText());
            try{
       
                 if(cliDAO.inserir(cli) == true){
                    JOptionPane.showMessageDialog(rootPane, "Cadastro realizado com sucesso!", "Mensagem ao Usuario", JOptionPane.INFORMATION_MESSAGE);
                    limpaCampos();
                    this.setVisible(false);
                    main.getLogin().setVisible(true);
                 }
                 
                 else
                     JOptionPane.showMessageDialog(rootPane, "Usuario já existe!", "Mensagem ao Usuario", JOptionPane.ERROR_MESSAGE);
                 } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "Mensagem ao Usuario", JOptionPane.ERROR_MESSAGE);
      
                  }
            
            
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        if (altera == 0){
        main.getLogin().setVisible(true);
        altera = 1;
        }
        else{
        try {
            FormAlterar();
            cli = new Cliente();
            cli.setNome(txtNome.getText());
            cli.setNascimento(txtNascimento.getText());
            cli.setCpf(txtCPF.getText());
            cli.setEndereco(txtEndereco.getText());
            cli.setLogin(txtUsuario.getText());
            cli.setSenha(psSenha.getText());
            if(cliDAO.alterar(cli)){
                JOptionPane.showMessageDialog(rootPane, "Alteração realizada com sucesso!", "Mensagem ao Usuario", JOptionPane.INFORMATION_MESSAGE);
                limpaCampos();
                FormCadastrar();
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormCadastro.class.getName()).log(Level.SEVERE, null, ex);
        }
        altera=0;
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (exclui == 0){
        main.getLogin().setVisible(true);
        exclui = 1;
        }
    }//GEN-LAST:event_btnExcluirActionPerformed
    private void limpaCampos(){
        txtNome.setText(null);
        txtNascimento.setText(null);
        txtCPF.setText(null);
        txtEndereco.setText(null);
        txtUsuario.setText(null);
        psSenha.setText(null);
    }
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField psSenha;
    private javax.swing.JTextField txtCPF;
    private javax.swing.JTextField txtEndereco;
    private javax.swing.JTextField txtNascimento;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the altera
     */
    public int getAltera() {
        return altera;
    }

    /**
     * @param altera the altera to set
     */
    public void setAltera(int altera) {
        this.altera = altera;
    }

    /**
     * @return the exclui
     */
    public int getExclui() {
        return exclui;
    }

    /**
     * @param exclui the exclui to set
     */
    public void setExclui(int exclui) {
        this.exclui = exclui;
    }
}

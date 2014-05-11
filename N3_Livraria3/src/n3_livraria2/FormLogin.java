/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package n3_livraria2;

import fatec.com.br.persistencia.Banco;
import fatec.com.br.persistencia.ClienteDAO;
import fatec.com.br.persistencia.PedidoDAO;
import fatec.com.br.persistencia.PedidoVO;
import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class FormLogin extends javax.swing.JFrame {
    Main main;
    String usuario;
    private Cliente cli;
    private ClienteDAO cliDAO;
    int cod;
    int codp;
    Item item;
    private Banco banco = new Banco("root","","3306", "localhost","livraria");
    /**
     * Creates new form FormLogin
     */
    public FormLogin(Main m) {
        initComponents();
        main=m;
        getContentPane().setBackground(Color.getHSBColor(0.650f,0.158f,0.750f));
    }

    private void limpar(){
        txtUsuario.setText(null);
        psSenha.setText(null);
    }
    
    private boolean validarDados(){
        if(txtUsuario.getText().length() ==0 || psSenha.getText().length() ==0){
            return false;
        }
        else
            return true;
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
        btLogin = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        txtUsuario = new javax.swing.JTextField();
        psSenha = new javax.swing.JPasswordField();
        btNovo = new javax.swing.JButton();

        setTitle("Livraria - Login-");
        setBounds(new java.awt.Rectangle(0, 0, 300, 250));
        setPreferredSize(new java.awt.Dimension(300, 300));
        setResizable(false);

        jLabel1.setText("Usuario:");

        jLabel2.setText("Senha:");

        btLogin.setText("Login");
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btNovo.setText("Novo");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(psSenha, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                            .addComponent(txtUsuario)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btNovo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 20, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(psSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btLogin)
                    .addComponent(btNovo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(309, 267));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
        limpar();
        main.getCadastro().FormCadastrar();
        this.setVisible(false);
        
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        // TODO add your handling code here:
        main.getCadastro().setVisible(true);
        main.getCadastro().FormCadastrar();
        
    }//GEN-LAST:event_btNovoActionPerformed

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoginActionPerformed
        // TODO add your handling code here:
        if(!validarDados()){
            JOptionPane.showMessageDialog(rootPane, "Favor preencher todos os campos", "Mensagem ao Usuario", JOptionPane.INFORMATION_MESSAGE);
             return;
        }
        try{
            cliDAO = new ClienteDAO(banco);
            
            if(cliDAO.pesquisarNomeSenha(psSenha.getText(),txtUsuario.getText()) == null){
                JOptionPane.showMessageDialog(null,"Verifique usuario e senha e tente novamente!");
            }
            else{
                if (main.getCadastro().getAltera() == 1){
                     cli = cliDAO.pesquisarNomeSenha(psSenha.getText(),txtUsuario.getText());
                     main.getCadastro().carregar(cli);
                     limpar();
                     this.setVisible(false);
                }
                else{
                    if(main.getCadastro().getExclui() == 1){
                         cli = cliDAO.pesquisarNomeSenha(psSenha.getText(),txtUsuario.getText());
                         if(cliDAO.excluir(cli)){
                             JOptionPane.showMessageDialog(null,"Cliente excluido com sucesso!");
                             main.getCadastro().setExclui(0);
                             this.setVisible(false);
                         }
                         else
                             JOptionPane.showMessageDialog(null,"Erro ao excluir");       
                    }
                    else{
                    PedidoVO pf = new PedidoVO();
                    PedidoDAO pedidoDAO = new PedidoDAO(banco);
                    cod = cliDAO.pesquisarCodigo(psSenha.getText(), txtUsuario.getText());
                    codp = pedidoDAO.proximoCodigoPedido();
                    System.out.println("aqui1");
                    try{
                        int y=0;
                        for(Object x: main.getItens().itens){
                            System.out.println(y);
                            y++;
                            banco.abrir();
                            pf.setCodCliente(cod);
                            pf.setCodPedido(codp);
                            String[] a=(String[])x;
                            pf.setCodLivro(Integer.parseInt(a[0]));
                            pf.setQtd(Integer.parseInt(a[2]));
                            pedidoDAO.inserir(pf);
                            banco.fechar();
                    }
                    JOptionPane.showMessageDialog(null,"Compra finalizada!\n Adeus!");
                    System.exit(0);
                }catch(Exception ex){
                    System.out.println(ex);
                }
                }
                }
            }
        }catch(Exception ee){
           System.out.println(ee);
           JOptionPane.showMessageDialog(null,"Verifique sua senha e tente novamente!");
        }

    }//GEN-LAST:event_btLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btLogin;
    private javax.swing.JButton btNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField psSenha;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package n3_livraria2;

/**
 *
 * @author david
 */
public class Main {
    private  FormPesquisa pesquisa;
    private  FormCarrinho carrinho;
    private  FormDetalhes detalhes;
    private  FormLogin login;
    private  ItemPedido itens;
    private FormCadastro cadastro;
    private FormPrincipal principal;
    private FormHistorico historico;
    FormAvancado adm = new FormAvancado();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Construtora construtora = new Construtora();
        construtora.getPrincipal().setVisible(true);
    }
    
//Getters and Setters
    public  FormDetalhes getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(FormDetalhes aDetalhes) {
        detalhes = aDetalhes;
    }

    public FormPesquisa getPesquisa() {
        return pesquisa;
    }

    public FormCarrinho getCarrinho() {
        return carrinho;
    }

    public void setPesquisa(FormPesquisa pesquisa) {
        this.pesquisa = pesquisa;
    }

    public void setCarrinho(FormCarrinho carrinho) {
        this.carrinho = carrinho;
    }

    public FormLogin getLogin() {
        return login;
    }

    public void setLogin(FormLogin login) {
        this.login = login;
    }
    public ItemPedido getItens() {
        return itens;
    }

    public void setItens(ItemPedido itens) {
        this.itens = itens;
    }

    /**
     * @return the cadastro
     */
    public FormCadastro getCadastro() {
        return cadastro;
    }

    /**
     * @param cadastro the cadastro to set
     */
    public void setCadastro(FormCadastro cadastro) {
        this.cadastro = cadastro;
    }

    public FormPrincipal getPrincipal() {
        return principal;
    }

    public void setPrincipal(FormPrincipal principal) {
        this.principal = principal;
    }

    public FormHistorico getHistorico() {
        return historico;
    }

    public void setHistorico(FormHistorico historico) {
        this.historico = historico;
    }
}

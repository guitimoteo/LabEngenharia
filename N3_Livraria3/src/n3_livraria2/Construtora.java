/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package n3_livraria2;

/**
 *
 * @author david
 */
public class Construtora {
    private  Main main = new Main();
    private FormPesquisa pesquisa = new FormPesquisa(main);
    private FormCarrinho carrinho = new FormCarrinho(main);
    private FormDetalhes detalhes = new FormDetalhes(main);
    private FormLogin login = new FormLogin(main);
    private FormCadastro cadastro = new FormCadastro(main);
    private FormPrincipal principal = new FormPrincipal(main);
    private FormHistorico historico = new FormHistorico(main);
    private ItemPedido itens= new ItemPedido();
    public Construtora(){
        main.setHistorico(historico);
        main.setCarrinho(carrinho);
        main.setDetalhes(detalhes);
        main.setPesquisa(pesquisa);
        main.setLogin(login);
        main.setItens(itens);
        main.setCadastro(cadastro);
        main.setPrincipal(principal);
    }

    public FormPesquisa getPesquisa() {
        return pesquisa;
    }

    public FormCarrinho getCarrinho() {
        return carrinho;
    }

    public FormDetalhes getDetalhes() {
        return detalhes;
    }

    public Main getMain() {
        return main;
    }

    public void setPesquisa(FormPesquisa pesquisa) {
        this.pesquisa = pesquisa;
    }

    public void setCarrinho(FormCarrinho carrinho) {
        this.carrinho = carrinho;
    }

    public void setDetalhes(FormDetalhes detalhes) {
        this.detalhes = detalhes;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public FormPrincipal getPrincipal() {
        return principal;
    }

    public void setPrincipal(FormPrincipal principal) {
        this.principal = principal;
    }
}

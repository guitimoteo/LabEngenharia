/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.com.br.persistencia;

/**
 *
 * @author Caique
 */
public class LivroVO {
    private double precoCusto;
    private double precoVenda;
    private String isbn;    
    private String dataPublicacao;
    private String editora;
    private String resumo;
    private String indice;
    private String formato;
    private String categoria;
    private int codautor;
    private int codtitulo;
    private int cod;

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(String dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getIndice() {
        return indice;
    }

    public void setIndice(String indice) {
        this.indice = indice;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getCodautor() {
        return codautor;
    }

    public void setCodautor(int codautor) {
        this.codautor = codautor;
    }

    public int getCodtitulo() {
        return codtitulo;
    }

    public void setCodtitulo(int codtitulo) {
        this.codtitulo = codtitulo;
    }

    public LivroVO(int codtitulo) {
        this.codtitulo = codtitulo;
    }
    public LivroVO(){
        
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
}

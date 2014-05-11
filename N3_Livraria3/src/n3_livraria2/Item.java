/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package n3_livraria2;

/**
 *
 * @author david
 */
public class Item {
    private int codigo;
    private int qtd;
    public Item(int cod,int qtd){
        this.codigo=cod;
        this.qtd=qtd;
    }
    public int getCodigo() {
        return codigo;
    }

    public int getQtd() {
        return qtd;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}

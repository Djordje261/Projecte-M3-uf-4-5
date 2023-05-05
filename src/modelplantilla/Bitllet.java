package modelplantilla;

public class Bitllet {
    private int valor; // 100 euros
    private int quantitat; // 10 bitllets de 100

    public Bitllet(int valor, int quantitat) {
        this.valor = valor;
        this.quantitat = quantitat;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getQuantitat() {
        return quantitat;
    }

    public void setQuantitat(int quantitat) {
        this.quantitat = quantitat;
    }
      
    
}

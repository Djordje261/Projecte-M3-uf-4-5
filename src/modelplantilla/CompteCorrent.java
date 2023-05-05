package modelplantilla;

public class CompteCorrent {
    
    private int numero;
    private double saldo;
    
    static private int comptador = 1;
    static private final String patro = "ES1001011";

    public CompteCorrent(double saldo) {
        this.numero = comptador;
        comptador++;
        this.saldo = saldo;
    }

    public String getNumero() {
        return patro + numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void ingressar(double quantitat) {
        this.saldo = this.saldo + quantitat;
    }
    
    public boolean extreure(double quantitat) {
        if(quantitat<=this.saldo) {
            this.saldo = this.saldo - quantitat;
            return true;
        }
        return false;
    }
    
    
}

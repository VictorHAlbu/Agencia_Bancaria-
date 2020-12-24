package ContaBanco;

public abstract class Conta implements C1, C2 {
    protected String numero;
    protected double saldo;
    
    public Conta(String numero){
        this.numero = numero;
    }
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void deposito(double valor){
        saldo = saldo + valor;
    }    
    
}

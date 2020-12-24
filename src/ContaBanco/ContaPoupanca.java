package ContaBanco;

public class ContaPoupanca extends ContaCorrente {
	
private double rendimento;
    
    public ContaPoupanca(String numero){
        super(numero);
        rendimento = 0.05;
    }
    
    @Override
    public boolean debita(double valor){
        if (valor <= saldo){
            saldo = saldo - valor;
            return true;
        } else {
           return false; 
        }
    }
    
    @Override
    public String extrato(){
        return "A conta poupança: "+numero+" possui saldo: "+saldo+" taxa de rendimento: "+rendimento;
    }
}

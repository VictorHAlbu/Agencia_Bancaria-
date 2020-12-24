package ContaBanco;

public class ContaCorrente extends Conta {    
    
    public ContaCorrente(String numero){
        super(numero);
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
        return "A conta corrente: "+numero+" possui saldo: "+saldo;
    }
    
}

 
	


package ContaBanco;

public class ContaEspecial extends ContaCorrente{
	 private double limite;

	    public ContaEspecial(String numero) {
	        super(numero);
	        limite = 1000;
	    }

	    public ContaEspecial(String numero, double valorLimite) {
	        super(numero);
	        limite = valorLimite;
	    }

	    @Override
	    public boolean debita(double valor) {
	    while (valor <= saldo + limite){
	            if(valor <= saldo){
	                saldo = saldo - valor;
	                return true;
	            } else {
	                saldo = saldo - valor;
	                limite = limite + saldo;
	                saldo = 0;
	                return true;
	            }
	        }
	        return false;
	    }

	    @Override
	    public String extrato() {
	        return "A conta especial: " + getNumero() + " possui saldo: " + getSaldo() + " e limite: " + limite;
	    }
}
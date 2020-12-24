package ContaBanco;
import java.util.ArrayList;
import java.util.Iterator;

public class Agencia {

	    private String numero;
	    private ArrayList contas;

	    public Agencia(String numero) {
	        this.numero = numero;
	        contas = new ArrayList();
	    }

	    public boolean incluiConta(Conta conta) {
	        contas.add(conta);
	        return true;
	    }

	    public boolean comparaContas(String numConta) {
	        Iterator i = contas.iterator();
	        while (i.hasNext()) {
	            Conta c = (Conta) i.next();
	            if (c.getNumero().equals(numConta)) {
	                return false;
	            }
	        }
	        return true;
	    }

=	    public boolean deposito(String numConta, double valor) throws ContaInvalida {
	        int pos = localizaConta(numConta);
	        if (pos >= 0) {
	            Conta c = (Conta)contas.get(pos);
	            c.deposito(valor);
	            return true;
	        }
	        return false;
	    }

	    public boolean saque(String numConta, double valor) {
	        int pos = localizaConta(numConta);
	        if (pos >= 0) {
	            Conta c = (Conta)contas.get(pos);
	            if (c.debita(valor)) {
	                return true;
	            }
	        }
	        return false;
	    }

	    public boolean transfere(String numOrigem, String numDestino, double valor) {
	        int posOrigem = localizaConta(numOrigem);
	        int posDestino = localizaConta(numDestino);
	        if ((posOrigem >= 0) && (posDestino >= 0)) {
	            Conta o = (Conta)contas.get(posOrigem);
	            Conta d = (Conta)contas.get(posDestino);
	            if (o.debita(valor)) {
	                d.deposito(valor);
	                return true;
	            } else {
	                return false;
	            }
	        }
	        return false;
	    }

	    public boolean excluiConta(String numConta) {
	        Iterator i = contas.iterator();
	        int pos = localizaConta(numConta);
	        if (pos >= 0) {
	             //Conta c = (Conta)contas.get(pos);
	             contas.remove((Conta)contas.get(pos));
	             return true;
	        }
	        return false;
	    }
	    
	    private int localizaConta(String numConta) {
	        Iterator i = contas.iterator();
	        int retorno = -1;
	        while (i.hasNext()) {
	            Conta c = (Conta) i.next();
	            if (c.getNumero().equals(numConta)) {
	                retorno = contas.indexOf(c);
	            }
	        }
	        return retorno;
	    }

	    public String listaContas() {
	        String lista = "";
	        Iterator i = contas.iterator();
	        while (i.hasNext()) {
	            Conta c = (Conta) i.next();
	            lista = lista + c.extrato() + "\n";
	        }
	        return lista;
	    }

	
	
}



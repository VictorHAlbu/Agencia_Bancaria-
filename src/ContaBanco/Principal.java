package ContaBanco;

import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {
		 Agencia agencia1 = new Agencia("0639");
	        Conta c;
	        String numeroConta, numeroConta2;
	        double valor;
	        int opcao = 0;
	        while (opcao != 10) {
	            opcao = menu();
	            switch (opcao) {
	                case 1:                    
	                    numeroConta = JOptionPane.showInputDialog("Digite o numero da Conta");
	                    if (agencia1.comparaContas(numeroConta)) {
	                        c = new ContaCorrente(numeroConta);
	                        if (agencia1.incluiConta(c)) {
	                            JOptionPane.showMessageDialog(null, "Conta criada com sucesso!");
	                        } else {
	                            JOptionPane.showMessageDialog(null, "Conta não incluída!", "Erro", JOptionPane.ERROR_MESSAGE);
	                        }
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Já existe uma conta com esse numero", "Erro", JOptionPane.ERROR_MESSAGE);
	                    }                    
	                    break;
	                case 2:
	                    numeroConta = JOptionPane.showInputDialog("Digite o numero da Conta Poupança");
	                    if (agencia1.comparaContas(numeroConta)) {
	                        c = new ContaPoupanca(numeroConta);
	                        if (agencia1.incluiConta(c)) {
	                            JOptionPane.showMessageDialog(null, "Conta criada com sucesso!");
	                        } else {
	                            JOptionPane.showMessageDialog(null, "Conta não incluída!", "Erro", JOptionPane.ERROR_MESSAGE);
	                        }
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Já existe uma conta com esse numero", "Erro", JOptionPane.ERROR_MESSAGE);
	                    }
	                    break;
	                case 3:
	                    numeroConta = JOptionPane.showInputDialog("Digite o numero da Conta Especial");
	                    if (agencia1.comparaContas(numeroConta)) {
	                        c = new ContaEspecial(numeroConta);
	                        if (agencia1.incluiConta(c)) {
	                            JOptionPane.showMessageDialog(null, "Conta criada com sucesso!");
	                        } else {
	                            JOptionPane.showMessageDialog(null, "Conta não incluída!", "Erro", JOptionPane.ERROR_MESSAGE);
	                        }
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Já existe uma conta com esse numero", "Erro", JOptionPane.ERROR_MESSAGE);
	                    }
	                    break;
	                case 4:
	                    numeroConta = JOptionPane.showInputDialog("Digite o numero da Conta Especial");
	                    valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do limite"));
	                    if (agencia1.comparaContas(numeroConta)) {
	                        c = new ContaEspecial(numeroConta, valor);
	                        if (agencia1.incluiConta(c)) {
	                            JOptionPane.showMessageDialog(null, "Conta criada com sucesso!");
	                        } else {
	                            JOptionPane.showMessageDialog(null, "Conta não incluída!", "Erro", JOptionPane.ERROR_MESSAGE);
	                        }
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Já existe uma conta com esse numero", "Erro", JOptionPane.ERROR_MESSAGE);
	                    }
	                    break;
	                case 5:
	                    JOptionPane.showMessageDialog(null, agencia1.listaContas(), "Lista de Contas", JOptionPane.INFORMATION_MESSAGE);
	                    break;
	                case 6:
	                    numeroConta = JOptionPane.showInputDialog("Digite o numero da Conta para depósito");
	                    try {
	                        valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor para depósito"));
	                        try {
	                            if (agencia1.deposito(numeroConta, valor)) {
	                                JOptionPane.showMessageDialog(null, "Depósito efetuado com sucesso!");
	                            } 
	                        } catch (ContaInvalida e) {
	                            JOptionPane.showMessageDialog(null, "Conta inexistente!", "Erro", JOptionPane.ERROR_MESSAGE);
	                        }
	                    } catch (NumberFormatException e) {
	                        JOptionPane.showMessageDialog(null, "Digite um valor numérico!", "Erro", JOptionPane.ERROR_MESSAGE);
	                    }
	                    break;
	                case 7:
	                    numeroConta = JOptionPane.showInputDialog("Digite o numero da Conta para saque");
	                    valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor para saque"));
	                    if (agencia1.saque(numeroConta, valor)) {
	                        JOptionPane.showMessageDialog(null, "Saque efetuado com sucesso!");
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Saque não efetuado!");
	                    }
	                    break;
	                case 8:
	                    numeroConta = JOptionPane.showInputDialog("Digite o numero da Conta de origem");
	                    numeroConta2 = JOptionPane.showInputDialog("Digite o numero da Conta destino");
	                    valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor para tranferência"));
	                    if (agencia1.transfere(numeroConta, numeroConta2, valor)) {
	                        JOptionPane.showMessageDialog(null, "Transferência efetuada com sucesso!");
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Transferência não efetuada!");
	                    }
	                    break;
	                case 9:
	                    numeroConta = JOptionPane.showInputDialog("Digite o numero da Conta");
	                    if (agencia1.excluiConta(numeroConta)) {
	                        JOptionPane.showMessageDialog(null, "Conta excluída com sucesso!");
	                    } else {
	                        JOptionPane.showMessageDialog(null, "Conta não existe!", "Erro", JOptionPane.ERROR_MESSAGE);
	                    }
	                    break;
	                case 10:
	                    System.exit(0);
	            }
	        }
	    }

	    private static int menu() {

	        String textoMenu = "1 - Incluir Conta Corrente \n"
	                + "2 - Incluir Conta Poupança \n"
	                + "3 - Incluir Conta Especial \n"
	                + "4 - Incluir Conta Especial com Limite \n"
	                + "5 - Listar Contas \n"
	                + "6 - Depósito \n"
	                + "7 - Saque \n"
	                + "8 - Transferência \n"
	                + "9 - Excluir Conta \n"
	                + "10 - Sair";
	        int opcao = 0;
	        try {
	            opcao = Integer.parseInt(JOptionPane.showInputDialog(null, textoMenu, "Menu Principal", JOptionPane.QUESTION_MESSAGE));

	        } catch (NumberFormatException e) {
	            JOptionPane.showMessageDialog(null, "Digite um valor numérico!", "Erro", JOptionPane.ERROR_MESSAGE);
	        }
	        return opcao;

	    }

	}

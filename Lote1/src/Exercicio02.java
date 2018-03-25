/*
╔══════════════════════════════════════════════════════════════╗
║  														       ║	
║  		Programador: James Wander Ferreira de Souza Junior     ║
║  												               ║
║  		Data: 24/08/2017									   ║
║  															   ║
║  		Objetivo: Receba o salário de um funcionário e 		   ║
║		mostre o novo salário com reajuste de 15%.	           ║
║                                                              ║  
║															   ║
╚══════════════════════════════════════════════════════════════╝
*/
import javax.swing.JOptionPane;

public class Exercicio02 {

	public static void main(String[] args) {
		
		double Salario, SalarioNovo;
		
		Salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o Salario"));
		
		SalarioNovo = Salario + (Salario*0.15);
		
		JOptionPane.showMessageDialog(null, "O Salario com reajuste é: "+SalarioNovo);
		
	}
	
}

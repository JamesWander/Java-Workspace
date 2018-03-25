/*
╔══════════════════════════════════════════════════════════════╗
║  														       ║	
║  		Programador: James Wander Ferreira de Souza Junior     ║
║  												               ║
║  		Data: 24/08/2017									   ║
║  															   ║
║  		Objetivo: Receba a base e a altura de um triângulo.    ║
║		Calcule e mostre a sua área. 		   				   ║
║													           ║
║                                                              ║  
║															   ║
╚══════════════════════════════════════════════════════════════╝
 */

import javax.swing.JOptionPane;
public class Exercicio12 {

	public static void main(String[] args) {
		
		int AA,AN,ID,ID17;
		
		AN = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano de nascimento"));
		AA = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano atual"));
		ID = AA - AN;
		ID17 = ID + 17;
		
		JOptionPane.showMessageDialog(null,"Idade atual é: "+ID+"\nIdade daqui a 17 anos é: "+ID17);
		

	}

}

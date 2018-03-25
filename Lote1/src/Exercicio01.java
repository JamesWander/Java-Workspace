/*
╔══════════════════════════════════════════════════════════════╗
║  														       ║	
║  		Programador: James Wander Ferreira de Souza Junior     ║
║  												               ║
║  		Data: 24/08/2017									   ║
║  															   ║
║  		Objetivo: Coletar o valor do lado de um quadrado,      ║
║  		calcular sua área e apresentar o resultado.	           ║
║                                                              ║  
║															   ║
╚══════════════════════════════════════════════════════════════╝
  */

import javax.swing.JOptionPane;

public class Exercicio01 {

	public static void main(String[] args) {
		
		int largura,altura;
		float area;
		
		largura = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a largura"));
		altura = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite a altura"));

		area = altura*largura;
		
		JOptionPane.showMessageDialog(null, "A area é " + area);
		
	}

}

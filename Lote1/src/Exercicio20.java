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

/*
 20. Receba 3 coeficientes A, B, e C de uma equação do 2º grau da fórmula
AX²+BX+C=0. Verifique e mostre a existência de raízes reais e se caso
exista, calcule e mostre.
 */
public class Exercicio20 {

	
	static void segundograu(int a, int b, int c)
	{
		
		double x1,x2,delta;
		
		
		delta = Math.pow(b,2)-(4*a*c);
		
		x1 = (-b + Math.sqrt(delta))/2*a;
		x2 = (-b - Math.sqrt(delta))/2*a;
		
		JOptionPane.showMessageDialog(null, "x1 = "+x1+"\nx2 = "+x2);
		
		
		
	}
	
	public static void main(String[] args) {
		
		int a,b,c;
		
		
		a = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor de A"));
		b = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor de B"));
		c = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor de C"));
		
		segundograu(a,b,c);

	}

}

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

/*18. Receba 2 valores inteiros. Calcule e mostre o resultado da diferença do
maior pelo menos valor.
*/
public class Exercicio18 {

	static void diferenca(int V1, int V2)
	{
	   int DF;
	   
	   if(V1>V2)
	   {
	      DF=V1-V2; 
	   }
	   else
	   {
	       DF=V2-V1;
	   }
	   JOptionPane.showMessageDialog(null, "diferença é: "+DF);
	    
	}
	
	public static void main(String[] args) {
		
		int n1,n2;
		
		n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor de N1"));
		n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o valor de N2"));
		
		diferenca(n1,n2);

	}

}

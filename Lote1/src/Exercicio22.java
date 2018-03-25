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
 22. Receba 2 valores inteiros e diferentes. Mostre seus valores em ordem
crescente.
 */
public class Exercicio22 {

	
	static void comparar(int N1, int N2)
	{
	    
	   if(N1<N2)
	   {
	       JOptionPane.showMessageDialog(null, N1+" "+N2);
	   }
	   else
	   {
		   JOptionPane.showMessageDialog(null, N2+" "+N1);
	   }
	   
	}
	
	
	public static void main(String[] args) {
		
		int n1,n2;
		
		n1 = Integer.parseInt(JOptionPane.showInputDialog("Digite a N1"));
		n2 = Integer.parseInt(JOptionPane.showInputDialog("Digite a N2"));
		
		comparar(n1,n2);

	}

}

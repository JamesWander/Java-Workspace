import javax.swing.JOptionPane;

/*
 37. Receba um número inteiro. Calcule e mostre a série de Fibonacci até o seu
N’nésimo termo
 */
public class Exercicio37 {

	public static void main(String[] args) {
		
		   int anterior,i,numero,sequencia;
		   String fibonaci = "";
		   
		   
	       numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero"));
	      
	       anterior = 0;
	       
	       sequencia = 1;
	       for(i = 1;i<=numero; i++)
	       {
	           fibonaci += sequencia + " ";
	           sequencia = sequencia + anterior;
	           anterior = sequencia - anterior; 
	           
	       }
		JOptionPane.showMessageDialog(null, fibonaci);
	}

}

import javax.swing.JOptionPane;

/*
 26. Receba 2 n�meros inteiros. Verifique e mostre se o maior n�mero � m�ltiplo
do menor.
 */
public class Exercicio26 {

	static void multiploMenor(int N1, int N2)
	{
	   if(N1>N2)
	   {
	       if(N1%N2 == 0)
	       {
	           JOptionPane.showMessageDialog(null,"O Maior numero � multiplo do menor");
	       }
	       else
	       {
	    	   JOptionPane.showMessageDialog(null,"O Maior numero nao � multiplo do menor");
	       }
	   }
	   else
	   {
	       if(N2%N1 == 0)
	       {
	    	   JOptionPane.showMessageDialog(null,"O Maior numero � multiplo do menor");
	       }
	       else
	       {
	    	   JOptionPane.showMessageDialog(null,"O Maior numero nao � multiplo do menor");
	       }
	   }
	}
	
	
	public static void main(String[] args) {
		
		int N1, N2;
		
		N1 = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero"));
		N2 = Integer.parseInt(JOptionPane.showInputDialog("Digite outro numero"));
		
		multiploMenor(N1,N2);
	}

}

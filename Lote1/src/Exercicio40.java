import javax.swing.JOptionPane;

/*
 40. Receba 2 números inteiros. Verifique e mostre todos os números primos
existentes entre eles.
 */

public class Exercicio40 {

	static boolean primo(int numero)
	{
	    int teste = 0;
	    for (int i = 1;i<=numero; i++) 
	    {
	        if (numero % i == 0) 
	        { 
	            teste++;
	        }
	    }
	    if(teste == 2)
	    {
	        return true;
	    }
	    else
	    {
	        return false;
	    }
	}
	
	public static void main(String[] args) {
		
		int N1,N2;

		N1 = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero"));
		N2 = Integer.parseInt(JOptionPane.showInputDialog("Digite outro numero"));
		
		
	     for(int i = N1;i<=N2; i++)
	     {
	          if(primo(i) == true)
	          {
	              JOptionPane.showMessageDialog(null, i);
	          }
	           
	     }
			
	}
	
}

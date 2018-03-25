import javax.swing.JOptionPane;

/*
 35. Receba 2 números inteiros, verifique qual o maior entre eles. Calcule e
mostre o resultado da somatória dos números ímpares entre esses valores.
 */
public class Exercicio35 {
	
	static int Somar(int N1, int N2)
	{
	    int soma = 0;
	    
	    if(N1>=N2)
	    {
	       for(int i = N2; i<=N1; i++)
	       {
	           if(i%2 != 0)
	           {
	               soma = soma + i;
	           }
	       }
	   }
	   else
	   {
	       for(int i = N1; i<=N2; i++)
	       {
	           if(i%2 != 0)
	           {
	               soma = soma + i;
	           }
	       }
	   }
	   
	   return soma;
	}


	public static void main(String[] args) {

		int N1,N2;
		
		N1 = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero"));
		N2= Integer.parseInt(JOptionPane.showInputDialog("Digite outro numero"));
		
		JOptionPane.showMessageDialog(null, "O resultado da soma dos numeros impares entre os numeros digitados é "+ Somar(N1,N2));
	}

}

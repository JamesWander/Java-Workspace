import javax.swing.JOptionPane;

/*
 42. Calcule e mostre a série 1 + 2/3 + 3/5 + ... + 50/99
 */
public class Exercicio42 {

	static float proximoN1(float N1)
	{
	    N1++;
	    return N1;
	}
	static float proximoN2(float N2)
	{
	    N2 = N2+2;
	    return N2;
	}
	
	public static void main(String[] args) {
		
		float N1 = 0,N2 = 0,soma = 1;
		
		   for(int i = 1;i<50;i++)
		   {
		       
		       N1 = proximoN1(N1);
		       N2 = proximoN2(N2);
		       soma = soma +(N1/N2);
		       
		   }
		   JOptionPane.showMessageDialog(null,"O resultado da serie é "+ soma);

	}

}

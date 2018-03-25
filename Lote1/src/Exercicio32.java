import javax.swing.JOptionPane;

/*
 32. Receba um número inteiro. Calcule e mostre o seu fatorial
 */
public class Exercicio32 {

	static int Fatorial(int num)
	{
	    int fatorial;
	    
	    fatorial = num;
	       
	    for(int i = num-1; i>= 1; i--)
	    {
	        fatorial = fatorial * i;
	    }
	    return fatorial;
	}
	
	
	public static void main(String[] args) {
		
		int numero,fatorial;
		
		numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero inteiro"));
		fatorial = Fatorial(numero);
		
		JOptionPane.showMessageDialog(null, "O Fatorial do numero digitado é "+fatorial);

	}

}

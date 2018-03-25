import javax.swing.JOptionPane;

/*
Receba 100 números inteiros reais. Verifique e mostre o maior e o menos
valor. Obs.: somente valores positivos.
 */
public class Exercicio38 {

	static int verificaMaior(int numero, int maior)
	{
	    if(numero>=maior)
	    {
	        return numero;
	    }
	    else
	    {
	        return maior;
	    }
	}

	static int verificaMenor(int numero,int menor)
	{
	    if(numero>=menor)
	    {
	        return menor;
	    }
	    else
	    {
	        return numero;
	    }
	}
	
	public static void main(String[] args) {
		
		int maior = Integer.MAX_VALUE,menor = 0,numero,i=0;
		
		while(i < 10)
		{
			numero = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero"));
			if(numero<0)
			{
				JOptionPane.showMessageDialog(null, "Numero Invalido");
			}
			else
			{
				menor = verificaMenor(numero,menor);
				maior = verificaMaior(numero,maior);
				i++;
			}
			
		}
		
		JOptionPane.showMessageDialog(null, "O menor numero é "+menor);
		JOptionPane.showMessageDialog(null, "O maior numero é "+maior);
	}

}

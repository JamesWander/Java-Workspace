import javax.swing.JOptionPane;

/*
 39. Calcule a quantidade de grãos contidos em um tabuleiro de xadrez onde:
Casa: 1 2 3 4 ... 64
Qte: 1 2 4 8 ... N
 */
public class Exercicio39 {

	static double calcula(int i,double soma)
	{
	    soma = soma + Math.pow(2,i);

	    return soma;
	}
	
	public static void main(String[] args) {
		
		double soma = 0;
		
		  for(int i = 0;i<63; i++)
	       {
	            soma = calcula(i,soma);
	       }
		  JOptionPane.showMessageDialog(null, "O Resultado da soma é "+ soma);
		  

	}

}

import javax.swing.JOptionPane;

/*
╔══════════════════════════════════════════════════════════════╗
║  														       ║	
║  		Programador: James Wander Ferreira de Souza Junior     ║
║  												               ║
║  		Data: 14/09/2017									   ║
║  															   ║
║  		Objetivo: Criar e coletar um vetor [50] inteiro. 	   ║
║		exibir:									               ║
║		a. A média dos valores entre 10 e 200;				   ║
║		b. A soma dos números ímpares.                         ║
║  													           ║
║                                                              ║  
╚══════════════════════════════════════════════════════════════╝
  */
public class Exercicio01 {

	static int vetor[] = new int[50];
	
	public static void main(String[] args) {
		
		for(int i = 0; i <= 49; i++)
		{
			vetor[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero"));
		}
		
		MediaEntre();
		SomaImpar();

	}
	
	static void MediaEntre()
	{
		
		float media = 0;
		int contador = 0;
		
		
		for(int i = 0; i<=49; i++)
		{
			if(vetor[i] <=200 && vetor[i]>=10)
			{
				media += vetor[i];
				contador++;
			}
			
			media = media / contador;
			
		}
		
		JOptionPane.showMessageDialog(null, "A media dos numeros entre 10 e 200 é "+ media);
	}
	
	static void SomaImpar()
	{
		
		int soma = 0;
		
		for(int i = 0; i<=49; i++)
		{
			if(vetor[i] % 2 == 1)
			{
				soma += vetor[i];
			}
				
		}
		
		JOptionPane.showMessageDialog(null,"A soma dos numeros impares é "+soma);
	}

}

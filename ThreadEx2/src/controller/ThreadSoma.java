package controller;

public class ThreadSoma extends Thread {

	private int[] linha;
	private int nLinha;
	
	public ThreadSoma(int[] linha,int nLinha)
	{
		this.linha = linha;
		this.nLinha = nLinha;
	}
	
	public void run()
	{
		somaLinha();
	}
	
	private void somaLinha()
	{
		int soma = 0;
		for(int i = 0; i < 5; i++)
		{
			soma += linha[i];
		}
		
		System.out.println("A soma da linha " + nLinha + " é " + soma );
	}
	
}

package controller;

import java.util.Random;

public class ThreadSapo extends Thread {

	private int sapo;
	private int posicao = 0;
	private int pulo;
	private static int colocacao;
	private int saltoMaximo;
	private int percurso;
	Random gerador = new Random();
	
	public ThreadSapo(int sapo,int percurso, int saltoMaximo)
	{
		this.sapo 		 = sapo;
		this.percurso 	 = percurso;
		this.saltoMaximo = saltoMaximo;
	}
	
	public void run()
	{
		movimentaSapo();
	}
	
	private void movimentaSapo()
	{
		while(posicao < percurso)
		{
			pulo = gerador.nextInt(saltoMaximo);
			posicao += pulo;
			try 
			{
				Thread.sleep(gerador.nextInt(500));
			} catch (InterruptedException e) {}
			
			System.out.println("O Sapo " + sapo + " deu um pulo de " + pulo + " centimetros e ja percorreu " + posicao + " centimetros totais");
			
		}
		colocacao++;
		
		System.out.println("\n");
		System.out.println("O Sapo "+ sapo +" Chegou em " + colocacao + "º lugar");
		System.out.println("\n");
		
	}
	
}

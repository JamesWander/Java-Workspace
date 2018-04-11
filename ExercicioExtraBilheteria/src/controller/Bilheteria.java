package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Bilheteria extends Thread {
	
	private Semaphore semaforo;
	private static int qtdBilhete = 100;
	private Random gerador = new Random();
	
	public Bilheteria(Semaphore semaforo)
	{
		this.semaforo = semaforo;	
		run();
	}
	
	public void run()
	{
		login();

	}

	private void validarCompra(int nBilhetes)
	{
		if(nBilhetes <= qtdBilhete)
		{
			qtdBilhete -= nBilhetes;
			System.out.println("Compra de " + nBilhetes + " Bilhetes Realizada com sucesso");
		}
		
	}

	private void login() 
	{
		int tempoEspera = gerador.nextInt(1951)+50;
		try
		{
			Thread.sleep(tempoEspera);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		
		if(tempoEspera <= 1000)
		{
			compra();
		}
		else
		{
			System.out.println("TimeOut Login");
		}
	}
	
	private void compra()
	{
		int tempoEspera = gerador.nextInt(2001)+1000;
		
		try
		{
			Thread.sleep(tempoEspera);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		if(tempoEspera <= 2500)
		{
			try
			{
				semaforo.acquire();
				validarCompra(gerador.nextInt(4)+1);
			}
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			finally
			{
				semaforo.release();
			}
		}
		else
		{
			System.out.println("TimeOut durante a compra");
		}
	}
	
}

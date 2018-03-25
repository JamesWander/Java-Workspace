package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarros extends Thread{

	private String[] direcao = {"sul","norte","leste","oeste"};
	private int indopara; 
	private Semaphore semaforo;
	
	public ThreadCarros(int indopara,Semaphore semaforo) 
	{
		this.indopara = indopara;
		this.semaforo = semaforo;
	}
	
	public void run()
	{
		chegando();
		try
		{
			semaforo.acquire();
			cruzando();
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
	
	private void cruzando()
	{
		try
		{
			System.out.println("Semaforo em direção ao "+direcao[indopara]+" aberto");
			Thread.sleep(500);
			System.out.println("Um Carro esta cruzando em direçao ao "+direcao[indopara]+" Todos os outros sentidos fechados");
			Thread.sleep(1000);
			System.out.println("O Carro indo em direção ao "+ direcao[indopara] +" cruzou o semaforo que fechou logo em seguida\n");
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	private void chegando()
	{
		System.out.println("Carro esperando o farol abrir em direçao ao "+direcao[indopara]+"\n");
	}

}

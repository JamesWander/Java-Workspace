package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Cavaleiros extends Thread{

	private int velocidadeMaxima = 3;
	private int velocidadeMinima = 2;
	private Semaphore semaforo;
	private int distancia;
	private static boolean tocha = true;
	private static boolean pedra = true;
	private static boolean[] portas = new boolean[4];
	private boolean entrou;
	private Random gerador = new Random();
	private int idCavaleiro;
	


	public  Cavaleiros(Semaphore semaforo,int idCavaleiro)
	{
		this.semaforo = semaforo;
		this.idCavaleiro = idCavaleiro;
		run();
	}
	
	public void run()
	{
		andarCavaleiro();
	}
	
	private void andarCavaleiro()
	{
		while(distancia<500)
		{
			distancia += gerador.nextInt(velocidadeMaxima)+velocidadeMinima;
			try
			{
				Thread.sleep(50);
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			System.out.println(idCavaleiro + " Ta andando");
		}
		if(tocha)
		{
			tocha = false;
			velocidadeMinima += 2;
			System.out.println("O Cavaleiro #"+idCavaleiro + " Pegou a tocha");
		}
		while(distancia<1500)
		{
			distancia += gerador.nextInt(velocidadeMaxima)+velocidadeMinima;
			try
			{
				Thread.sleep(50);
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		if(pedra)
		{
			pedra = false;
			velocidadeMinima += 2;
			System.out.println("O Cavaleiro #"+idCavaleiro + " Pegou a pedra");
		}
		while(distancia<2000)
		{
			distancia += gerador.nextInt(velocidadeMaxima)+velocidadeMinima;
			try
			{
				Thread.sleep(50);
			}catch(InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		/*try
		{
			semaforo.acquire();
			entrando();
	
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		finally
		{
			semaforo.release();
		}*/
		
	}
	
	private void entrando()
	{
		int idPorta;
		while(!entrou)
		{
			idPorta = gerador.nextInt(4);
			if(!portas[idPorta])
			{
				portas[idPorta] = true;
				entrou = true;
				switch(idPorta)
				{
					case 0:
						System.out.println("O Cavaleiro #" + idCavaleiro + "Não esta mais nesse mundo");
					break;
					
					case 1:
						System.out.println("O Cavaleiro #" + idCavaleiro + "Esta rindo de quem vai se dar mal");
					break;
					
					case 2:
						System.out.println("O Cavaleiro #" + idCavaleiro + "Não esta mais nesse mundo");
					break;
					
					case 3:
						System.out.println("O Cavaleiro #" + idCavaleiro + "Não esta mais nesse mundo");
					break;
				}
				
				
			}
		}
	}
}



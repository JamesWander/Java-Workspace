package view;

import java.util.concurrent.Semaphore;

import controller.Cavaleiros;

public class Principal {

	public static void main(String[] args) {
		
		Semaphore semaforo = new Semaphore(1);
		Cavaleiros cavaleiro;
		
		
		for (int i = 0; i < 4; i++)
		{
			cavaleiro = new Cavaleiros(semaforo, i);
		}
		
	}
	
}

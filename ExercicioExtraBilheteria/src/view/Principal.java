package view;

import java.util.Random;
import java.util.concurrent.Semaphore;

import controller.Bilheteria;

public class Principal {
	
	public static void main(String[] args) {
		
		Semaphore semaforo = new Semaphore(1);
		Bilheteria bilhete;
		
		for(int i = 0; i < 300; i++)
		{
			bilhete = new Bilheteria(semaforo);
		}
	}

}

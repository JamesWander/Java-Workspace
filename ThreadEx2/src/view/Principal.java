package view;

import java.util.Random;

import controller.ThreadSoma;

public class Principal {

	public static void main(String[] args) {
		
		int[][] matriz = new int[3][5];
		ThreadSoma thread;
		Random gerador = new Random();
		int[] linha = new int[5];
		
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				matriz[i][j] = gerador.nextInt(50);
			}
		}
		
		for(int i = 0 ; i < 3 ; i++)
		{
			linha = matriz[i];
			
			thread = new ThreadSoma(linha, i);
			thread.start();
		}	
		
	}

}

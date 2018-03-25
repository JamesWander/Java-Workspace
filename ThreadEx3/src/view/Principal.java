package view;

import java.util.Random;

import javax.swing.JOptionPane;

import controller.ThreadSapo;

public class Principal {

	public static void main(String[] args) {
		
		int percurso;
		int saltoMaximo;
		ThreadSapo sapo;
		Random gerador = new Random();
		
		percurso = gerador.nextInt(2000);
		saltoMaximo = gerador.nextInt(200);
		
		System.out.println("O tamanho do percurso é " + percurso + " Centimetros");
		System.out.println("O tamanho do maximo do salto é " + saltoMaximo + " Centimetros");
		
		try 
		{
			Thread.sleep(1000);
			System.out.println("Iniciando a corrida em 3");
			Thread.sleep(1000);
			System.out.println("Iniciando a corrida em 2");
			Thread.sleep(1000);
			System.out.println("Iniciando a corrida em 1");
			Thread.sleep(1000);
			System.out.println("Já");
			
			
		} catch (InterruptedException e) {}
		
		
		for(int i = 0; i < 5; i++)
		{
			sapo = new ThreadSapo(i,percurso,saltoMaximo);
			sapo.start();
			
		}

	}

}

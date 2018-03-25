package controller;

import javax.swing.JOptionPane;

public class ThreadNum extends Thread {

	private int N;
	
	public ThreadNum(int N)
	{
		this.N = N;
	}
	
	public void run()
	{
		printarNumero();
	}
	
	private void printarNumero()
	{
		System.out.println("Thread Numero: "+N);
	}
	
}

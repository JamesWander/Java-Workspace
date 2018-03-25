package view;

import controller.ThreadNum;

public class Principal {

	public static void main(String[] args) {
		
		ThreadNum thread;
		
		for(int i = 1; i <= 5; i++)
		{
			thread = new ThreadNum(i);
			thread.start();
		}
		
	}
}

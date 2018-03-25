package view;

import controller.ThreadCalc;

public class Principal {

	public static void main(String[] args) {
		
		int a	= 10;
		int b 	= 2;
		//int op 	= 3;
		
		for(int op = 0; op <= 3; op++)
		{
			ThreadCalc tc = new ThreadCalc(a,b,op);
			tc.start();
		}

	}

}

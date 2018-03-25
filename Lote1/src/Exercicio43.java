import javax.swing.JOptionPane;

/*
 43. Calcule e mostre quantos anos serão necessários para que Ana seja maior que
Maria sabendo que Ana tem 1,10 m e cresce 3 cm ao ano e Maria tem 1,5 m
e cresce 2 cm ao ano.
 */
public class Exercicio43 {


	static double cresceAna(double Ana)
	{
	    Ana = Ana + 0.03;
	    return Ana;
	}
	static double cresceMaria(double Maria)
	{
	    Maria = Maria + 0.02;
	    return Maria;
	}
		
	public static void main(String[] args) {
		
		double Ana = 1.10,Maria = 1.5;
	    int ano = 0;
	    
	    while(Maria>=Ana)
	    {
	        Ana = cresceAna(Ana);
	        Maria = cresceMaria(Maria);
	        
	        ano++;
	    }
	    JOptionPane.showMessageDialog(null, "É necessario " + ano + " anos para Ana ser maior que Maria");
		
	}

}

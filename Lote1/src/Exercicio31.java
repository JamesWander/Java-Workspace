import javax.swing.JOptionPane;

/*
 31. Calcule e mostre o quadrado dos números entre 10 e 150.
 */
public class Exercicio31 {

	
	public static void main(String[] args) {
		
		   int i,quebra = 0;
		   String Quadrados ="";
		   
		   for(i = 10; i<=150; i++)
		   {
			   Quadrados = Quadrados +"        O quadrado de "+ i +" É "+ (i*i);
			   quebra++;
			   if(quebra == 3)
			   {
				   Quadrados = Quadrados + "\n";
				   quebra = 0;
			   }
		   }
		   JOptionPane.showMessageDialog(null,Quadrados);
		    
		
		
	}

}

import javax.swing.JOptionPane;

/*
45. Calcule e mostre a série 1 – 2/4 + 3/9 – 4/16 + 5/25 + ... + 15/225
 */
public class Exercicio45 {

	static double serie()
	{
		double total = 1,N2;
		int N1 = 0;
		
		for(int i = 1;i<15; i++)
	    {
	        N1++;
	        N2 = Math.pow(N1,2);
	        if(Math.floorMod(N1,2) == 0)
	        {
	            
	            total = total - (N1/N2);
	            
	        }
	        else
	        {
	            
	            total = total + (N1/N2);
	            
	        }
	    }
		
		return total;
	}
	
	public static void main(String[] args) {
		
		JOptionPane.showMessageDialog(null, "O Total da serie é " + serie());
		

	}

}

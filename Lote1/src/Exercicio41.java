import javax.swing.JOptionPane;

/*
 41. Mostre todas as possibilidades de 2 dados de forma que a soma tenha como
resultado 7.
 */
public class Exercicio41 {

	static boolean teste(int i,int j)
	{
	    if((i+j) == 7)
	    {
	        return true;
	    }
	    else
	    {
	        return false;
	    }
	}

	
	public static void main(String[] args) {
		
		String possibilidades = "";
		   for(int i = 1;i<=6; i++)
	       {
	            for(int j = 1;j<=6; j++)
	            {
	                if(teste(i,j) == true)
	                {
	                    possibilidades += i + " + " + j + " = "+ 7 + "\n";
	                }
	              
	            }
	       }
		   JOptionPane.showMessageDialog(null, possibilidades);

	}

}

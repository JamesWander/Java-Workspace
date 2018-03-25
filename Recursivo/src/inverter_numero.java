import javax.swing.JOptionPane;
import javax.swing.plaf.synth.SynthSeparatorUI;

public class inverter_numero {

	static String numero = "";
	static String Invertido = "";
	
	public static void main(String[] args) {
		
		numero = JOptionPane.showInputDialog(null,"Digite um numero");
		
		int tamanho = numero.length();
		
		inverter(tamanho);
		JOptionPane.showMessageDialog(null,Invertido);
		
	}
	
	public static int inverter(int n)
	{
		if(n == 0)
		{
			return n;
		}
		else
		{
			Invertido += numero.substring(n-1,n);
			return inverter(n-1);
		}	
		
	}
}

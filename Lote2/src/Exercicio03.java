import javax.swing.JOptionPane;

public class Exercicio03 {

	public static void main(String[] args) {

		int VT1[] = new int[3];
		int VT2[] = new int[3];
		int VT3[] = new int[6];
		
		String vetor3 = "";
		
		for(int i = 0; i <= 2; i++)
		{
			VT1[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero vetor 1"));
		}
		
		for(int i = 0; i <= 2; i++)
		{
			VT2[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite um numero vetor 2"));
		}
		
		for(int i = 0; i <= 2; i++)
		{
			VT3[i] = VT1[i];
			VT3[i+3] = VT2[i];
		}
		
		for(int i = 0; i <= 5; i++)
		{
			vetor3 +=  VT3[i];
		}
		JOptionPane.showMessageDialog(null, vetor3);
		
		
	}

}

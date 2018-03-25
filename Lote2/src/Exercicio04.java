import javax.swing.JOptionPane;

public class Exercicio04 {

	public static void main(String[] args) {
		
		int grupo[] = new int[30];
		float media = 0;
		String posicoes = "Posições abaixo da media :";
		int acima = 0;
		
		
		for(int i = 0; i <= 29; i++)
		{
			grupo[i] = Integer.parseInt(JOptionPane.showInputDialog("Digite uma nota"));
			media += grupo[i];
		}
		media = media / 30;
		
		for(int i = 0; i<=29; i++)
		{
			if(grupo[i]>media)
			{
				acima++;
			}
			else
			{
				posicoes += " "+i;
			}
		}
		
		JOptionPane.showMessageDialog(null, "Numero de alunos acima da media do grupo: "+acima+"\n"+posicoes);

	}

}

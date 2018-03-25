import javax.swing.JOptionPane;

/*
 27. Receba o número de voltas, a extensão do circuito (em metros) e o tempo de
duração (minutos). Calcule e mostre a velocidade média em km/h.

 */
public class Exercicio27 {

	
	static void VelocidadeMedia(float NV,float EC,float TD)
	{
	    float VM;
	    
	    TD=TD/60;
	    VM=EC/TD;
	    JOptionPane.showMessageDialog(null,"A Velocidade Média é: "+VM+"Km/h");
	    
	}
	
	
	
	
	public static void main(String[] args) {
		
		float Nv,Ec,Td;
		
		Nv = Float.parseFloat(JOptionPane.showInputDialog("Digite o numero de voltas"));
		Ec = Float.parseFloat(JOptionPane.showInputDialog("Digite a extencao do circuito em metros"));
		Ec = (Ec*Nv)/1000;
		Td = Float.parseFloat(JOptionPane.showInputDialog("Digite o tempo de duraçao em minutos"));
		VelocidadeMedia(Nv,Ec,Td);
		

	}

}

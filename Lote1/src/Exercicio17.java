/*
╔══════════════════════════════════════════════════════════════╗
║  														       ║	
║  		Programador: James Wander Ferreira de Souza Junior     ║
║  												               ║
║  		Data: 24/08/2017									   ║
║  															   ║
║  		Objetivo: Receba a base e a altura de um triângulo.    ║
║		Calcule e mostre a sua área. 		   				   ║
║													           ║
║                                                              ║  
║															   ║
╚══════════════════════════════════════════════════════════════╝
 */
import javax.swing.JOptionPane;

/*
 17. Calcule a quantidade de litros gastos em uma viagem, sabendo que o
automóvel faz 12 km/l. Receber o tempo de percurso e a velocidade média.
 */
public class Exercicio17 {

	
	static void Calcular(float velocidade, float tempo)
	{
	    
	   float dis,litros;
	    
	   dis = tempo*velocidade;
	   litros = dis/12;
	   JOptionPane.showMessageDialog(null, "litros Necessarios para a viagem "+litros);
	    
	}
	
	
	public static void main(String[] args) {
		
		float tempo,velocidade;
		
		tempo = Float.parseFloat(JOptionPane.showInputDialog("Digite o tempo de percurso"));
		velocidade = Float.parseFloat(JOptionPane.showInputDialog("Digite a velocidade media"));
		
		Calcular(velocidade,tempo);
		

	}

}

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
 21. Receba 4 notas bimestrais de um aluno. Calcule e mostre a média aritmética.
Mostre a mensagem de acordo com a média:
a. Se a média for >= 6,0 exibir “APROVADO”;
b. Se a média for >= 3,0 ou < 6,0 exibir “EXAME”;
c. Se a média for < 3,0 exibir “RETIDO”.
 */
public class Exercicio21 {

		
	static void media(float N1,float N2, float N3, float N4)
	{
	   float Media;
	    
	   Media = (N1+N2+N3+N4)/4;
	   JOptionPane.showMessageDialog(null,"A Media é: "+Media);
	   if(Media>=6)
	   {
		   JOptionPane.showMessageDialog(null,"Aprovado");
	   }
	   else if(Media >=3 && Media< 6)
	   {
		   JOptionPane.showMessageDialog(null,"Exame");
	   }
	   else
	   {
		   JOptionPane.showMessageDialog(null,"Retido");
	   }
	    
	}
		
		
	public static void main(String[] args) {
		
		float n1,n2,n3,n4;
		
		n1 = Float.parseFloat(JOptionPane.showInputDialog("Digite a N1"));
		n2 = Float.parseFloat(JOptionPane.showInputDialog("Digite a N2"));
		n3 = Float.parseFloat(JOptionPane.showInputDialog("Digite a N3"));
		n4 = Float.parseFloat(JOptionPane.showInputDialog("Digite a N4"));
		
		media(n1,n2,n3,n4);
	}

}

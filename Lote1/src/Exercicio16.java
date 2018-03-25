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
16. Receba a quantidade de horas trabalhadas, o valor por hora, o percentual
de desconto e o número de descendentes. Calcule o salário que serão as
horas trabalhadas x o valor por hora. Calcule o salário líquido (= Salário
Bruto – desconto). A cada dependente será acrescido R$ 100 no Salário
Líquido. Exiba o salário a receber.
 */
public class Exercicio16 {

	static void salario(float HT, float VH, float PD, float ND)
	{
	   float SB,SL;
	    
	   SB= HT*VH;
	   SL = (SB -(SB*(PD/100)))+(100*ND);
	   JOptionPane.showMessageDialog(null,"O Salario a Receber é: "+SL);
	   
	}
	
	
	public static void main(String[] args) {
	
		   float HT,VH,PD,ND;
		   
		   HT = Float.parseFloat(JOptionPane.showInputDialog("Digite o numero de horas trabalhadas"));
		   VH = Float.parseFloat(JOptionPane.showInputDialog("Digite o valor de cada hora"));
		   PD = Float.parseFloat(JOptionPane.showInputDialog("Digite o percentual de desconto"));
		   ND = Float.parseFloat(JOptionPane.showInputDialog("Digite o numero de dependentes"));
		   
		   salario(HT,VH,PD,ND);

	}

}

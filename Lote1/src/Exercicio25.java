import javax.swing.JOptionPane;

/*
 25. Receba a hora de início e de final de um jogo (HH,MM) sabendo que o
tempo máximo é de 24 horas e pode começar num dia e terminar noutro.
 */
public class Exercicio25 {

	
	static void verificarHora(int HH, int MM)
	{
	    int HH2,MM2,TS1,TS2,TF,term = 0;
	    
	   while(term == 0)
	   {
	       HH2 = Integer.parseInt(JOptionPane.showInputDialog("Digite as hora 2"));
	       
	       MM2 = Integer.parseInt(JOptionPane.showInputDialog("Digite os minutos 2"));
	       
	       TS1=(60*MM)+(3600*HH);
	       TS2=(60*MM2)+(3600*HH2);
	       TF=TS1-TS2;
	       if(TF> 86400)
	       {
	            JOptionPane.showMessageDialog(null,"Horario Invalido");  
	       }
	       else
	       {
	           term=1;
	       }
	       
	       
	    }
	}
	
	
	public static void main(String[] args) {
		
		int HH,MM;
		
		HH = Integer.parseInt(JOptionPane.showInputDialog("Digite as horas"));
		MM = Integer.parseInt(JOptionPane.showInputDialog("Digite os minutos"));
		
		verificarHora(HH,MM);

	}

}

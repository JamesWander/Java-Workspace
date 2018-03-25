import javax.swing.JOptionPane;

/*
29. Receba o tipo de investimento (1 = poupança e 2 = renda fixa) e o valor do
investimento. Calcule e mostre o valor corrigido em 30 dias sabendo que a
poupança = 3% e a renda fixa = 5%. Demais tipos não serão considerados.
 */
public class Exercicio29 {


static void ValorCorrigido(float TI,float VI)
{
    float VC;
    
    if(TI == 1)
    {
        VC = VI + (VI*3/100);
        JOptionPane.showMessageDialog(null,"Valor corrigido é: "+VC);
    }
    else if(TI == 2)
    {
        VC = VI + (VI*5/100);
        JOptionPane.showMessageDialog(null,"Valor corrigido é: "+VC);
    }
    else
    {
    	JOptionPane.showMessageDialog(null,"Erro, Encerrando Programa");
    }
}    
	
	
	public static void main(String[] args) {

		float TI,VI;
	    
		TI =Float.parseFloat(JOptionPane.showInputDialog("Digite o tipo de investimento 1 = poupanca, 2 = renda fixa"));
		VI =Float.parseFloat(JOptionPane.showInputDialog("Digite o valor do investimento"));
		
		ValorCorrigido(TI,VI);
		
	}

}

import javax.swing.JOptionPane;

/*
 28. Receba o pre�o atual e a m�dia mensal de um produto. Calcule e mostre o
novo pre�o sabendo que:
Venda Mensal Pre�o Atual Pre�o Novo
< 500 < 30 + 10%
>= 500 e < 1000 >= 30 e < 80 +15%
>= 1000 >= 80 - 5%
Obs.: para outras condi��es, pre�o novo ser� igual ao pre�o atual.

 */
public class Exercicio28 {


static void preco(float PA, float MM)
{
    float NP;
    
    if(MM<500 && PA<30)
    {
        NP = PA + ((PA*10)/100);
    }
    else if(MM>=500 && MM<1000 && PA>=30 && PA<80)
    {
        NP = PA + ((PA*15)/100);
    }
    else if(MM>=1000 && PA>=80)
    {
        NP = PA + ((PA*5)/100);
    }
    else
    {
        NP = PA;
    }
    JOptionPane.showMessageDialog(null,"O novo pre�o �: "+NP);
    
}
	
	
	public static void main(String[] args) {
		
		float PA,MM;
		
		PA = Float.parseFloat(JOptionPane.showInputDialog("Digite o Pre�o Atual"));
		MM = Float.parseFloat(JOptionPane.showInputDialog("Digite a media mensal"));
		preco(PA,MM);

	}

}

import javax.swing.JOptionPane;

/*
 30. Receba a data de nascimento e atual em ano, mês e dia. Calcule e mostre a
idade em anos, meses e dias, considerando os anos bissextos.

 */
public class Exercicio30 {

	public static void main(String[] args) {
		
		int AA,MM,DD,AA2,MM2,DD2,DA,DF,MF,AF,BX=0;
		//double DF,MF,AF;
		   
		   
		   DD = Integer.parseInt(JOptionPane.showInputDialog("Digite o dia nascimento"));
		   MM = Integer.parseInt(JOptionPane.showInputDialog("Digite o mes nascimento"));
		   AA = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano nascimento"));
		   
		   
		   DD2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o dia atual"));
		   MM2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o mes atual"));
		   AA2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano atual"));
		   
		   DA = AA2-AA;
		   DA = DA*365;
		   
		    for(int i = AA; i < AA2; i++)
		    { 
		        if(i % 4 == 0 && (i % 400 == 0 || i % 100 != 0))
		        {
		            BX = BX + 1;
		        }
		    }
		    
		    DA = DA+BX;
		    
		    if(MM >=MM2)
		    {
		        for(MM=MM; MM>MM2; MM--)
		        {
		            if(MM == 1 || MM == 3 || MM == 5 || MM == 7 || MM == 8 || MM == 10 || MM == 12)
		            {
		                DA = DA - 31;
		            }
		            else if(MM == 4 || MM == 6 || MM == 9 || MM == 11)
		            {
		                DA = DA - 30;
		            }
		            else if(MM == 2)
		            {
		                DA = DA - 28;
		            }
		        }
		    }
		    else
		    {
		        for(MM2=MM2; MM2>MM; MM2--)	
		        {
		            if(MM2 == 1 || MM2 == 3 || MM2 == 5 || MM2 == 7 || MM2 == 8 || MM2 == 10 || MM2 == 12)
		            {
		                DA = DA + 31;
		            }
		            else if(MM2 == 4 || MM2 == 6 || MM2 == 9 || MM2 == 11)
		            {
		                DA = DA + 30;
		            }
		            else if(MM2 == 2)
		            {
		                DA = DA + 28;
		            }
		        }
		    }
		    
		    
		    if(DD>=DD2)
		    {
		        DA = DA - (DD-DD2);
		    }
		    else
		    {
		        DA = DA - (DD2-DD);
		    }
		    
		    AF = DA/365;
		    MF = (int) ((DA -(AF*365))/ 30.417);
		    DF = (int) (DA-(AF*365)-(MF*30.417));
		 
		    
		   JOptionPane.showMessageDialog(null,AF+" Anos "+MF+" Meses e "+DF+" Dias ");
		 
		}
		
	}

	

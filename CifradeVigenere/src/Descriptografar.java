import javax.swing.JOptionPane;

public class Descriptografar {

	public static void main(String[] args) {
		
		
		char help;
		String senha, texto, cript = "";
		int aux = 0;
		
		texto = JOptionPane.showInputDialog("Digite a palavra a ser descriptografada").toUpperCase();
		senha = JOptionPane.showInputDialog("Digite a senha de criptografia").toUpperCase();
		
		
		while(senha.length() < texto.length())
		{
			
			senha += senha.charAt(aux);
			aux++;
		}
		
		
		for(int i = 0; i <= texto.length()-1; i++)
		{	
			cript += (char)(((texto.charAt(i) - senha.charAt(i) + 26) % 26) + 'A');
		
		}
		
		JOptionPane.showMessageDialog(null, cript);
		
		

	}

}

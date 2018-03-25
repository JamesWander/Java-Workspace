import javax.swing.JOptionPane;

public class Encriptografar {

	public static void main(String[] args) {
		
		char help;
		String senha, texto, cript = "";
		int aux = 0;
		
		texto = JOptionPane.showInputDialog("Digite a palavra a ser encriptografada").toUpperCase();
		senha = JOptionPane.showInputDialog("Digite a senha de criptografia").toUpperCase();
		
		
		while(senha.length() < texto.length())
		{
			
			senha += senha.charAt(aux);
			aux++;
		}
		
		
		for(int i = 0; i <= texto.length()-1; i++)
		{	
			cript += (char)(((senha.charAt(i) + texto.charAt(i)) % 26)+ 'A');
		
		}
		
		JOptionPane.showMessageDialog(null, cript);
	}

}

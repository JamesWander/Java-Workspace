import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * IMPORTANT: O nome da classe deve ser "Main" para que a sua solução execute
 * Class name must be "Main" for your solution to execute El nombre de la clase
 * debe ser "Main" para que su solución ejecutar
 */
public class Main {

	public static void main(String[] args) throws IOException {

		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(ir);
		int t;
		String tex, res = "";
		
		do {
			tex = in.readLine();
			t = tex.length();
			
			if (tex != null && t>0)
			{
				Pilha p1 = new Pilha(tex.length());

				int i = 0;

				while (i < tex.length()) 
				{
					if (tex.charAt(i) == '(') 
					{
						p1.empilhar('(');
					}
					else if (p1.vazia() && tex.charAt(i) == ')')
					{
						p1.empilhar(')');
					}
					else if (tex.charAt(i) == ')')
					{
						p1.desempilhar();
					}

					i++;
				}

				if (p1.vazia())
				{
					res = res + "correct\n";
				}
				else
				{
					res = res + "incorrect\n";
				}
			}
			
		} while (t != 0);
		System.out.printf(res);
	}

}

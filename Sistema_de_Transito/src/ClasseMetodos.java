import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class ClasseMetodos {

	public Cidade[] CadCidades(Cidade[] cidade) throws IOException
	{
		String arquivo = "BancoDeDados.txt";
		BufferedWriter write = new BufferedWriter(new FileWriter(arquivo));
		
		
		for(int i = 0; i < 15; i++)
		{
			cidade[i] = new Cidade();
		}
		
		for(int i = 0; i < 15; i++)
		{
			cidade[i].CodCidade = i;
			write.write(Integer.toString(cidade[i].CodCidade));
			write.newLine();
			
			cidade[i].NomeCidade = JOptionPane.showInputDialog("Digite o nome da cidade ");
			write.write(cidade[i].NomeCidade);
			write.newLine();
			
			cidade[i].QtdAcidentes = Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de acidentes"));
			write.write(Integer.toString(cidade[i].QtdAcidentes));
			write.newLine();
			
			cidade[i].TipoVeiculo = Integer.parseInt(JOptionPane.showInputDialog("Digite o tipo de veiculo, 1 - passeio\n2 - publico\n3 - Caminhao"));
			write.write(Integer.toString(cidade[i].TipoVeiculo));
			write.newLine();
		}
		JOptionPane.showMessageDialog(null, "Gravado com sucesso");
		write.close();
		
		return cidade;
	}
	
	public void ConsultaTipo(Cidade[] cidade, int tipo) throws IOException
	{
		
		String arquivo = "BancoDeDados.txt";
		BufferedReader reader = new BufferedReader(new FileReader(arquivo));
		
		for(int i = 0; i < 15; i++)
		{
			cidade[i].CodCidade = Integer.parseInt(reader.readLine());
			cidade[i].NomeCidade = reader.readLine();
			cidade[i].QtdAcidentes= Integer.parseInt(reader.readLine());
			cidade[i].TipoVeiculo = Integer.parseInt(reader.readLine());
		}
		
		for(int i = 0; i < 15; i++)
		{
			if(cidade[i].TipoVeiculo == tipo)
			{
				System.out.println("Numero de Acidentes do tipo " + tipo + ": "+ cidade[i].QtdAcidentes);
			}
			reader.close();
		}
		
	}
	
	
	
}

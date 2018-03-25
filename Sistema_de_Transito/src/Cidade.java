
public class Cidade {

	int CodCidade;
	String NomeCidade;
	int QtdAcidentes;
	int TipoVeiculo;

	public Cidade() {
		this(0, "", 0, 0);
	}

	public Cidade(int cod, String nome, int qtd, int tipo) {
		CodCidade = cod;
		NomeCidade = nome;
		QtdAcidentes = qtd;
		TipoVeiculo = tipo;
	}

}
/*
 * 	Classe que mantem dados e opera�oes para alunos
 * @author James Wander
 */
public class Aluno {


	private String nome;
	private String ra;
	
	/**
	 * Construtor
	 * @param nome � o nome completo do aluno
	 * @param ra � o registro academico
	 */
	public Aluno(String nome, String ra) {
		super();
		this.nome = nome;
		this.ra = ra;
	}

	/**
	 * Metodo que concatena o valor dos atributos
	 * @return � uma string com valor dos atributos
	 */
	public String toString() {
		return "nome " + nome + ", ra " + ra + "\n";
	}
	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}
	
}

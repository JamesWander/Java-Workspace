package outros;

public class DadosLogin {
	private static int codigo;
	private static String nome;
	private static String tipo;
	private static byte[] imagen;
	
	
	public static String getNome() {
		return nome;
	}
	public static void setNome(String nome) {
		DadosLogin.nome = nome;
	}
	
	
	public static String getTipo() {
		return tipo;
	}
	public static void setTipo(String tipo) {
		DadosLogin.tipo = tipo;
	}
	
	
	public static int getCodigo() {
		return codigo;
	}
	public static void setCodigo(int codigo) {
		DadosLogin.codigo = codigo;
	}
	
	
	public static byte[] getImagen() {
		return imagen;
	}
	public static void setImagen(byte[] imagen) {
		DadosLogin.imagen = imagen;
	}
	
}

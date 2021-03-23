package lexercicio01.main;

public class Candidato {

	public Candidato(int id, String nome) {
		this.id = id;
		this.nome = nome;

	}

	private int id;
	private String nome;
	private int numeroDeVotos;

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public int getNumeroDeVotos() {
		return numeroDeVotos;
	}

	public void adicionarVoto() {
		this.numeroDeVotos += 1;
	}

}

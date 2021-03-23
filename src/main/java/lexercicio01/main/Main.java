package lexercicio01.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Main app = new Main();
		app.start();

	}

	private Map<Integer, Candidato> mapaDeCandidatos = new HashMap<Integer, Candidato>();

	private void start() {

		

		inicializarMapaDeCandidatos();

		while (true) {
			int voto = obterVoto();
			if (voto == 0) {
				break;
			}

			System.out.println("numero do voto" + voto);
			
			registrarVoto(voto);
		}

		apurarVotos();
		
		System.out.println("Fim da aplicacao");

	}

	private void apurarVotos() {

		List<Candidato> candidatos = new ArrayList<Candidato>();

		for (Candidato candidato : mapaDeCandidatos.values()) {

			candidatos.add(candidato);

		}

		candidatos.sort((a, b) -> {
			return b.getNumeroDeVotos() - a.getNumeroDeVotos();
		});
		
		/*
		 * Neste trecho faremos a etapa na qual 
		 * sera identificado quantos candidatos estao
		 * empatados
		 */
		
		List<Candidato> candidatosEmpatados = new ArrayList<Candidato>();
		for(Candidato candidato : candidatos) {
			
		}
		
		
		
		
		
		
		/*
		 *Esse boloco exibe o candidato eleito 
		 */
		Candidato candidatoEleito = candidatos.get(0);

		System.out.println("O candidato eleito eh o " + candidatoEleito.getNome() + " com "
				+ candidatoEleito.getNumeroDeVotos() + " votos");

		for (int i = 0; i < candidatos.size(); i++) {

			int posicao = i + 1;
			Candidato candidato = candidatos.get(i);
			System.out.println("Lugar " +posicao+ " candidato " + candidato.getNome() + " - " + candidato.getNumeroDeVotos() + " votos");
		}
	}

	private void inicializarMapaDeCandidatos() {

		Candidato padme = new Candidato(1, "Padme");
		mapaDeCandidatos.put(padme.getId(), padme);
		Candidato obiWan = new Candidato(2, "Obi_Wan");
		mapaDeCandidatos.put(obiWan.getId(), obiWan);
		Candidato luke = new Candidato(3, "Luke");
		mapaDeCandidatos.put(luke.getId(), luke);
		Candidato anakin = new Candidato(4, "Anakin");
		mapaDeCandidatos.put(anakin.getId(), anakin);
		Candidato vader = new Candidato(5, "Vader");
		mapaDeCandidatos.put(vader.getId(), vader);
	}

	private int obterVoto() {

		System.out.println("Digite seu voto: ");
		Scanner scanner = new Scanner(System.in);

		try {

			return scanner.nextInt();
		} catch (Exception e) {

			scanner.next();

			System.out.println("Valor invalido");
			return -1;
		}
	}

	private void registrarVoto(int voto) {

		/*
		 * NOME_MAPA.containsKey(CHAVE_EM_QUESTAO) NOME_MAPA.get(CHAVE_EM_QUESTAO)
		 */
		if (mapaDeCandidatos.containsKey(voto)) {

			Candidato candidato = mapaDeCandidatos.get(voto);
			candidato.adicionarVoto();

			System.out.println("Nome do candidato votado: " + candidato.getNome() + ".");
			System.out.println("Obrigado pelo voto seu candango!");

		} else {
			System.out.println("Desculpa esse candidato não existe. Tente novamente");
		}

	}
}
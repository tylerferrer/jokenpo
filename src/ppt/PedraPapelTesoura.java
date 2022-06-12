package ppt;

public class PedraPapelTesoura {

//	método para iniciar o jogo
	public static void main(String[] args) {
		PedraPapelTesoura game = new PedraPapelTesoura();
		game.startGame();
	}

	public Usuario user;
	public Usuario user2;
	public CPU computer;
	private int jogador1Pontos;
	private int jogador2Pontos;
	private int CPUPontos;
	private int jogadas;

	public PedraPapelTesoura() {

		user = new Usuario();
		user2 = new Usuario();
		computer = new CPU();
		jogador1Pontos = 0;
		jogador2Pontos = 0;
		CPUPontos = 0;
		jogadas = 0;
	}

	public void startGame() {

		Move userMove = user.getMove();
		Move user2Move = user2.getMove();
		Move cpuMove = computer.getMove();

		System.out.println("\n O jogador 1 escolheu " + userMove + ".");
		System.out.println("\n O jogador 2 escolheu " + user2Move + ".");
		System.out.println("\n O CPU escolheu " + cpuMove + ".\n");

		int compareMoves = userMove.compareMoves(user2Move);
		int compareMoves2 = userMove.compareMoves(cpuMove);
		int compareMoves3 = cpuMove.compareMoves(user2Move);

//  compara os movimentos para saber quem foi o vencedor

		switch (compareMoves) {
		case 0: // Empate
			System.out.println("Deu empate!");
			break;
		case 1:
			System.out.println(userMove + " ganha de " + user2Move + ". Jogador 1 venceu!");
			jogador1Pontos++;
			break;
		case -1:
			System.out.println(user2Move + " ganha de " + userMove + ". Jogador 2 venceu!");
			jogador2Pontos++;

			break;

		}
		switch (compareMoves2) {
		case 0: // Empate
			System.out.println("Deu empate!");
			break;
		case 1:
			System.out.println(userMove + " ganha de " + cpuMove + ". Jogador 1 venceu!");
			jogador1Pontos++;
			break;
		case -1:
			System.out.println(user2Move + " ganha de " + cpuMove + ". Jogador 2 venceu!");
			jogador2Pontos++;

			break;

		}

		switch (compareMoves3) {
		case 0: // Empate
			System.out.println("Deu empate!");
			break;
		case 1:
			System.out.println(cpuMove + " ganha de " + user2Move + ". CPU venceu!");
			CPUPontos++;
			break;
		case -1:
			System.out.println(cpuMove + " ganha de " + userMove + ". CPU venceu!");
			CPUPontos++;

			break;

		}

		jogadas++;

// Pergunta ao usuário se ele deseja jogar novamente.
		if (user.playAgain()) {
			System.out.println();
			startGame();
		} else {
			printGameStats();
		}
	}

// mostra o resultado dos jogos e a quantidade de vitórias de cada jogador.
	private void printGameStats() {
		int jogador1 = jogador1Pontos;
		int jogador2 = jogador2Pontos;
		int CPU = CPUPontos;
		int empate = jogadas - jogador1Pontos - jogador2Pontos;

// Imprimir valores
		System.out.printf(" Vitórias Jogador 1: " + jogador1Pontos);
		System.out.printf("\n Vitórias Jogador 2: " + jogador2Pontos);
		System.out.println("\n Vitórias CPU : " + CPUPontos);
		System.out.printf(" Empates: " + empate);
		System.out.printf("\n Jogos realizados: " + jogadas);

	}

}

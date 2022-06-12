package ppt;

import java.util.Scanner;

public class Usuario {
	private Scanner inputScanner;

	public Usuario() {
		inputScanner = new Scanner(System.in);
	}

	public Move getMove() {

// Apresentar o menu ao usuário
		System.out.println("---------------------------------------------------------------------------");
		System.out.println();
		System.out.println("Vamos jogar...");
		System.out.println();
		System.out.println("PEDRA                    PAPEL                           TESOURA!");
		System.out.println("    ___                   ___                  ___");
		System.out.println("---'   _)            ---'   __)_           ---'    _) _");
		System.out.println("      (__)                     __)                    ___)");
		System.out.println("      (__)                     ___)                _____)");
		System.out.println("      (_)                    ___)                 (_)");
		System.out.println("---._(_)             ---.___)            ---._(__)");
		System.out.println();
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Opções para escolher:\n1.Pedra\n2.Papel\n3.Tesoura");
		System.out.println("----------------------------------------------------------------------------");

// Obtendo a entrada

		String userInput = inputScanner.nextLine();
		userInput = userInput.toUpperCase();
		char primeiraLetra = userInput.charAt(0);
		char segundaLetra = userInput.charAt(1);

		if (primeiraLetra == 'P' && (segundaLetra == 'E' || segundaLetra == 'A') || primeiraLetra == 'T') {
// valida a entrada digitada pelo usuário

			switch (primeiraLetra) {
			case 'P':
				if (segundaLetra == 'E') {
					return Move.PEDRA;
				} else {
					return Move.PAPEL;
				}
			case 'T':
				return Move.TESOURA;
			}

		}
		return getMove();

	}

//pergunta se o jogo vai continuar
	public boolean playAgain() {
		System.out.print("Deseja jogar novamente? ");
		String userInput = inputScanner.nextLine();
		userInput = userInput.toUpperCase();
		return userInput.charAt(0) == 'S';
	}
}

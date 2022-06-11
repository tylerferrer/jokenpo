package a3_sistemas;

import java.util.Random;
import java.util.Scanner;

public class jokenpo {

	// Função criada para a escolha do computador

	public static String getEscolhaCPU(Random random) {

		int opcao;

		opcao = random.nextInt(3) + 1;
		String escolhaCPU = "";
		if (opcao == 1) {
			escolhaCPU = "Pedra";
		} else if (opcao == 2) {
			escolhaCPU = "Papel";
		} else if (opcao == 3) {
			escolhaCPU = "Tesoura";
		}
		System.out.println("\nO CPU já fez sua escolha");

		// Retorno da opção escolhida

		return escolhaCPU;

	}

	// Função criada para mostrar as opções para o jogador

	public static void Menu() {

		System.out.println("---------------------------------------------------------------------------");
		System.out.println();
		System.out.println("Vamos jogar...");
		System.out.println();
		System.out.println("PEDRA                    PAPEL                           TESOURA!");
		System.out.println("    ___                 ___                    ___");
		System.out.println("---'   _)            ---'   __)_           ---'   _)_");
		System.out.println("      (__)                     __)                    ___)");
		System.out.println("      (__)                     ___)                _____)");
		System.out.println("      (_)                    ___)                 (_)");
		System.out.println("---._(_)             ---.___)            ---._(__)");
		System.out.println();
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Opções para escolher:\n1.Pedra\n2.Papel\n3.Tesoura");
		System.out.println("----------------------------------------------------------------------------");

	}

	// Função criada para a escolha do jogador

	public static String getEscolhaJogador(Scanner scanner) {

		String opcaoJogador = "";
		System.out.print("\nFaça sua escolha : ");
		opcaoJogador = scanner.nextLine();

		// Retorno da opção escolhida

		return opcaoJogador;

	}

	public static String getEscolhaModo(Scanner scanner) {

		String modo = "";
		System.out.print("Escolha um modo de jogo :\n1.Jogador vs CPU\n2.Jogador vs Jogador");
		modo = scanner.nextLine();

	//		Retorno da opção escolhida
		return modo;
	}

	// Função para escolher vencedor

	public static String getEscolhaVencedor(String escolhaCPU, String escolhaJogador) {

		String vencedor = "Ninguém";
		String empate = "Empate";
		String mensagemFinal = "";

		String pedraEmpate = "A pedra esmaga a tesoura";
		String tesouraEmpate = "Tesoura corta papel";
		String papelEmpate = "Papel embrulha pedra";

		// Lógica do jogo

//        if (escolhaJogador.equalsIgnoreCase("sair")) {
//            System.out.println("Obrigado por jogar!");
//        } else

		if (escolhaCPU.equals("pedra") && escolhaJogador.equalsIgnoreCase("tesoura")) {
			vencedor = "CPU";
			empate = pedraEmpate;
		} else if (escolhaJogador.equalsIgnoreCase("pedra") && escolhaCPU.equals("tesoura")) {
			vencedor = "Jogador";
			empate = pedraEmpate;
		}

		if (escolhaCPU.equals("tesoura") && escolhaJogador.equalsIgnoreCase("papel")) {
			vencedor = "CPU";
			empate = tesouraEmpate;
		} else if (escolhaJogador.equalsIgnoreCase("tesoura") && escolhaCPU.equals("papel")) {
			vencedor = "Jogador";
			empate = tesouraEmpate;
		}

		if (escolhaCPU.equals("papel") && escolhaJogador.equalsIgnoreCase("pedra")) {
			vencedor = "CPU";
			empate = tesouraEmpate;
		} else if (escolhaJogador.equalsIgnoreCase("papel") && escolhaCPU.equals("pedra")) {
			vencedor = "Jogador";
			empate = papelEmpate;
		} else {
			System.out.println("Opção invalida");
		}

		// Lógica para o final do jogo

		mensagemFinal = vencedor + " venceu! ( " + empate + " )";

		// Retorno da mensagem final

		return mensagemFinal;

	}

	// Função principal do programa

	public static void main(String[] args) {

		Random aleatorio = new Random();
		Scanner scanner = new Scanner(System.in);
		String escolhaCPU;
		String escolhaJogador;
		String vencedor;
		String escolhaModo;

//		escolhaModo = getEscolhaModo(scanner);
		Menu();
		escolhaCPU = getEscolhaCPU(aleatorio);
		escolhaJogador = getEscolhaJogador(scanner);
		vencedor = getEscolhaVencedor(escolhaCPU, escolhaJogador);

		System.out.println("\nSua escolha : " + escolhaJogador + "\nEscolha da CPU : " + escolhaCPU);
		System.out.println(vencedor);

	}
}
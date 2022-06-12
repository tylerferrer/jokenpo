package jokenpo;

import java.util.Scanner;

class Jogador {
	private String nome;
	private String escolha;
	private int vitorias;

	Jogador(String n) {
		nome = n;
		vitorias = 0;
	}

// Get no nome do jogador.
	public String getNome() {
		return nome;
	}

// Get na escolha do jogador.
	public String getEscolha() {
		return escolha;
	}

// Get vitórias.
	public int getVitorias() {
		return vitorias;
	}

// Set nome do jogador.
	public void setNome(String n) {
		nome = n.toLowerCase();
	}

// Set escolha do jogador.
	public void setEscolha(String c) {
		escolha = c.toLowerCase();
	}

// Set vitórias.
	public void setVitorias(int rw) {
		vitorias = rw;
	}

// Adiciona vitórias.
	public void adicionaVitorias() {
		vitorias++;
	}

// Get para a entrada do usuário
	public String getEscolhaJogador(Scanner in, String msg) {
		System.out.print(msg);
		try {
			if (in.hasNextLine()) {
				escolha = in.nextLine();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return escolha;
	}
}

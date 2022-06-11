package ppt;

public enum Move {

	PEDRA, PAPEL, TESOURA;

	public int compareMoves(Move otherMove) {
		// Tie
		if (this == otherMove)
			return 0;

		switch (this) {

		// lógica para validar os movimentos
		case PEDRA:
			return (otherMove == TESOURA ? 1 : (otherMove == PAPEL ? -1 : 1));
		case PAPEL:
			return (otherMove == PEDRA ? 1 : (otherMove == TESOURA ? -1 : 1));
		case TESOURA:
			return (otherMove == PAPEL ? 1 : (otherMove == PEDRA ? -1 : 1));
		}
		return 0;

	}

	public static void main(String[] args) {
		PedraPapelTesoura game = new PedraPapelTesoura();
		game.startGame();
	}

}

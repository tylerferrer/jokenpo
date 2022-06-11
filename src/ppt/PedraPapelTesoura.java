package ppt;

public class PedraPapelTesoura {

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
        CPUPontos =0;
        jogadas= 0;

////        int qtdjogador;
//      
//      Scanner input = new Scanner(System.in);
//      System.out.println("Quantos jogadores vão Jogar? ");
//      qtdjogador = input.nextInt();
//      
//      String[] nomes = new String[qtdjogador];
//      
//      for(int i = 0; i<qtdjogador; i++) {
//          System.out.println("Entre com os nome do jogador: " +(i+1));
//          nomes[i] = input.next();
//          }
//          input.close();
//          
    }


    public void startGame() {
        System.out.println("PEDRA, PAPEL, TESOURA!");



        Move userMove = user.getMove();
        Move user2Move = user2.getMove();
        Move computerMove = computer.getMove();


        System.out.println("\n O jogador 1 escolheu " + userMove + ".");
        System.out.println("\n O jogador 2 escolheu " + user2Move + ".");
        System.out.println("O CPU escolheu " + computerMove + ".\n");

        int compareMoves = userMove.compareMoves(user2Move);
        int compareMoves2 = userMove.compareMoves(computerMove);
        int compareMoves3 = computerMove.compareMoves(user2Move);

        switch (compareMoves) {
        case 0: // Empate
            System.out.println("Empate!");
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
            System.out.println("Empate!");
            break;
        case 1:
            System.out.println(userMove + " ganha de " + computerMove + ". Jogador 1 venceu!");
            jogador1Pontos++;
            break;
        case -1:
            System.out.println(user2Move + " ganha de " + computerMove + ". Jogador 2 venceu!");
            jogador2Pontos++;

            break;

        }

        switch (compareMoves3) {
        case 0: // Empate
            System.out.println("Empate!");
            break;
        case 1:
            System.out.println(computerMove + " ganha de " + user2Move + ". CPU venceu!");
            CPUPontos++;
            break;
        case -1:
            System.out.println(computerMove + " ganha de " + userMove + ". CPU venceu!");
            CPUPontos++;

            break;

        }



        jogadas++;

        // Pergunta ao usuário se ele deseja jogar novamente
        if (user.playAgain()) {
            System.out.println();
            startGame();
        } else {
            printGameStats();
        }
    }

    /**
     * Mostra as estatísticas do jogo. Considera os empates como 1/2 de uma vitória 
     * para definir a porcentagem de vitórias.
     */

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

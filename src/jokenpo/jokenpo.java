package jokenpo;

import java.util.Scanner;

class jokenpo {
    
    // Static variables
    static Jogador j1;
    static Jogador j2;
    static Jogador[] jogadores = new Jogador[2];
    
    static Scanner in;
    static String msg1 = "Escolha : 1.Pedra 2.Papel 3.Tesoura 4.Sair: ";
    
    static int limit = 3; // number of rounds
    static boolean stop = false; // set to true to stop game
    
    // Checks all win conditions.
    private static boolean isWin(Jogador j1, Jogador j2) {
        if(j1.getEscolha().equals("pedra")) {
            if(j2.getEscolha().equals("tesoura")) {
                return true;
            } else if(j2.getEscolha().equals("papel")) {
                return false;
            }
        } else if(j1.getEscolha().equals("papel")) {
            if(j2.getEscolha().equals("pedra")) {
                return true;
            } else if(j2.getEscolha().equals("tesoura")) {
                return false;
            }
        } else if(j1.getEscolha().equals("tesoura")) {
            if(j2.getEscolha().equals("papel")) {
                return true;
            } else if(j2.getEscolha().equals("pedra")) {
                return false;
            }
        }
        return false;
    }
    
    // Runs pedrapapeltesoura.
    public static void run() {
        // Main program loop.
        do { 
            for(Jogador p: jogadores) {
                System.out.println(p.getNome() + "'s turn");
                p.setEscolha(p.getUserInput(in, msg1));
            }
            
            // Handles a tie.
            if(j1.getEscolha().equals(j2.getEscolha())) {
                System.out.println("Tie!");
                continue;
            }
            
            // Handle j1/j2 win.
            if(isWin(j1, j2)) {
                System.out.println(j1.getEscolha() + 
                        " beats " + j2.getEscolha());
                j1.incrementVitorias();
            } else if(isWin(j2, j1)) {
                System.out.println(j2.getEscolha() + 
                        " beats " + j1.getEscolha());
                j2.incrementVitorias();
            }
            
            System.out.println();
            
            // Handles game completion.
            if(j1.getVitorias() == limit) {
                System.out.println(j1.getNome() + " wins!");
                stop = true;
            } else if(j2.getVitorias() == limit){
                System.out.println(j2.getNome() + " wins!");
                stop = true;
            }
        } while(!stop);
    }
    
    public static void main(String args[]) {
        // Set jogadores.
        j1 = new Jogador("Jogador 1");
        j2 = new Jogador("Jogador 2");
        
        jogadores[0] = j1;
        jogadores[1] = j2;
        
        in = new Scanner(System.in);
        
        // Run the main program loop.
        try {
            run();
        } catch(Exception e) {
            System.out.println(e);
        } finally {
            in.close();
        }
    }
}
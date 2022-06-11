package ppt;

import java.util.Random;

public class CPU {

    public Move getMove() {


            Move[] escolha = Move.values();
            Random random = new Random();
            int index = random.nextInt(escolha.length);
            return escolha[index];
        }
} 

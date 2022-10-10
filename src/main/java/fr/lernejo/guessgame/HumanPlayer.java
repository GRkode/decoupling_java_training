package fr.lernejo.guessgame;

import fr.lernejo.logger.LoggerFactory;
import fr.lernejo.logger.Logger;

import java.util.Scanner;

public class HumanPlayer implements Player{

    private final Logger logger = LoggerFactory.getLogger("player");

    @Override
    public long askNextGuess() {
        logger.log("Donner un nombre");
        Scanner input = new Scanner(System.in);
        return input.nextLong();
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater == false){
            logger.log("le nombre est plus grand");
        }else{
            logger.log("le nombre est plus petit");
        }
    }
}

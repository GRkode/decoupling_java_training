package fr.lernejo.guessgame;

import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

public class ComputerPlayer implements Player{
    private final Logger logger = LoggerFactory.getLogger("player");
    long min = Long.MIN_VALUE;
    long max = Long.MAX_VALUE;
    @Override
    public long askNextGuess() {
        long number = (max+min)/2;
        return number;
    }

    @Override
    public void respond(boolean lowerOrGreater) {
        if (lowerOrGreater == false){
            logger.log("grand");
            this.min = askNextGuess();
        }else{
            logger.log("petit");
            this.max = askNextGuess();
        }
    }
}

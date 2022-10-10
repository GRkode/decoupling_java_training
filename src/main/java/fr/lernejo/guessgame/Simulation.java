package fr.lernejo.guessgame;

import fr.lernejo.guessgame.Player;
import fr.lernejo.logger.Logger;
import fr.lernejo.logger.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Simulation {

    private final Logger logger = LoggerFactory.getLogger("simulation");
    private final Player player;  //TODO add variable type
    private long numberToGuess; //TODO add variable type

    public Simulation(Player player) {
        this.player = player;
    }

    public void initialize(long numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    /**
     * @return true if the player have guessed the right number
     */
    private boolean nextRound() {
        long userNumberInput = player.askNextGuess();
        if (userNumberInput == numberToGuess){
            logger.log("Félicitation le nombre est trouvé");
            return true;
        }else{
            player.respond(userNumberInput > this.numberToGuess);
            return false;
        }
    }

    public void loopUntilPlayerSucceed(long interMax) {
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < interMax; i++){
            if(this.nextRound() == true ){
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        if(interMax == 1000){
            SimpleDateFormat simpleDate = new SimpleDateFormat("mm:ss.SSS");
            Date date = new Date(totalTime);
            String time = simpleDate.format(date);
            logger.log("Le programme a trouvé le nombre en " + time + "ms");
        }
    }
}

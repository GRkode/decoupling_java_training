package fr.lernejo;

import fr.lernejo.guessgame.HumanPlayer;
import fr.lernejo.guessgame.Simulation;

import java.security.SecureRandom;

public class Launcher {

    public static void main(String[] args) {
        HumanPlayer player = new HumanPlayer();
        Simulation simulator = new Simulation(player);
        SecureRandom random = new SecureRandom();
        long randomNumber = random.nextLong(100);
        simulator.initialize(randomNumber);
        simulator.loopUntilPlayerSucceed();
    }

}

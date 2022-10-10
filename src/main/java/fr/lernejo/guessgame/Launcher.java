package fr.lernejo.guessgame;

import fr.lernejo.guessgame.ComputerPlayer;
import fr.lernejo.guessgame.HumanPlayer;
import fr.lernejo.guessgame.Simulation;

import java.security.SecureRandom;

public class Launcher {

    public static void main(String[] args) {

        SecureRandom random = new SecureRandom();
        if (args[0].equals("-interactive")){
            HumanPlayer player = new HumanPlayer();
            Simulation simulator = new Simulation(player);
            long randomNumber = random.nextLong(100);
            simulator.initialize(randomNumber);
            simulator.loopUntilPlayerSucceed(Long.MAX_VALUE);
        }

        if (args[0].equals("-auto")){
            ComputerPlayer computerPlayer = new ComputerPlayer();
            Simulation simu = new Simulation(computerPlayer);
            if (args[1].length() > 1) {
                try {
                    simu.initialize(Integer.parseInt(args[1]));
                    simu.loopUntilPlayerSucceed(1000);
                }catch (NumberFormatException e){
                    System.out.println(e.getMessage());
                    System.out.println("Veuillez entrer un nombre valide");
                }
            }
        }
    }

}

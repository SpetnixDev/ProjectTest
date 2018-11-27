package net.spetnix.project.modes;

import net.spetnix.project.Game;

import java.util.Random;

public class Challenger extends Mode {
    public Challenger(int rounds, String game, Game g) {
        super(rounds, game, g);
    }

    public void run() {
        Random random = new Random();

        System.out.println("\nWelcome in the Challenger mode : your goal will be to find the combination of the computer. You'll have " + rounds + " rounds to find it.");

        String code = "";
        String userCode;

        for (int i = 0; i < 4; i++) code += String.valueOf(random.nextInt(10));

        System.out.println("The computer created its combination.");

        int round = 1;

        while (round <= rounds) {
            System.out.println("Round : " + round);

            userCode = userGuess();

            if (code.equalsIgnoreCase(userCode)) {
                System.out.println("Congratulations, you found the combination ! You found it in " + round + ((round == 1) ? " round !" : " rounds !"));

                return;
            } else {
                System.out.println("Proposition : " + userCode + " --> " + compareCodes(code, userCode, game));
            }

            round++;
        }

        System.out.println("Sadly, you didn't find the combination which was : " + code);
    }
}

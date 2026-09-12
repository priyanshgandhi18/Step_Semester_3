import java.util.Random;

public class RockPaperScissors {
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void main(String[] args) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        int wins = 0, losses = 0, draws = 0;
        int n = 5;

        System.out.println("Round | Player Move | Computer Move | Result");
        for (int i = 1; i <= n; i++) {
            String playerMove = moves[random.nextInt(moves.length)];
            String computerMove = moves[random.nextInt(moves.length)];
            String result = playRound(playerMove, computerMove);

            if (result.equals("Player Wins")) wins++;
            else if (result.equals("Computer Wins")) losses++;
            else draws++;

            System.out.println("Round " + i + " | " + playerMove + " | " + computerMove + " | " + result);
        }

        double winPercentage = ((double) wins / n) * 100.0;
        System.out.println("\nFinal Summary (after " + n + " rounds)");
        System.out.println("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws + " | Win % = " + winPercentage + "%");
    }
}
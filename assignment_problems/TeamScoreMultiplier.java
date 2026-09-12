public class TeamScoreMultiplier {
    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        playerScores[captainIndex] *= 2.0;
        playerScores[viceCaptainIndex] *= 1.5;
    }

    public static void main(String[] args) {
        double[] scores = {40.0, 55.0, 30.0, 62.0};
        applyMultipliers(scores, 1, 3);
        System.out.println(java.util.Arrays.toString(scores));
    }
}
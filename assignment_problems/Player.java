import java.util.Arrays;

class Player implements Comparable<Player> {
    String name;
    int matchesPlayed;
    double battingAverage;
    boolean injured;
    double fantasyPoints;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
        this.fantasyPoints = battingAverage * matchesPlayed * (injured ? 0.8 : 1.0);
    }

    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    @Override
    public int compareTo(Player other) {
        return Double.compare(other.fantasyPoints, this.fantasyPoints);
    }

    public static String draftAndRank(Player[] players) {
        java.util.List<Player> shortlisted = new java.util.ArrayList<>();
        for (Player p : players) {
            if (isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured)) {
                shortlisted.add(p);
            }
        }
        Player[] draftableArray = shortlisted.toArray(new Player[0]);
        Arrays.sort(draftableArray);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < draftableArray.length; i++) {
            sb.append((i + 1)).append(". ").append(draftableArray[i].name);
            if (i < draftableArray.length - 1) sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };
        System.out.println(draftAndRank(players));
    }
}
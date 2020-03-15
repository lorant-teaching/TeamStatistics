public class MatchStats {

    private String teamOne;
    private String teamTwo;
    private int scoreOne;
    private int scoreTwo;

    public MatchStats(String teamOne, String teamTwo, int scoreOne, int scoreTwo) {
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.scoreOne = scoreOne;
        this.scoreTwo = scoreTwo;
    }

    public String getTeamOne() {
        return teamOne;
    }

    public String getTeamTwo() {
        return teamTwo;
    }

    public int getScoreOne() {
        return scoreOne;
    }

    public int getScoreTwo() {
        return scoreTwo;
    }
}
import java.util.ArrayList;

public class Team {

    private String teamName;
    private int countMatch = 0;
    private int wonMatch = 0;
    private int lostMatch =0;

    public Team (String teamName) {
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void teamCountMatches(ArrayList<MatchStats> listOfMatch) {
        for (MatchStats match : listOfMatch) {
            if (match.getTeamOne().equals(this.teamName) || match.getTeamTwo().equals(this.teamName)) {
                this.countMatch = this.countMatch + 1;
            }
        }
    }

    public int getCountMatch() {
        return countMatch;
    }

    public void teamWonMatches(ArrayList<MatchStats> listOfMatch) {
        for (MatchStats match : listOfMatch) {
            if ((match.getTeamOne().equals(this.teamName)) && (match.getScoreOne() > match.getScoreTwo())) {
                this.wonMatch = this.wonMatch + 1;
            } else if ((match.getTeamTwo().equals(this.teamName)) && (match.getScoreTwo() > match.getScoreOne())) {
                this.wonMatch = this.wonMatch + 1;
            }
        }
    }

    public int getWonMatches() {
        return wonMatch;
    }

    public void teamLostMatches(ArrayList<MatchStats> listOfMatch) {
        for (MatchStats match : listOfMatch) {
            if ((match.getTeamOne().equals(this.teamName)) && (match.getScoreOne() < match.getScoreTwo())) {
                this.lostMatch = this.lostMatch + 1;
            } else if ((match.getTeamTwo().equals(this.teamName)) && (match.getScoreTwo() < match.getScoreOne())) {
                this.lostMatch = this.lostMatch + 1;
            }
        }
    }

    public int getLostMatches() {
        return lostMatch;
    }
}
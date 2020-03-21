import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<MatchStats> listOfMatch = new ArrayList<>();
        ArrayList<String> namesOfTeam = new ArrayList<>();
        ArrayList<Team> listOfTeam = new ArrayList<>();
        Scanner inputName = new Scanner(System.in);

        System.out.print("Enter file name to read: ");
        String fileName = inputName.nextLine();
        String filePath = "DataSource/" + fileName;

        try (Scanner scanner = new Scanner(Paths.get(filePath))) {
            while (scanner.hasNextLine()) {
                String[] currentLine = scanner.nextLine().split(",");
                int scoreOne = Integer.parseInt(currentLine[2]);
                int scoreTwo = Integer.parseInt(currentLine[3]);

                listOfMatch.add(new MatchStats (currentLine[0], currentLine[1], scoreOne, scoreTwo));
                currentLine = null;
            }
        } catch (Exception e) {
            System.out.println("Reading the file " + fileName + " failed.");
        }

        // Creating list of teams
        for (MatchStats match : listOfMatch) {
            if (!(namesOfTeam.contains(match.getTeamOne()))) {
                namesOfTeam.add(match.getTeamOne());
            }
            if (!(namesOfTeam.contains(match.getTeamTwo()))) {
                namesOfTeam.add(match.getTeamTwo());
            }
        }

        // Creating each team as object
        for (String team : namesOfTeam) {
            listOfTeam.add(new Team(team));
        }

        System.out.print("Enter team's name: ");
        String teamName = inputName.nextLine();

        for (Team team : listOfTeam) {
            if (team.getTeamName().equals(teamName)){
                team.teamWonMatches(listOfMatch);
                team.teamLostMatches(listOfMatch);
                team.teamCountMatches(listOfMatch);
                System.out.println("Team " + teamName);
                System.out.println("Games " + team.getCountMatch());
                System.out.println("Won " + team.getWonMatches());
                System.out.println("Lost " + team.getLostMatches());
                break;
            }
        }

    }
}

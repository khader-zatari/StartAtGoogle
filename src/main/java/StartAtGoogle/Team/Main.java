package StartAtGoogle.Team;

public class Main {
    public static void main(String[] args) {
        try {

            Team team1 = new Team("Google", 1, 3, 3, 4);
            Team team2 = Team.createTeam("Google", 1, 3, 3, 4);
            System.out.println(team1);
            System.out.println(team2);
            team1.writeToFile("team.txt");

        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
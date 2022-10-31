package StartAtGoogle.Team;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Player {

    public static void main(String[] args) {
        Player player1 = new Player(Team.playerType.ATTACKER, 1);
        Player player2 = createPlayer(Team.playerType.GOAL_KEEPER, 2);
        System.out.println(player1);
        System.out.println(player2);
    }

    String name;
    Team.playerType position;
    int tShirtNumber;
    int grade;
    List<String> names1 = Arrays.asList("Mohammad", "Khader", "Zatari", "Yazan", "Issa", "Rawya");
    List<String> names2 = Arrays.asList("asaf", "tal", "telaviv", "anas", "hello", "wow");

    public Player(Team.playerType position, int tShirtNumber) {
        NameGenerator nameGenerator = new NameGenerator(names1);
        NameGenerator nameGenerator2 = new NameGenerator(names2);
        this.name = Math.random() > 0.5 ? nameGenerator.generateRandomName() : nameGenerator2.generateRandomName();
        this.position = position;
        this.tShirtNumber = tShirtNumber;
        grade = generateRandomGrade();
    }

    public static Player createPlayer(Team.playerType position, int tShirtNumber) {
        return new Player(position, tShirtNumber);
    }

    public static int generateRandomGrade() {
        return ThreadLocalRandom.current().nextInt(0, 100 + 1);
    }

    @Override
    public String toString() {
        return "name is " + this.name + ", Position is " + this.position + ", Grade is " + this.grade + ", Tshirt Number is " + this.tShirtNumber;
    }
}

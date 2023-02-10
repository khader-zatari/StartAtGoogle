package StartAtGoogle.Team;


import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Team {
    private static Logger logger = LogManager.getLogger(Team.class.getName());

    public enum playerType {GOAL_KEEPER, DEFENDER, MIDFIELDER, ATTACKER}

    String name;
    int goalKeeperCount;
    int defenderCount;
    int midFielderCount;
    int attackerCount;
    List<Player> team = new ArrayList<Player>();
    List<Integer> playersNumbers = new ArrayList<Integer>();

    public Team(String name, int goalKeeperCount, int defenderCount, int midFielderCount, int attackerCount) throws Exception {

        checkIfTeam(goalKeeperCount, defenderCount, midFielderCount, attackerCount);
        this.name = name;
        this.goalKeeperCount = goalKeeperCount;
        this.defenderCount = defenderCount;
        this.midFielderCount = midFielderCount;
        this.attackerCount = attackerCount;


        for (int i = 0; i < goalKeeperCount; i++) {
            team.add(new Player(playerType.GOAL_KEEPER, generateUniqueTshirt(team)));
        }
        for (int i = 0; i < defenderCount; i++) {
            team.add(new Player(playerType.DEFENDER, generateUniqueTshirt(team)));
        }
        for (int i = 0; i < midFielderCount; i++) {
            team.add(new Player(playerType.MIDFIELDER, generateUniqueTshirt(team)));
        }
        for (int i = 0; i < attackerCount; i++) {
            team.add(new Player(playerType.ATTACKER, generateUniqueTshirt(team)));
        }
    }

    public static Team createTeam(String name, int goalKeeperCount, int defenderCount, int midFielderCount, int attackerCount) throws Exception {
        loggerPrint();
        return new Team(name, goalKeeperCount, defenderCount, midFielderCount, attackerCount);
    }

    public static void checkIfTeam(int goalKeeperCount, int defenderCount, int midFielderCount, int attackerCount) throws Exception {

        int teamCount = goalKeeperCount + defenderCount + midFielderCount + attackerCount;

        if (teamCount != 11) {
            throw new Exception("numbers of players should be 11");
        } else if (goalKeeperCount != 1) {
            throw new Exception("number of GoalKepper players should be 1");
        } else if (defenderCount < 2) {
            throw new Exception("numbers of Defender players should be at least 2");
        } else if (midFielderCount < 2) {
            throw new Exception("numbers of mid fielder players should be at least 2");
        } else if (attackerCount < 2) {
            throw new Exception("numbers of attacker players should be at least 2");
        }
    }

    public int generateUniqueTshirt(List<Player> team) {

        boolean findUniqueNumber = false;
        int randomNum = 0;

        while (!findUniqueNumber) {
            randomNum = ThreadLocalRandom.current().nextInt(0, 100 + 1);
            if (!this.playersNumbers.contains(randomNum)) {
                findUniqueNumber = true;
            }

        }
        this.playersNumbers.add(randomNum);
        return randomNum;


    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Team name is: ");
        stringBuilder.append(this.name + "\n");
        for (Player player : this.team) {
            stringBuilder.append("name is ");
            stringBuilder.append(player.name);
            stringBuilder.append(" position is ");
            stringBuilder.append(player.position);
            stringBuilder.append(" grade is ");
            stringBuilder.append(player.grade);
            stringBuilder.append(" tShirtNumber is ");
            stringBuilder.append(player.tShirtNumber);
            stringBuilder.append("\n");

        }

        return stringBuilder.toString();

    }

    public void writeToFile(String fileName) {
        try (PrintWriter out = new PrintWriter(fileName);) {
            out.println(this);
        } catch (Exception exception) {
            System.out.println(exception);
        }

    }

    private static void loggerPrint() {
        logger.fatal("iam dead");
        logger.trace("trace");
    }

    public List<Player> getTeam() {
        return team;
    }
}


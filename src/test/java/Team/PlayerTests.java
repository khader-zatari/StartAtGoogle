package Team;

import StartAtGoogle.Team.Player;
import StartAtGoogle.Team.Team;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTests {
    private static Player player;

    @Test
    void generateRandomGrade_RightBoundry_NoException() {
        int grade = Player.generateRandomGrade();
        assertTrue(grade >= 0 && grade <= 100, "grad should be between 0 and 100");
    }

    @Test
    void constructor_GeneratePlayer_NameNotEmpty() {
        player = new Player(Team.playerType.ATTACKER, 10);
        assertNotSame("", player.getName());
    }

    @Test
    void constructor_GeneratePlayer_PositionNotEmpty() {
        player = new Player(Team.playerType.ATTACKER, 10);
        assertNotSame(null, player.getPosition());
    }

    @Test
    void constructor_GeneratePlayer_GradeNotEmpty() {
        player = new Player(Team.playerType.ATTACKER, 10);
        assertNotSame(null, player.getGrade());
    }

    @Test
    void constructor_GeneratePlayer_TshirtNumberNotEmpty() {
        player = new Player(Team.playerType.ATTACKER, 10);
        assertNotSame(null, player.gettShirtNumber());
    }


}

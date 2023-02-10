package Team;

import StartAtGoogle.Team.Player;
import StartAtGoogle.Team.Team;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TeamTests {
    @Test
    void checkIfTeam_wrongTeamCount_Exception() {

        assertThrows(Exception.class, () -> {
            Team.checkIfTeam(1, 2, 2, 2);
        });
    }

    @Test
    void checkIfTeam_RightTeamCount_itIsTeam() {

        assertDoesNotThrow(() -> {
            Team.checkIfTeam(1, 4, 3, 3);
        });
    }

    @Test
    void checkIfTeam_wrongGkCount_Exception() {

        assertThrows(Exception.class, () -> {
            Team.checkIfTeam(2, 3, 3, 3);
        });

    }

    @Test
    void checkIfTeam_RightGkCount_itIsTeam() {

        assertDoesNotThrow(() -> {
            Team.checkIfTeam(1, 4, 3, 3);
        });
    }

    @Test
    void checkIfTeam_wrongDefenderCount_Exception() {

        assertThrows(Exception.class, () -> {
            Team.checkIfTeam(1, 1, 6, 3);
        });
    }

    @Test
    void checkIfTeam_RightDefenderCount_itIsTeam() {

        assertDoesNotThrow(() -> {
            Team.checkIfTeam(1, 2, 5, 3);
        });
    }

    @Test
    void checkIfTeam_wrongMidFielderCount_Exception() {

        assertThrows(Exception.class, () -> {
            Team.checkIfTeam(1, 6, 1, 3);
        });
    }

    @Test
    void checkIfTeam_RightMidFielderCount_itIsTeam() {

        assertDoesNotThrow(() -> {
            Team.checkIfTeam(1, 5, 2, 3);
        });
    }

    @Test
    void checkIfTeam_wrongAttackerCount_Exception() {

        assertThrows(Exception.class, () -> {
            Team.checkIfTeam(1, 6, 3, 1);
        });
    }

    @Test
    void checkIfTeam_RightAttackerCount_itIsTeam() {

        assertDoesNotThrow(() -> {
            Team.checkIfTeam(1, 5, 3, 2);
        });
    }

    @Test
    void generateUniqueTshirt_RightBoundry() {
        Team team;
        try {
            team = Team.createTeam("toGoogle", 1, 3, 4, 3);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        int randomTshirtNumber = team.generateUniqueTshirt(team.getTeam());
        assertTrue(randomTshirtNumber >= 0 && randomTshirtNumber <= 100);
    }

    @Test
    void TeamMember_RightTeamMember_ItIsTeam() {
        try {
            Team team = Team.createTeam("toGoogle", 1, 3, 3, 4);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}

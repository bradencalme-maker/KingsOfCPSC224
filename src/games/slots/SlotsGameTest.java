package games.slots;
import org.junit.jupiter.api.Test;
import shared.GameSession;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import shared.Player;

public class SlotsGameTest {
    public Player player1 = new Player("Logan");
    public Player player2 = new Player("Braden");
    public Player player3 = new Player("BJ");
    public Player player4 = new Player("Aiden");
    public ArrayList<Player> playerlst = new ArrayList<>();
    public GameSession session;

    public SlotsGameTest() {
        playerlst.add(player1);
        playerlst.add(player2);
        playerlst.add(player3);
        playerlst.add(player4);
        this.session = new GameSession(playerlst);
    }
    
    @Test
    public void testInitialReels() {
        SlotsGame slots = new SlotsGame(this.session);
        String[] expected = {"CHERRY", "BELL", "LEMON"};
        assertArrayEquals(expected, slots.getReels());
    }

    @Test
    public void testValidReelsForLoss() {
        SlotsGame slots = new SlotsGame(this.session);
        slots.updateReelResults("LOSS");

        String[] reels = slots.getReels();
        ArrayList<String> found = new ArrayList<>();
        int unique = 0;
        for (int i = 0; i < reels.length; i++) {
            if (found.contains(reels[i]) == false) {
                unique += 1;
            }
            found.add(reels[i]);
 
        }
        assertEquals(3, unique); 
    }

    @Test
    public void testValidReelsForSmallWin() {
        SlotsGame slots = new SlotsGame(this.session);
        slots.updateReelResults("SMALL_WIN");

        String[] reels = slots.getReels();
        ArrayList<String> found = new ArrayList<>();
        int unique = 0;
        for (int i = 0; i < reels.length; i++) {
            if (found.contains(reels[i]) == false) {
                unique += 1;
            }
            found.add(reels[i]);
 
        }
        assertEquals(2, unique); 
    }

    @Test
    public void testValidReelsForModerateWin() {
        SlotsGame slots = new SlotsGame(this.session);
        slots.updateReelResults("MODERATE_WIN");

        String[] reels = slots.getReels();
        ArrayList<String> found = new ArrayList<>();
        int unique = 0;
        for (int i = 0; i < reels.length; i++) {
            if (found.contains(reels[i]) == false) {
                unique += 1;
            }
            found.add(reels[i]);
 
        }
        assertEquals(1, unique); 
        
        for (int i = 0; i < reels.length; i++) {
            assertNotEquals("SPIKE", reels[i]);
        }
    }

    @Test
    public void testValidReelsForJackpot() {
        SlotsGame slots = new SlotsGame(this.session);
        slots.updateReelResults("JACKPOT");

        String[] reels = slots.getReels();
        ArrayList<String> found = new ArrayList<>();
        int unique = 0;
        for (int i = 0; i < reels.length; i++) {
            if (found.contains(reels[i]) == false) {
                unique += 1;
            }
            found.add(reels[i]);
 
        }
        assertEquals(1, unique); 
        
        for (int i = 0; i < reels.length; i++) {
            assertEquals("SPIKE", reels[i]);
        }
    }
}

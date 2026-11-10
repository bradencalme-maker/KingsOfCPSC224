package games.slots;
import java.util.Random;
import java.util.ArrayList;
import java.util.Collections;
import shared.CreditAndTokenManager;
import shared.GameSession;
import shared.Player;


public class SlotsGame {
    
    private String[] reels = {"CHERRY", "BELL", "LEMON"};
    private String[] REEL_TYPES = {"CHERRY", "BELL", "LEMON", "SEVEN", "SPIKE"};
    private String lastWinType = "LOSS";
    private Random rand = new Random();
    private GameSession gameSession;
    private CreditAndTokenManager manager = new CreditAndTokenManager();

    public SlotsGame(GameSession gameSession) {
        this.gameSession = gameSession;
    }

    /** Gets the current reel configuration */
    public String[] getReels() {
        return this.reels.clone();
    }

    /** Gets the last win that occured on slots */
    public String getLastWinType() {
        return this.lastWinType;
    }

    /** Calculates and returns the winnings of a player after recieving result and bet amount */
    private int calculateWinnings(String result, int betAmount) {
        if (result.equals("LOSS")) {
            return 0;
        }

        if (result.equals("SMALL_WIN")) {
            int payout = (int) Math.round(betAmount * 0.5);
            return payout;
        }

        if (result.equals("MODERATE_WIN")) {
            int payout = (int) Math.round(betAmount * 2);
            return payout;
        }

        if (result.equals("JACKPOT")) {
            int payout = (int) Math.round(betAmount * 5);
            return payout;
        }
        throw new IllegalArgumentException("Invalid result provided!");
    }

    /** Will take the spin result and create a new reels array with
     * a compatible reel arrangement */
    protected void updateReelResults(String result) {
        /** Need to use wrapper class Integer instead of int as ArrayLists 
         * cannot store primitive types */
        ArrayList<Integer> reelTypeInd = new ArrayList<>();

        if (result.equals("LOSS")) {
            while (reelTypeInd.size() < 3) {
                int randomInd = rand.nextInt(5);
                if (reelTypeInd.contains(randomInd) == false) {
                    reelTypeInd.add(randomInd);
                }
            }
        }

        else if (result.equals("SMALL_WIN")) {
            while (reelTypeInd.size() < 2) {
                int randomInd = rand.nextInt(5);
                if (reelTypeInd.contains(randomInd) == false) {
                    reelTypeInd.add(randomInd);
                }
            }
            int duplicate = reelTypeInd.get(0);
            reelTypeInd.add(duplicate);

            /** Shuffles indexes in reelTypeInd
             * Prevents  positions 1 and 3 from always being
             * the duplicate indexes */
            Collections.shuffle(reelTypeInd, rand);
        }

        else if (result.equals("MODERATE_WIN")) {
            int chosen_ind = rand.nextInt(4);
            for (int i = 0; i < 3; i++) {
                reelTypeInd.add(chosen_ind);
            }
        }

        else if (result.equals("JACKPOT")) {
            for (int i = 0; i < 3; i++) {
                reelTypeInd.add(4);
            }
        }

        if (reelTypeInd.size() == 3) {
            this.reels = new String[]{
                REEL_TYPES[reelTypeInd.get(0)],
                REEL_TYPES[reelTypeInd.get(1)],
                REEL_TYPES[reelTypeInd.get(2)],
            };
        }

        else {
            throw new IllegalArgumentException("Invalid result provided!");
        }
    }

    /** Simulates a complete spin of the slots machine.
     * Will determine win type and edit reel configuration and 
     * award winnings to the current player */
    public String[] spin(int betAmount) {
        String winType = "None";
        int spinValue = rand.nextInt(100);

        if (betAmount < 0) {
            throw new IllegalArgumentException("Bet must not be negative!");
        }

        if (spinValue <= 49) {
            winType = "LOSS";
        }

        else if (spinValue <= 74) {
            winType = "SMALL_WIN";
        }

        else if (spinValue <= 89) {
            winType = "MODERATE_WIN";
        }

        else {
            winType = "JACKPOT";
        }

        this.lastWinType = winType;

        this.updateReelResults(winType);
        int winnings = this.calculateWinnings(winType, betAmount);

        Player player = gameSession.getCurrentPlayer();
        manager.awardWinnings(player, winnings);

        return this.getReels();
    }
}
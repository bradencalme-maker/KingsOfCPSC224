package shared;

/** Manages player bets, credits, and play tokens. */
public class CreditAndTokenManager {

    /** Checks if a player has enough credits and tokens to place a bet. */
    public boolean validateBet(int currentPlayerCredits, int currentPlayerTokens, int betAmount) {
        if (currentPlayerTokens > 0 && currentPlayerCredits >= betAmount && betAmount > 0) {
            return true;
        }
        return false;
    } 

    /** Deducts the bet amount and one play token if the bet is valid. */
    public boolean placeBet(Player player, int betAmount) {
        int currentPlayerCredits = player.getCredits();
        int currentPlayerTokens = player.getPlayTokens();

        if (validateBet(currentPlayerCredits, currentPlayerTokens, betAmount)) {
            player.setCredits(currentPlayerCredits - betAmount);
            player.setPlayTokens(currentPlayerTokens - 1);
            return true;
        }
        return false;
    }

    /** Adds positive winnings to the player's credit balance. */
    public void awardWinnings(Player player, int winnings) {
        if (winnings > 0) {
            int currentPlayerCredits = player.getCredits();
            player.setCredits(currentPlayerCredits + winnings);
        }
    }
}

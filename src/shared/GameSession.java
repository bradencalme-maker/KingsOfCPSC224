package shared;

import java.util.ArrayList;

/** Manages player turns and tracks game completion. */
public class GameSession {
    private ArrayList<Player> playerLst;
    private Player currPlayer;
    private int currPlayerIndex;
    private boolean gameFinished;

    /** Creates a game session with 1 to 4 players. */
    public GameSession(ArrayList<Player> playerLst) {
        if (playerLst != null && 0 < playerLst.size() && playerLst.size() <= 4) {
            this.playerLst = playerLst;
        }
        else {
            throw new IllegalArgumentException ("Illegal number of players provided!");
        }
        this.currPlayer = playerLst.get(0);
        this.currPlayerIndex = 0;
        this.gameFinished = false;
    }

    /** Returns the current player. */
    public Player getCurrentPlayer() {
        return this.currPlayer;
    }

    /** Sets the current players quit status to true. */
    public void quitCurrentPlayer() {
        if (gameFinished == false) {
            this.currPlayer.setPlayerQuitStatus(true);
        }
    }

    /** Checks whether the current player has finished. */
    public boolean isPlayerFinished() {
        if (this.currPlayer.getPlayTokens() == 0 || this.currPlayer.getCredits() == 0 || this.currPlayer.getPlayerQuitStatus() == true) {
            return true;
        }
        return false;
    }

    /** Switches to the next player when the current player finishes. */
    public boolean switchCurrentPlayer() {
        if (gameFinished == true) {
            return false;
        }
        if (isPlayerFinished() && this.currPlayerIndex != this.playerLst.size() - 1) {
            this.currPlayerIndex += 1;
            this.currPlayer = playerLst.get(this.currPlayerIndex);
            return true;
        }
        if (isPlayerFinished() && this.currPlayerIndex == this.playerLst.size() - 1) {
            gameFinished = true;
        }
        return false;
    }

    /** Returns whether the entire game has finished. */
    public boolean checkIfGameFinished() {
        return this.gameFinished;
    }
}

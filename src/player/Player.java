package shared;

/** Stores a player's name, credits, and play tokens. */
public class Player {
    private String name;
    private int credits;
    private int playTokens;
    private boolean hasQuit;

    /** Creates a player with default credits and play tokens. */
    public Player(String name) {
        this.name = name;
        this.credits = 1000;
        this.playTokens = 10;
        this.hasQuit = false;

    }

    /** Returns the player's name. */
    public String getName() {
        return this.name;
    }

    /** Returns the player's current credits. */
    public int getCredits() {
        return this.credits;
    }

    /** Returns the player's remaining play tokens. */
    public int getPlayTokens() {
        return this.playTokens;
    }

    /** Returns whether the player has quit. */
    public boolean getPlayerQuitStatus() {
        return this.hasQuit;
    }

    /** Updates the player's credits if the new amount is valid. */
    void setCredits(int newCredits) {
        if (newCredits < 0) {
            throw new IllegalArgumentException(
                "Credits cannot be negative!"
            );
        }
        this.credits = newCredits;
    }

    /** Updates the player's play tokens if the new amount is valid. */
    void setPlayTokens(int newPlayTokens) {
        if (newPlayTokens < 0){
            throw new IllegalArgumentException (
                "Cannot set play tokens below 0!"
            );
        }
        this.playTokens = newPlayTokens;
    }

    /** Updates whether the player has quit. */
    void setPlayerQuitStatus(boolean quitStatus) {
        this.hasQuit = quitStatus;
    }
}

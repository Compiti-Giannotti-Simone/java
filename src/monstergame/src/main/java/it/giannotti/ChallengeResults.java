package it.giannotti;

import java.util.ArrayList;

public class ChallengeResults {

    private Player p1,p2;
    private ArrayList<String> attacks;
    private int winner;

    public ChallengeResults(Player p1, Player p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.attacks = new ArrayList<>();
    }

    public ArrayList<String> getAttacks() {
        return attacks;
    }

    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }

    public int getWinner() {
        return winner;
    }

}

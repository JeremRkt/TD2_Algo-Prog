package TDD;

public class Frame {
    int [] rolls = new int[21];
    public boolean isStrike(int rollIndex) {
        return rolls[rollIndex] == 10;
    }
    public int getStrikeScore(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1] + rolls[rollIndex + 2];
    }


    public int getSpareScore(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1] + rolls[rollIndex + 2];
    }

    public boolean isSpare(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1] == 10;
    }
    public int getPinScore(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1];
    }

}

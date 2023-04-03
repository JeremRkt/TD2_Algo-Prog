package TDD;
import TDD.Frame;

public class Game {

    int [] rolls = new int[21];
    private int currentRoll = 0;
    public Frame frame = new Frame();

    public  void roll(int pins){
        rolls[currentRoll++] = pins;

    }
    public int getScore() {
        int score = 0;
        int rollIndex = 0;

        for (int frameIndex = 0; frameIndex < 10; frameIndex++) {
            if (frame.isStrike(rollIndex)) {
                score += frame.getStrikeScore(rollIndex);
                rollIndex++;
            }else if (frame.isSpare(rollIndex)) {
                score += frame.getSpareScore(rollIndex);
                rollIndex +=2;
            } else {
                score += frame.getPinScore(rollIndex);
                rollIndex += 2;
            }
        }
        return score;
    }


}

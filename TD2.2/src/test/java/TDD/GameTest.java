package TDD;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class GameTest {

    public Game game ;
    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    public void BallInGutter(){
        game = new Game();
        rollMany(0,20);
        Assertions.assertEquals(0,game.getScore() );
    }
    @Test
    public void BallTouchOne(){
        rollMany(1,20);
        Assertions.assertEquals(20,game.getScore());
    }

    @Test
    public void BallSpare(){
        game.roll(5);
        game.roll(5);
        game.roll(3);
        rollMany(0,17);
        Assertions.assertEquals(16, game.getScore());
    }

    @Test
    public  void BallStrike(){
        game.roll(10);
        game.roll(4);
        game.roll(3);
        rollMany(0,16);
        Assertions.assertEquals(24, game.getScore());
    }

    @Test
    public void PerfectGame(){
        rollMany(10,12);
        assertEquals(300, game.getScore());
    }
    private void rollMany(int pins, int rolls){
        for (int i = 0; i < rolls; i++){
            game.roll(pins);
        }
    }
}

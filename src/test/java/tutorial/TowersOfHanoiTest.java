package tutorial;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TowersOfHanoiTest {


    @Test
    public void checkOneDiscMethodWorks() {
        Game game = new Game(1);
        assertThat(game.result()).isEmpty();
        game.play();
        assertThat(game.result()).size().isEqualTo(1);
    }

    @Test
    public void checkTwoDiscsMethodWorks() {
        Game game = new Game(2);
        assertThat(game.result()).isEmpty();
        game.play();
        assertThat(game.result()).containsOnly(1, 2);
    }

    @Test
    public void checkThreeDiscsMethodWorks() {
        Game game = new Game(3);
        assertThat(game.result()).isEmpty();
        game.play();
        assertThat(game.result()).containsOnly(1, 2, 3);
    }

    @Test
    public void checkFourDiscsMethodWorks() {
        Game game = new Game(4);
        assertThat(game.result()).isEmpty();
        game.play();
        assertThat(game.result()).containsOnly(1, 2, 3, 4);
    }

    @Test
    public void checkFiveDiscsMethodWorks() {
        Game game = new Game(5);
        assertThat(game.result()).isEmpty();
        game.play();
        assertThat(game.result()).containsOnly(1, 2, 3, 4, 5);
    }

    @Test
    public void checkEmptyMethodWorks() {
        Game game = new Game(0);
        game.move(0,0);
    }

    @Test
    public void movingDiscToEmptyTower(){
        Game game = new Game(1);
        game.move(0,2);
        assertThat(game.result().size()).isEqualTo(1);
    }

    @Test
    public void movingLargerDiscToSmallerDisc(){
        Game game = new Game(2);
        game.move(0,2);
        game.move(0,2);
        assertThat(game.result()).isEmpty();
    }
}

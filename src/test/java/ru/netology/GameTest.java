package ru.netology;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ru.netology.exceptions.NotRegisteredException;

public class GameTest {

    Player player1 = new Player(1, "Player1", 25);
    Player player2 = new Player(2, "Player2", 40);
    Player player3 = new Player(3, "Player3", 50);
    Player player4 = new Player(4, "Player4", 5);
    Player player5 = new Player(5, "Player5", 50);

    Game game = new Game();

    @Test
    public void findInfoByName() {
        game.register("Player1", player1);

        Player expected = player1;
        Player actual = game.findInfo("Player1");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstPlayerWon() {
        game.register("Player1",player1);
        game.register("Player2",player2);

        int expected = 1;
        int actual = game.round("Player2", "Player1");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondPlayerWon() {
        game.register("Player1",player1);
        game.register("Player2",player2);

        int expected = 2;
        int actual = game.round("Player1", "Player2");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void playersWereEqual() {
        game.register("Player3",player3);
        game.register("Player5",player5);

        int expected = 0;
        int actual = game.round("Player3", "Player5");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstPlayerNotRegistered() {
        game.register("Player1",player1);
        game.register("Player2",player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Player1", "Player3");
        });
    }

    @Test
    public void secondPlayerNotRegistered() {
        game.register("Player1",player1);
        game.register("Player2",player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Player2", "Player4");
        });
    }

    @Test
    public void bothPlayersNotRegistered() {
        game.register("Player4",player4);
        game.register("Player5",player5);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Player3", "Player2");
        });
    }
}
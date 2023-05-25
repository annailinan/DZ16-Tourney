package ru.netology;

import ru.netology.exceptions.NotRegisteredException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {
    HashMap<String, Player> players = new HashMap<>();

    public void register(String name, Player player) {
        players.put(name, player);
    }

    public Player findInfo (String key) {
        return players.get(key);
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = null;
        Player player2 = null;
        for (String key : players.keySet()) {
            if (players.get(key).equals(players.get(playerName1))) {
                player1 = players.get(key);
            }
            if (players.get(key).equals(players.get(playerName2))) {
                player2 = players.get(key);

            }
        }
        if (player1 == null) {
            throw new NotRegisteredException(playerName1);
        }
        if (player2 == null) {
            throw new NotRegisteredException(playerName2);
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }
}
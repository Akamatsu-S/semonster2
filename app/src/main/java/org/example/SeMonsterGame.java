package org.example;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

public class SeMonsterGame {

    HashMap<String, Player> playerMap = new HashMap<>();
    final static Random random = new Random();
    int maxRandomNumber;

    public SeMonsterGame(int maxRandomNumber) {
        this.maxRandomNumber = maxRandomNumber;
    }

    void addPlayer(String playerName, int deckNum) {
        this.playerMap.put(playerName, new Player(createRandomList(deckNum*2, this.maxRandomNumber), playerName));
        Player player = this.playerMap.get(playerName);
        player.drawMonsters();
    }

    void showPlayerDeck(String playerName) {
        System.out.println(this.playerMap.get(playerName));
    }

    void showAllPlayersDeck() {
        for (String key : this.playerMap.keySet()) {
            System.out.println(this.playerMap.get(key));
        }
    }

    public static LinkedList<Integer> createRandomList(int count, int maxRandomNumber) {
        LinkedList<Integer> randNumList = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            randNumList.add(random.nextInt(maxRandomNumber + 1));
        }

        return randNumList;
    }

}
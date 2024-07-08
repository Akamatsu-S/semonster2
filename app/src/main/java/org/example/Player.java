package org.example;

import java.util.ArrayList;
import java.util.LinkedList;

public class Player {
    String name;
    ArrayList<Monster> monsterDeck = new ArrayList<>();
    LinkedList<Integer> randomNumberList;

    Player(LinkedList<Integer> randomList, String playername){
        this.randomNumberList = randomList;
        this.name = playername;
    }

    public void drawMonsters() {
        int size = this.randomNumberList.size()/2;
        for (int i = 0; i < size; i++) {
            this.monsterDeck.add(new Monster(this.randomNumberList.pop(), this.randomNumberList.pop()));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Deck:" + this.name + "\n");
        for (Monster m : this.monsterDeck) {
          sb.append(m);
        }
        return sb.toString();
    }

    public ArrayList<Monster> getMosterDeck() {
        return this.monsterDeck;
    }
}

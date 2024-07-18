package org.example;

import java.util.ArrayList;
import java.util.LinkedList;

import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {
    @Test

    public void DrawMonstersTest() {
        LinkedList<Integer> randomList = new LinkedList<>();
        randomList.add(0); randomList.add(2); randomList.add(1);
        Player player = new Player(randomList, "hoge");
        player.drawMonsters();
        ArrayList<Monster> TestDeck = new ArrayList<>();
        TestDeck.add(new Monster(0, 2));
    }
}
